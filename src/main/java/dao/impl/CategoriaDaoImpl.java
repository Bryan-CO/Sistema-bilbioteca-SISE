package dao.impl;

import java.sql.SQLException;
import models.Categoria;
import java.util.List;

import config.Conexion;
import dao.ICategoriaDao;
import mappers.categoriaMapper;

public class CategoriaDaoImpl implements ICategoriaDao{

	@Override
	public void addCategoria(String categoria) {
		try {
			Conexion.executeProcedure("addCategoria", new Object[] {categoria});
		} catch (SQLException e) {
			System.err.println("Database error occurred: " + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Categoria> getCategorias() {
		List<Categoria> categorias = null;
		try {
			categorias = categoriaMapper.hashToCategorias(Conexion.executeProcedureWithReturn("getcategorias"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return categorias;
	}

}
