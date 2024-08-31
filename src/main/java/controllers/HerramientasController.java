package controllers;

import java.util.List;

import dao.impl.AutorDaoImpl;
import dao.impl.CategoriaDaoImpl;
import dao.impl.EditorialDaoImpl;
import dao.impl.SubgeneroDaoImpl;
import dao.impl.IdiomaDaoImpl;
import interfaces.Controller;
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
		
		System.out.println(autores.toString());
		System.out.println(categorias.toString());
		System.out.println(editoriales.toString());
		System.out.println(idiomas.toString());
		System.out.println(subgeneros.toString());
	};
}
