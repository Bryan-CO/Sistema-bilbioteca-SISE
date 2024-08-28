package controllers;

import java.io.IOException;
import java.util.List;

import dao.impl.AutorDaoImpl;

import interfaces.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
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
	
	public static Controller addAutor= (req ,res)->{
		try {
			Autor autor = new Autor();
			String autores = req.getParameter("txtAutor");
			
			autor.setAutor(autores);
			
			AutorDaoImpl autorDao = new AutorDaoImpl();
			autorDao.addAutor(autor);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	};
}
	

