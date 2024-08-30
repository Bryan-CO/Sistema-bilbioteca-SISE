package controllers;

import java.io.IOException;
import java.util.List;

import dao.impl.AutorDaoImpl;

import interfaces.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import models.Autor;


public class autorController {
	public static Controller getAll = (req, res) -> {
        List<Autor> autores = new AutorDaoImpl().getAutor();
        req.setAttribute("autor", autores);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/libros.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
	};
	
	 
	
	public static Controller addAutor= (req ,res)->{
	     try {
	            
	            String autorNombre = req.getParameter("txtAutor");

	            if (autorNombre != null && !autorNombre.trim().isEmpty()) {
	               
	                Autor autor = new Autor();
	                autor.setAutor(autorNombre);

	          
	                AutorDaoImpl autorDao = new AutorDaoImpl();
	                autorDao.addAutor(autor);

	             
	                res.sendRedirect(req.getContextPath() + "/biblioteca/autor");
	            } else {
	             
	                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nombre del autor no puede estar vacío");
	            }
	        } catch (Exception e) {
	         
	            e.printStackTrace(); 
	            try {
					res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar el autor");
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
	        }
	    };
}
	

