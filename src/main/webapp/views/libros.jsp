<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de libros</title>
</head>
<body>
	<p>hola</p>
	
	<% List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
                if (listaLibros != null && !listaLibros.isEmpty()) {
                for (Libro lib : listaLibros) {
                %>
                <div class="col-md-4 mt-4">
                        <p class="card-text">
                        <%= lib.getNombre() %>
                        </p>
                </div>
                <% } } else { %>
                  <div class="col">
                    <p>No se encontraron restaurantes.</p>
                  </div>
                  <% } %>
</body>
</html>
