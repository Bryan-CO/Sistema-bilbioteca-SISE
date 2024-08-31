package dao;

import java.util.List;

import models.Autor;

public interface IAutorDao {
	public void addAutor(String autor); // Por lo pronto, ya que esta en standby el tema de si agregar getAutores y demas métodos
	public List<Autor> getAutores();
}
