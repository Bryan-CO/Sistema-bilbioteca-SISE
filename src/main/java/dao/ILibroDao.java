package dao;

import java.util.List;

import models.Libro;



public interface ILibroDao {

		public List<Libro>getLibros();
		public void addLibro(Libro libro);
		public void editLibro(Libro libro);
		public Libro getLibroForId(Integer id);
		public Libro getLibroBySerial();		 
	}


