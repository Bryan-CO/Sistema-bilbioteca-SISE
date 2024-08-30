package dao;

import java.util.List;


import models.Categoria;

public interface ICategoriaDao {
	public void addCategoria();
	public List<Categoria>getCategoria();
	 void addCategoria(Categoria categoria);
}
