package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.*;

import java.io.IOException;

import controllers.libroController;

/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/biblioteca/*")
public class ServletPrueba extends HttpServlet {
	Router router;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	router = new Router(request, response);
    	
        router.get("/", libroController.getAll);
        router.get("/libros", libroController.getAll);
        router.get("/oli/:id", libroController.getAll);
        router.post("/oli", libroController.addLibro);
        router.get("/oli/:id", libroController.getById);
        router.get("/edit/:id", libroController.getLibroForEdit); // Cargar el libro para editar
        router.put("/edit", libroController.editLibro); 
     // Rutas para API
        router.get("/api/libros", libroController.getAllApi);
    }

}

