package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


import interfaces.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Router {
	public HttpServletRequest request;
	public HttpServletResponse response;
	private String PREFIX_PARAMETER = "urlParam";
	
	public Router(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hola");
		
		this.request = request;
		this.response = response;
	}
	
	
	public void get(String ruta, Controller controller) {
		if(request.getMethod().equals("GET") && isRouteMatching(ruta)) {
			
			controller.execute(request, response);
		}
	}
	
	public void post(String ruta, Controller controller) {
		if(request.getMethod().equals("POST") && isRouteMatching(ruta)) {
	        controller.execute(request, response);
	    }
	}
	public void put(String ruta, Controller controller) {
	    if ((request.getMethod().equals("POST") && "PUT".equalsIgnoreCase(request.getParameter("_method")))
	        || request.getMethod().equals("PUT")) {
	        if (isRouteMatching(ruta)) {
	            controller.execute(request, response);
	        }
	    }
	}
	
	
	
	private boolean isRouteMatching(String ruta) {
		// Obtengo la ruta ya formateada
		String route = formatRoute();
		
		// Ruta base
		if(route.length() == 1) {
			return ruta.equals(route);
		}
		
		
		// Verificar si la ruta tiene parametros
		List<String> subReqRoute = splitRoute(route);
		List<String> subRuta = splitRoute(ruta);
		
		
		if(containsParameters(subRuta)) {
			// Extraigo los parametros
			Map<Integer, String> indexElementMap = extractParameterIndices(subRuta);
			if(subReqRoute.size() == subRuta.size()) {
				setRequestAttributes(indexElementMap, subReqRoute);
				removeParametersFromRoutes(subReqRoute, subRuta, indexElementMap);
			}
		}
		
		return subReqRoute.equals(subRuta);
	}
	
	private String formatRoute() {		
		// Formatear ruta ignorando el "/"
		String reqRoute = this.request.getPathInfo();
		
		if(reqRoute == null) {
			return "/";
		}
		
		return (reqRoute.length() >= 2 && reqRoute.endsWith("/")) ? 
				reqRoute.substring(0, reqRoute.length() - 1) : 
					reqRoute;
	}
	
	private List<String> splitRoute(String route){
		// Subrutas
		return new ArrayList<>(Arrays.asList(route.split("/")));
	}
	
	private boolean containsParameters(List<String> routeParts) {
		// Valido existencia de parameteros
		return !extractParameterIndices(routeParts).isEmpty();
	}

	private Map<Integer, String> extractParameterIndices(List<String> routeParts){
		Map<Integer, String> indexElementMap = new HashMap<>();
		
		// Extraigo los parametros con el prefijo ":"
		IntStream.range(0, routeParts.size()).forEach(i -> {
			if(routeParts.get(i).startsWith(":")) {
				indexElementMap.put(i, routeParts.get(i));
			}
		});
		
		return indexElementMap;
	}
	
	private void removeParametersFromRoutes(List<String> subReqRoute, List<String> subRuta, Map<Integer, String> indexElementMap) {
		List<Integer> keys = new ArrayList<>(indexElementMap.keySet());
		
		// Ordeno de mayor a menor para evitar errores de indices inexistentes al eliminar
		Collections.sort(keys, Collections.reverseOrder());
		
		// Eliminacion
		keys.forEach(index -> {
			subReqRoute.remove((int) index);
			subRuta.remove((int) index);
		});
	}
	
	 private void setRequestAttributes(Map<Integer, String> mapParameters, List<String> subReqRoute) {
	        mapParameters.forEach((index, element) -> {
	            String nameParam = PREFIX_PARAMETER + element.substring(1).replaceAll(":", "").toUpperCase();
	            String valueParam = subReqRoute.get(index);
	            this.request.setAttribute(nameParam, valueParam);
	        });
	}
	
}