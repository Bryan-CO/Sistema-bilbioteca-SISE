package mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import models.Autor;
import models.Categoria;
import models.Editorial;
import models.Idioma;
import models.Libro;
import models.Subgenero;

public class libroMapper {

	public static List<Libro> hashToLibros(List<Map<String, Object>> lista ) {
		List<Libro> libros = new ArrayList<>();
		for (Map<String, Object> item : lista) {
			Libro libro = new Libro();
			libro.setLibroId((Integer) item.get("libro_id"));
			libro.setSerialNumber((String) item.get("serial_number"));
			libro.setNombre((String) item.get("nombre"));
			
			Autor autor = new Autor();
			autor.setAutorId(Integer.parseInt(item.get("autor_id").toString()));
			autor.setAutor(item.get("autor").toString());
	        libro.setAutor(autor);
			
	        
	        Idioma idioma = new Idioma();
	        idioma.setIdiomaId(Integer.parseInt(item.get("idioma_id").toString()));
	        idioma.setIdioma(item.get("idioma").toString());
	        libro.setIdioma(idioma);
	        
	        
	        Editorial editorial = new Editorial();
	        editorial.setEditorialId(Integer.parseInt(item.get("editorial_id").toString()));
	        editorial.setEditorial(item.get("editorial").toString());
	        libro.setEditorial(editorial);
	        
	        
	        Categoria categoria = new Categoria();
	        categoria.setCategoriaId(Integer.parseInt(item.get("categoria_id").toString()));
	        categoria.setCategoria(item.get("categoria").toString());
	        libro.setCategoria(categoria);
	        
	        Subgenero subgenero = new Subgenero();
		    subgenero.setSubgeneroId(Integer.parseInt(item.get("subgenero_id").toString()));
		    subgenero.setSubgenero(item.get("subgenero").toString());
		    libro.setSubGenero(subgenero);

			libro.setAnio((Integer) item.get("año"));
			libro.setUnidades((Integer) item.get("unidades"));
			libro.setCantidadPaginas((Integer) item.get("cant_paginas"));
			libro.setImagenUrl((String) item.get("imagen_url"));

			libros.add(libro);
		}
		return libros;
	}
	
}
