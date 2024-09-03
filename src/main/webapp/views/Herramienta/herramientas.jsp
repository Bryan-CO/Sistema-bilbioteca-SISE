<%@page import="mappers.autorMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.*"%>
<!DOCTYPE html>
<html data-theme="light">
<head>
<meta charset="UTF-8">
<title>Herramientas</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/views/styles/sidebar.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/views/Herramienta/styles/herramientas.css"
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap"
	rel="stylesheet" />
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet" />
<script src="https://unpkg.com/feather-icons"></script>
<script
	src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
</head>
<body>

	<%
	List<Autor> autores = (List<Autor>) request.getAttribute("autores");
	List<Idioma> idiomas = (List<Idioma>) request.getAttribute("idiomas");
	List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
	List<Editorial> editoriales = (List<Editorial>) request.getAttribute("editoriales");
	List<Subgenero> subgeneros = (List<Subgenero>) request.getAttribute("subgeneros");
	%>

	<input type="checkbox" id="check" class="hidden" checked />
	<label for="check"> <i data-feather="menu" id="btn"></i> <i
		data-feather="x-circle" id="cancel"></i>
	</label>
	<div class="sidebar">
		<header>Menu</header>
		<a href="${pageContext.request.contextPath}/home/"> <i
			data-feather="home"></i> <span>Principal</span>
		</a> <a href="${pageContext.request.contextPath}/libros/"> <i
			data-feather="book"></i> <span>Libros</span>
		</a> <a href="${pageContext.request.contextPath}/herramientas/"
			class="active"> <i data-feather="settings-2"></i> <span>Herramientas</span>
		</a> <a href="#"> <i data-feather="users"></i> <span>Clientes</span>
		</a> <a href="#"> <i data-feather="dollar-sign"></i> <span>Prestamos</span>
		</a>
	</div>
	<section class="frame">
		<main class="contenido">
			<section>
				<h2>Autores</h2>
				<table class="table is-bordered">
					<tr class="is-link">
						<th>Nombre</th>
					</tr>
					<%
					if (autores != null && !autores.isEmpty()) {
						for (Autor item : autores) {
					%>
					<tr>
						<td><%=item.getAutor()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td>No se encontraron autores</td>
					</tr>
					<%
					}
					%>
				</table>
			</section>

			<section>
				<h2>Editoriales</h2>
				<table class="table is-bordered">
					<tr class="is-link">
						<th>Nombre</th>
					</tr>
					<%
					if (editoriales != null && !editoriales.isEmpty()) {
						for (Editorial item : editoriales) {
					%>
					<tr>
						<td><%=item.getEditorial()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td>No se encontraron autores</td>
					</tr>
					<%
					}
					%>
				</table>
			</section>

			<section>
				<h2>Categorias</h2>
				<table class="table is-bordered">
					<tr class="is-link">
						<th>Nombre</th>
					</tr>
					<%
					if (categorias != null && !categorias.isEmpty()) {
						for (Categoria item : categorias) {
					%>
					<tr>
						<td><%=item.getCategoria()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td>No se encontraron categorias</td>
					</tr>
					<%
					}
					%>
				</table>
			</section>

			<section>
				<h2>Subgeneros</h2>
				<table class="table is-bordered">
					<tr class="is-link">
						<th>Nombre</th>
					</tr>
					<%
					if (subgeneros != null && !subgeneros.isEmpty()) {
						for (Subgenero item : subgeneros) {
					%>
					<tr>
						<td><%=item.getSubgenero()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td>No se encontraron subgeneros</td>
					</tr>
					<%
					}
					%>
				</table>
			</section>

			<section>
				<h2>Idiomas</h2>
				<table class="table is-bordered">
					<tr class="is-link">
						<th>Nombre</th>
					</tr>
					<%
					if (idiomas != null && !idiomas.isEmpty()) {
						for (Idioma item : idiomas) {
					%>
					<tr>
						<td><%=item.getIdioma()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td>No se encontraron idiomas</td>
					</tr>
					<%
					}
					%>
				</table>
			</section>
		</main>
	</section>
	<script>
		feather.replace()
	</script>
</body>
</html>
