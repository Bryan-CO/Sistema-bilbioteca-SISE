package dao;

import java.util.List;

import models.Categoria;

public interface ICategoriaDao {
	public void addCategoria(String categoria);
	public List<Categoria> getCategorias();
}
