package controllers;


import java.io.IOException;
import java.util.List;

import dao.impl.LibroDaoImpl;
import interfaces.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import models.Autor;
import models.Categoria;
import models.Editorial;
import models.Idioma;
import models.Libro;
import models.SubGenero;
public class libroController{
	public static Controller getAll = (req, res) -> {
	    List<Libro> libros = new LibroDaoImpl().getLibros(); // Fetch books from DAO
	    req.setAttribute("libros", libros); // Set attribute for JSP

	    RequestDispatcher rq = req.getRequestDispatcher("/views/pruebas.jsp");
	    try {
	        rq.forward(req, res);
	    } catch (ServletException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	};
	
	public static Controller getById = (req, res) -> {
		RequestDispatcher rq = req.getRequestDispatcher("/views/libros.jsp");
		try {
			rq.forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Get by ID");
	};
	public static Controller addLibro = (req, res) -> {
		try {
	        Libro libro = new Libro();

	        String serialNumber = req.getParameter("txtSerialNumber");
	        String nombre = req.getParameter("txtNombre");
	        int idAutor = Integer.parseInt(req.getParameter("txtIdAutor"));
	        int año = Integer.parseInt(req.getParameter("txtAño"));
	        int idIdioma = Integer.parseInt(req.getParameter("txtIdIdioma"));
	        int idEditorial = Integer.parseInt(req.getParameter("txtIdEditorial"));
	        int idCategoria = Integer.parseInt(req.getParameter("txtIdCategoria"));
	        int idSubgenero = Integer.parseInt(req.getParameter("txtIdSubgenero"));
	        int unidades = Integer.parseInt(req.getParameter("txtUnidades"));
	        int cantPaginas = Integer.parseInt(req.getParameter("txtCantPaginas"));
	        String imagenUrl = req.getParameter("txtImagenUrl");

	        libro.setSerialNumber(serialNumber);
	        libro.setNombre(nombre);

	        Autor autor = new Autor();
	        autor.setAutorId(idAutor);
	        libro.setAutor(autor);

	        Idioma idioma = new Idioma();
	        idioma.setIdiomaId(idIdioma);
	        libro.setIdioma(idioma);

	        Editorial editorial = new Editorial();
	        editorial.setEditorialId(idEditorial);
	        libro.setEditorial(editorial);

	        Categoria categoria = new Categoria();
	        categoria.setCategoriaId(idCategoria);
	        libro.setCategoria(categoria);

	        SubGenero subGenero = new SubGenero();
	        subGenero.setSubgeneroId(idSubgenero);
	        libro.setSubGenero(subGenero);

	        libro.setAnio(año);
	        libro.setUnidades(unidades);
	        libro.setCantidadPaginas(cantPaginas);
	        libro.setImagenUrl(imagenUrl);

	        LibroDaoImpl libroDao = new LibroDaoImpl();
	        libroDao.addLibro(libro);

	        res.sendRedirect(req.getContextPath() + "/biblioteca/libros");

	    } catch (Exception e) {
	        e.printStackTrace();
	        try {
	            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al agregar el libro.");
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }
		};
		public static Controller getLibroForId = (req, res) -> {
	        try {
	            String idParam = req.getParameter("id");
	            if (idParam == null || idParam.isEmpty()) {
	                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID del libro no proporcionado.");
	                return;
	            }
	            int id = Integer.parseInt(idParam);

	            LibroDaoImpl libroDao = new LibroDaoImpl();
	            Libro libro = libroDao.getLibroForId(id);

	            if (libro == null) {
	                res.sendError(HttpServletResponse.SC_NOT_FOUND, "Libro no encontrado.");
	                return;
	            }

	            req.setAttribute("libro", libro);
	            req.getRequestDispatcher("/views/libros.jsp").forward(req, res);

	        } catch (NumberFormatException e) {
	            try {
					res.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de libro inválido.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } catch (Exception e) {
	            e.printStackTrace();
	            try {
					res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el libro.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	    };
		public static Controller editLibro = (req, res) -> {
			try {
		        int id = Integer.parseInt(req.getParameter("id"));

		        // Check if book exists
		        LibroDaoImpl libroDao = new LibroDaoImpl();
		        Libro existingLibro = libroDao.getLibroForId(id);
		        if (existingLibro == null) {
		            res.sendError(HttpServletResponse.SC_NOT_FOUND, "Libro no encontrado.");
		            return;
		        }

		        Libro libro = new Libro();
		        libro.setLibroId(id);
		        libro.setSerialNumber(req.getParameter("txtSerialNumber"));
		        libro.setNombre(req.getParameter("txtNombre"));
		        libro.setAnio(Integer.parseInt(req.getParameter("txtAño")));
		        libro.setUnidades(Integer.parseInt(req.getParameter("txtUnidades")));
		        libro.setCantidadPaginas(Integer.parseInt(req.getParameter("txtCantPaginas")));

		        Autor autor = new Autor();
		        autor.setAutorId(Integer.parseInt(req.getParameter("txtIdAutor")));
		        libro.setAutor(autor);

		        Idioma idioma = new Idioma();
		        idioma.setIdiomaId(Integer.parseInt(req.getParameter("txtIdIdioma")));
		        libro.setIdioma(idioma);

		        Editorial editorial = new Editorial();
		        editorial.setEditorialId(Integer.parseInt(req.getParameter("txtIdEditorial")));
		        libro.setEditorial(editorial);

		        Categoria categoria = new Categoria();
		        categoria.setCategoriaId(Integer.parseInt(req.getParameter("txtIdCategoria")));
		        libro.setCategoria(categoria);

		        SubGenero subGenero = new SubGenero();
		        subGenero.setSubgeneroId(Integer.parseInt(req.getParameter("txtIdSubgenero")));
		        libro.setSubGenero(subGenero);

		        libroDao.editLibro(libro);

		        res.sendRedirect(req.getContextPath() + "/biblioteca/libros");

		    } catch (NumberFormatException e) {
		        try {
		            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Datos inválidos proporcionados.");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    } catch (Exception e) {
		        // Handle SQLException (e.g., log error, send generic error message)
		        e.printStackTrace();
		        try {
		            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el libro.");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		  
		    }
		};
	
	
	public static Controller getAllApi = (req, res) -> {
        // Ejemplo de datos en JSON
	    res.setContentType("application/json");
	    res.setCharacterEncoding("UTF-8");
	    String jsonResponse = "[{\"name\":\"uwu\"},{\"name\":\"oli\"}]";
	    System.out.println(jsonResponse);
	    
        try {
			res.getWriter().write(jsonResponse);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    };
    
}
