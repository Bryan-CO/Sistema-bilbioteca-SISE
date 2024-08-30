package controllers;

import java.io.IOException;
import java.util.List;

import dao.impl.CategoriaDaoImpl;
import interfaces.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import models.Categoria;

public class categoriaController {
	
	
	public static Controller getAll = (req, res) -> {
        List<Categoria> categorias = new CategoriaDaoImpl().getCategoria();
        req.setAttribute("categoria", categorias);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/libros.jsp");
        try {
            dispatcher.forward(req, res);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    };
}

