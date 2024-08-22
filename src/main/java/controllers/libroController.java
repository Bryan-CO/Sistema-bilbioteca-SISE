package controllers;

import java.io.IOException;

import interfaces.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
public class libroController{
	public static Controller getAll = (req, res) -> {
		RequestDispatcher rq = req.getRequestDispatcher("/views/libros.jsp");
		try {
			rq.forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public static Controller getById = (req, res) -> {
		RequestDispatcher rq = req.getRequestDispatcher("/views/libros.jsp");
		try {
			rq.forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Get by ID");
	};
	
	public static Controller getAllApi = (req, res) -> {
        // Ejemplo de datos en JSON
	    res.setContentType("application/json");
	    res.setCharacterEncoding("UTF-8");
	    String jsonResponse = "[{\"name\":\"uwu\"},{\"name\":\"oli\"}]";
	    System.out.println(jsonResponse);
	    
        try {
			res.getWriter().write(jsonResponse);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    };
}
