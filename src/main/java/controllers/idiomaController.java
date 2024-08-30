package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.impl.AutorDaoImpl;
import dao.impl.IdiomaDaoImpl;
import interfaces.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

import models.Idioma;

public class idiomaController  {
	public static Controller getAll = (req, res) -> {
        List<Idioma> idiomas = new IdiomaDaoImpl().getIdioma();
        req.setAttribute("idioma", idiomas);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/libros.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (ServletException | IOException e) {
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
	public static Controller addIdioma=(req ,res)->{
		   try {
	            
	            String idiomaNombre = req.getParameter("txtIdioma");

	            if (idiomaNombre != null && !idiomaNombre.trim().isEmpty()) {
	               
	                Idioma idioma = new Idioma();
	                idioma.setIdioma(idiomaNombre);

	          
	                IdiomaDaoImpl idiomaDao = new IdiomaDaoImpl();
	                idiomaDao.addIdioma(idioma);

	             
	                res.sendRedirect(req.getContextPath() + "biblioteca/idioma");
	            } else {
	             
	                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nombre del Idioma no puede estar vacío");
	            }
	        } catch (Exception e) {
	         
	            e.printStackTrace(); 
	            try {
					res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar el Idioma");
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
	        }
	    };
};

	

