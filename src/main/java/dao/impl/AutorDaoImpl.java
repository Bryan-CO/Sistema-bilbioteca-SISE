package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import config.Conexion;
import dao.IAutorDao;
import mappers.autorMapper;
import models.Autor;

public class AutorDaoImpl implements IAutorDao {

	@Override
	public void addAutor(String autor) {
	    try {
	    	Conexion.executeProcedure("insertar_autor", new Object[] {autor});
	    } catch (SQLException e) {
	        System.err.println("Database error occurred: " + e.getMessage());
	        e.printStackTrace();

	    } catch (Exception e) {
	        System.err.println("An unexpected error occurred: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Autor> getAutores() {
		List<Autor> autores = null;
		try {
			List<Map<String, Object>> result = Conexion.executeProcedureWithReturn("getautores");
			autores =  autorMapper.hashToAutores(result);
		}catch(Exception e) {
			System.out.println("ERRORRRR" + e);
		}
		return autores;
	}

	
}
