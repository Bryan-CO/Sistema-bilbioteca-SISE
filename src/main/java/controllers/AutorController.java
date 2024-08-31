package controllers;

import dao.impl.AutorDaoImpl;
import interfaces.Controller;
public class AutorController {
	public static Controller addAutor = (req, res) -> {
		new AutorDaoImpl().addAutor("Albert Camus");
	};
	public static Controller getAutores = (req, res) ->{
		System.out.println("LISTA DE AUTORES: ");
		new AutorDaoImpl().getAutores().forEach(autor -> {
			System.out.println("Id: " + autor.getAutorId());
			System.out.println("Autor: " + autor.getAutor());
		});
	};
}
