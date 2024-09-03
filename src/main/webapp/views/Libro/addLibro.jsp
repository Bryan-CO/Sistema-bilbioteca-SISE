<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Autor"%>
<%@ page import="models.Subgenero"%>
<%@ page import="models.Editorial"%>
<%@ page import="models.Categoria"%>
<%@ page import="models.Idioma"%>
<!DOCTYPE html>
<html data-theme="light">
<head>
<meta charset="UTF-8">
<title>Agregar Libro</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/views/Libro/styles/addLibro.css"
	rel="stylesheet" />
</head>
<body>
	<%
	List<Autor> autores = (List<Autor>) request.getAttribute("autores");
	List<Subgenero> subgeneros = (List<Subgenero>) request.getAttribute("subgeneros");
	List<Editorial> editoriales = (List<Editorial>) request.getAttribute("editoriales");
	List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
	List<Idioma> idiomas = (List<Idioma>) request.getAttribute("idiomas");
	if (autores != null && !autores.isEmpty() && subgeneros != null && !subgeneros.isEmpty() && editoriales != null
			&& !editoriales.isEmpty() && categorias != null && !categorias.isEmpty() && idiomas != null
			&& !idiomas.isEmpty()) {
	%>
	<form action="${pageContext.request.contextPath}/libros" method="post"
		class="form">

		<h2 class="is-size-2 has-text-weight-bold title">Agregar Libro</h2>

		<div class="field">
			<label class="label">Codigo</label>
			<div class="control">
				<input class="input" type="text" placeholder="Ingrese Codigo"
					name="txtSerialNumber">
			</div>
		</div>

		<div class="field">
			<label class="label">Nombre del Libro</label>
			<div class="control">
				<input class="input" type="text" placeholder="Ingrese el nombre"
					name="txtNombre">
			</div>
		</div>

		<div class="field">
			<label class="label">Autor</label>
			<div class="control">
				<div class="select">
					<select name="txtIdAutor">
					<% for(Autor autor: autores) { %>
						<option value="<%=autor.getAutorId()%>"><%=autor.getAutor()%></option>
					<% } %>
					</select>
				</div>
			</div>
		</div>

		<div class="field">
			<label class="label">Año</label>
			<div class="control">
				<input class="input" type="number"
					placeholder="Ingrese el año de lanzamiento" min="1500"
					name="txtAño">
			</div>
		</div>

		<div class="field">
			<label class="label">Idioma</label>
			<div class="control">
				<div class="select">
					<select name="txtIdIdioma">
					<% for(Idioma idioma: idiomas) { %>
						<option value="<%=idioma.getIdiomaId()%>"><%=idioma.getIdioma()%></option>
					<% } %>
					</select>
				</div>
			</div>
		</div>

		<div class="field">
			<label class="label">Editorial</label>
			<div class="control">
				<div class="select">
					<select name="txtIdEditorial">
					<% for(Editorial editorial: editoriales) { %>
						<option value="<%=editorial.getEditorialId()%>"><%=editorial.getEditorial()%></option>
					<% } %>
					</select>
				</div>
			</div>
		</div>

		<div class="field">
			<label class="label">Categoria</label>
			<div class="control">
				<div class="select">
					<select name="txtIdCategoria">
					<% for(Categoria categoria: categorias) { %>
						<option value="<%=categoria.getCategoriaId()%>"><%=categoria.getCategoria()%></option>
					<% } %>
					</select>
				</div>
			</div>
		</div>

		<div class="field">
			<label class="label">Sub-Genero</label>
			<div class="control">
				<div class="select">
					<select name="txtIdSubgenero">
					<% for(Subgenero subgenero: subgeneros) { %>
						<option value="<%=subgenero.getSubgeneroId()%>"><%=subgenero.getSubgenero()%></option>
					<% } %>
					</select>
				</div>
			</div>
		</div>

		<div class="field">
			<label class="label">Unidades</label>
			<div class="control">
				<input class="input" type="number"
					placeholder="Ingrese las unidades disponibles" min="1"
					name="txtUnidades">
			</div>
		</div>
		<div class="field">
			<label class="label">Cantidad de Paginas</label>
			<div class="control">
				<input class="input" type="number"
					placeholder="Ingrese la cantidad de paginas" min="50"
					name="txtCantPaginas">
			</div>
		</div>

		<div class="field full">
			<label class="label">Imagen</label>
			<div class="control">
				<input class="input" type="text"
					placeholder="Ingrese la url de la imagen" name="txtImagenUrl">
			</div>
		</div>

		<div class="field">
			<button class="button is-link">Agregar</button>
		</div>

		<div class="field">
			<a href="${pageContext.request.contextPath}/libros/"
				class="button is-danger">Cancelar</a>
		</div>

	</form>
	<%
	} else {
	%>
	<section style="width: 40vw">
		<article class="message is-danger">
			<div class="message-header">
				<p>No se puede agregar ningun libro</p>
				<button class="delete" aria-label="delete"></button>
			</div>
			<div class="message-body">
				<p>No se puede agregar ningun libro en este momento, no cuenta con alguno de estos campo:
				<ul>
					<li><strong>-</strong> Autor</li>
					<li><strong>-</strong> Idioma</li>
					<li><strong>-</strong> Editorial</li>
					<li><strong>-</strong> Categoria</li>
					<li><strong>-</strong> Subgenero</li>
				<strong>Agrege alguno de los campos anteriormente mencionados y pruebe de nuevo.</strong></p>
				<br>
				<a href="${pageContext.request.contextPath}/libros/" class="button is-danger">Regresar</a>
			</div>
		</article>
	</section>
	<%
	}
	%>
</body>
</html>
