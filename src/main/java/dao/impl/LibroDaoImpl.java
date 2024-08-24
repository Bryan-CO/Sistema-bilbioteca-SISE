package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;
import dao.ILibroDao;
import models.Autor;
import models.Categoria;
import models.Editorial;
import models.Idioma;
import models.Libro;
import models.Subgenero;



public class LibroDaoImpl implements ILibroDao{

	
public List<Libro>getLibros(){
		Connection cn = null;
		List<Libro> libros = null;
		try {
			cn = Conexion.getConnection();
			String sql = "SELECT libro_id, serial_number, nombre, id_autor, año, id_idioma, id_editorial, id_categoria, id_subgenero, unidades, cant_paginas, imagen_url FROM Libros";
			PreparedStatement psmt = cn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			libros = new ArrayList<Libro>();
			while(rs.next()) {
				libros.add(ResultSetToObject(rs));
			}
			rs.close();
			psmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			libros=null;
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return libros;
	
	}
    private Libro ResultSetToObject(ResultSet rs ) throws SQLException{
    	Libro libros = new Libro();
    	libros.setLibroId(rs.getInt("libro_id"));
    	libros.setSerialNumber(rs.getString("serial_number"));
    	libros.setNombre(rs.getString("nombre"));
        
    	
    	// autor
    	
    	Autor autor = new Autor();
    	autor.setAutorId(rs.getInt("id_autor"));
    	libros.setAutor(autor);
    	
    	//Idioma 
    	
    	Idioma idioma = new  Idioma();
    	idioma.setIdiomaId(rs.getInt("id_idioma"));
    	libros.setIdioma(idioma);
    	
    	// Editorial 
    	
    	Editorial editorial = new Editorial();
    	editorial.setEditorialId(rs.getInt("id_editorial"));
    	libros.setEditorial(editorial);
    	
    	// Categoria 
    	
    	Categoria categoria = new Categoria();
    	categoria.setCategoriaId(rs.getInt("id_categoria"));
    	libros.setCategoria(categoria);
    	
    	// SubGenero
    	
    	Subgenero subgenero = new Subgenero();
    	subgenero.setSubgeneroId(rs.getInt("id_subgenero"));
    	libros.setSubGenero(subgenero);
    	
    	libros.setAnio(rs.getInt("año"));
    	libros.setUnidades(rs.getInt("unidades"));
    	libros.setCantidadPaginas(rs.getInt("cant_paginas"));
    	libros.setImagenUrl(rs.getString("imagen_url"));
    	
    	return libros;
    	
    	
    	
    	
    }
	@Override
	public void addLibro() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editLibro() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Libro getLibroBySerial() {
		// TODO Auto-generated method stub
		return null;
	}
}
