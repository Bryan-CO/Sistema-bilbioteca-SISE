package dao;

import java.util.List;

import models.Libro;



public interface ILibroDao {

		public List<Libro>getLibros();
		public void addLibro();
		public void editLibro();
		public Libro getLibroBySerial();		 
	}


