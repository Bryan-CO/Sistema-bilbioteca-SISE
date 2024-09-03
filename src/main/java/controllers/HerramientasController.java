package controllers;

import java.io.IOException;
import java.util.List;

import dao.impl.AutorDaoImpl;
import dao.impl.CategoriaDaoImpl;
import dao.impl.EditorialDaoImpl;
import dao.impl.SubgeneroDaoImpl;
import dao.impl.IdiomaDaoImpl;
import interfaces.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import models.Autor;
import models.Categoria;
import models.Editorial;
import models.Idioma;
import models.Subgenero;

public class HerramientasController {
	public static Controller getAllTools = (req, res) ->{
		List<Autor> autores = new AutorDaoImpl().getAutores();
		List<Categoria> categorias = new CategoriaDaoImpl().getCategorias();
		List<Editorial> editoriales = new EditorialDaoImpl().getEditoriales();
		List<Idioma> idiomas = new IdiomaDaoImpl().getIdiomas();
		List<Subgenero> subgeneros = new SubgeneroDaoImpl().getSubgeneros();
		
		req.setAttribute("autores", autores);
	    req.setAttribute("categorias", categorias);
	    req.setAttribute("editoriales", editoriales);
	    req.setAttribute("idiomas", idiomas);
	    req.setAttribute("subgeneros", subgeneros);
	    
	    RequestDispatcher rq = req.getRequestDispatcher("/views/Herramienta/herramientas.jsp");
		try {
			rq.forward(req,res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
}
