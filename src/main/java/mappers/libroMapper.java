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
			libro.setLibroId((Integer) item.get("idlibro"));
			libro.setSerialNumber((String) item.get("serialnumber"));
			libro.setNombre((String) item.get("nombre"));
			
			Autor autor = new Autor();
			autor.setAutorId(Integer.parseInt(item.get("idautor").toString()));
			autor.setAutor(item.get("autor").toString());
	        libro.setAutor(autor);
			
	        
	        Idioma idioma = new Idioma();
	        idioma.setIdiomaId(Integer.parseInt(item.get("ididioma").toString()));
	        idioma.setIdioma(item.get("idioma").toString());
	        libro.setIdioma(idioma);
	        
	        
	        Editorial editorial = new Editorial();
	        editorial.setEditorialId(Integer.parseInt(item.get("ideditorial").toString()));
	        editorial.setEditorial(item.get("editorial").toString());
	        libro.setEditorial(editorial);
	        
	        
	        Categoria categoria = new Categoria();
	        categoria.setCategoriaId(Integer.parseInt(item.get("idcategoria").toString()));
	        categoria.setCategoria(item.get("categoria").toString());
	        libro.setCategoria(categoria);
	        
	        Subgenero subgenero = new Subgenero();
		    subgenero.setSubgeneroId(Integer.parseInt(item.get("idsubgenero").toString()));
		    subgenero.setSubgenero(item.get("subgenero").toString());
		    libro.setSubGenero(subgenero);

			libro.setAnio((Integer) item.get("anio"));
			libro.setUnidades((Integer) item.get("unidades"));
			libro.setCantidadPaginas((Integer) item.get("cantpaginas"));
			libro.setImagenUrl((String) item.get("urlimagen"));

			libros.add(libro);
		}
		return libros;
	}
	
}
