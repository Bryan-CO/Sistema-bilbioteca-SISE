package dao.impl;

import java.sql.CallableStatement;
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
import models.SubGenero;

public class LibroDaoImpl implements ILibroDao {

	@Override
	public List<Libro> getLibros() {
		Connection cn = null;
		List<Libro> libros = null;
		try {
			cn = Conexion.getConnection();
			String sql = "SELECT * FROM getLibros()";
			PreparedStatement psmt = cn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			libros = new ArrayList<Libro>();
			while (rs.next()) {
				libros.add(ResultSetToObject(rs));
			}
			rs.close();
			psmt.close();

		} catch (Exception e) {
			System.out.println(e);
			libros = null;
		} finally {
			try {
				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return libros;

	}

	private Libro ResultSetToObject(ResultSet rs) throws SQLException {
		Libro libro = new Libro();

		// Mapeo de atributos básicos
		libro.setLibroId(rs.getInt("libro_id"));
		libro.setSerialNumber(rs.getString("serial_number"));
		libro.setNombre(rs.getString("nombre"));

		// Mapeo de Autor
		Autor autor = new Autor();
		autor.setAutorId(null); // id_autor no está en el ResultSet
		autor.setAutor(rs.getString("autor")); // El nombre del autor está disponible
		libro.setAutor(autor);

		// Mapeo de Idioma, Editorial, Categoría, Subgénero, etc.
		Idioma idioma = new Idioma();
		idioma.setIdiomaId(null); // id_idioma no está en el ResultSet
		libro.setIdioma(idioma);

		Editorial editorial = new Editorial();
		editorial.setEditorialId(null); // id_editorial no está en el ResultSet
		libro.setEditorial(editorial);

		Categoria categoria = new Categoria();
		categoria.setCategoriaId(null); // id_categoria no está en el ResultSet
		libro.setCategoria(categoria);

		SubGenero subgenero = new SubGenero();
		subgenero.setSubgeneroId(null); // id_subgenero no está en el ResultSet
		libro.setSubGenero(subgenero);

		// Otros atributos
		libro.setAnio(rs.getInt("año"));
		libro.setUnidades(rs.getInt("unidades"));
		libro.setCantidadPaginas(rs.getInt("cant_paginas"));
		libro.setImagenUrl(rs.getString("imagen_url"));

		return libro;
	}

	@Override
	public void addLibro(Libro libro) {
		Connection cn = null;
		CallableStatement stmt = null;
		System.out.println("Entrando agregar");
		try {
			// Obtener la conexión
			cn = Conexion.getConnection();

			// Preparar la llamada a la función almacenada
			String sql = "{CALL addLibro(?,?,?,?,?,?,?,?,?,?,?)}";
			stmt = cn.prepareCall(sql);

			// Establecer los parámetros

			stmt.setString(1, libro.getSerialNumber());
			stmt.setString(2, libro.getNombre());
			stmt.setInt(3, libro.getAutor().getAutorId());
			stmt.setInt(4, libro.getAnio());
			stmt.setInt(5, libro.getIdioma().getIdiomaId());
			stmt.setInt(6, libro.getEditorial().getEditorialId());
			stmt.setInt(7, libro.getCategoria().getCategoriaId());
			stmt.setInt(8, libro.getSubGenero().getSubgeneroId());
			stmt.setInt(9, libro.getUnidades());
			stmt.setInt(10, libro.getCantidadPaginas());
			stmt.setString(11, libro.getImagenUrl());
			// Ejecutar la función
			stmt.executeUpdate();

			System.out.println("Libro añadido correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al añadir el libro: " + e.getMessage());

		} finally {
			// Cerrar los recursos
			try {
				if (stmt != null)
					stmt.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	public Libro getLibroForEdit(int id) {
		Libro libro = null;
		String sql = "SELECT * FROM libros WHERE libro_id = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					libro = new Libro();
					libro.setLibroId(rs.getInt("libro_id"));
					libro.setSerialNumber(rs.getString("serial_number"));
					libro.setNombre(rs.getString("nombre"));
					libro.setAnio(rs.getInt("anio"));
					libro.setUnidades(rs.getInt("unidades"));
					libro.setCantidadPaginas(rs.getInt("cant_paginas"));

					// Cargar objetos relacionados
					Autor autor = new Autor();
					autor.setAutorId(rs.getInt("id_autor"));
					libro.setAutor(autor);

					Idioma idioma = new Idioma();
					idioma.setIdiomaId(rs.getInt("id_idioma"));
					libro.setIdioma(idioma);

					Editorial editorial = new Editorial();
					editorial.setEditorialId(rs.getInt("id_editorial"));
					libro.setEditorial(editorial);

					Categoria categoria = new Categoria();
					categoria.setCategoriaId(rs.getInt("id_categoria"));
					libro.setCategoria(categoria);

					SubGenero subGenero = new SubGenero();
					subGenero.setSubgeneroId(rs.getInt("id_subgenero"));
					libro.setSubGenero(subGenero);

					libro.setImagenUrl(rs.getString("imagen_url"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Considera lanzar una excepción personalizada aquí
		}

		return libro;
	}

	@Override
	public void editLibro(Libro libro) {
		Connection cn = null;
		CallableStatement stmt = null;
		try {

			cn = Conexion.getConnection();
			String sql = "{CALL editar_libro(?,?,?,?,?,?,?,?,?,?,?)}";

			stmt.setInt(1, libro.getLibroId());
			stmt.setString(2, libro.getSerialNumber());
			stmt.setString(3, libro.getNombre());
			stmt.setInt(4, libro.getAutor().getAutorId());
			stmt.setInt(5, libro.getAnio());
			stmt.setInt(6, libro.getIdioma().getIdiomaId());
			stmt.setInt(7, libro.getEditorial().getEditorialId());
			stmt.setInt(8, libro.getCategoria().getCategoriaId());
			stmt.setInt(9, libro.getSubGenero().getSubgeneroId());
			stmt.setInt(10, libro.getUnidades());
			stmt.setInt(11, libro.getCantidadPaginas());
			stmt.setString(12, libro.getImagenUrl());

			stmt.executeUpdate();
			System.out.println("Libro Editado correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al EDITAR el libro: " + e.getMessage());

		} finally {
			// Cerrar los recursos
			try {
				if (stmt != null)
					stmt.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public Libro getLibroBySerial() {
		// TODO Auto-generated method stub
		return null;
	}
}
