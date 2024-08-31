package dao;

import java.util.List;

import models.Autor;

public interface IAutorDao {
	public List<Autor>getAutor();
	 void addAutor(Autor autor);
	 Autor getAutor(Integer autorId);
}
