<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.Libro"%>
<%
Libro lib = (Libro) request.getAttribute("libro");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle: <%=lib.getNombre()%></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<link href="${pageContext.request.contextPath}/views/styles/libro.css"
	rel="stylesheet" />
</head>
<body>
	<div class="book-detail-container">
        <div class="card book-card">
            <div class="card-image">
                <figure>
                    <img src="<%=lib.getImagenUrl()%>" alt="Portada del Libro">
                </figure>
            </div>
            <div class="card-content">
                <p class="title is-4">Título: <%=lib.getNombre()%></p>
                <p class="subtitle is-6">Serial Number: <%=lib.getSerialNumber()%></p>
                <div class="content book-details">
                    <p><strong>Autor:</strong> <%=lib.getAutor()%></p>
                    <p><strong>Año de Publicación:</strong> <%=lib.getAnio()%></p>
                    <p><strong>Idioma:</strong> <%=lib.getIdioma().getIdioma()%></p>
                    <p><strong>Editorial:</strong> <%=lib.getEditorial().getEditorial()%></p>
                    <p><strong>Categoría:</strong> <%=lib.getCategoria().getCategoria()%></p>
                    <p><strong>Subgénero:</strong> <%=lib.getSubGenero().getSubgenero()%></p>
                    <p><strong>Unidades Disponibles:</strong> <%=lib.getUnidades()%></p>
                    <p><strong>Cantidad de Páginas:</strong> <%=lib.getCantidadPaginas()%></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>