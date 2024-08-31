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
<link
	href="${pageContext.request.contextPath}/views/Libro/styles/libro.css"
	rel="stylesheet" />
</head>
<body>
	<main class="container">
		<div class="card">
			<div class="card-image">
				<figure class="image is-4by5">
					<img src="<%=lib.getImagenUrl()%>" alt="Placeholder image" />
				</figure>
			</div>
		</div>
		<div class="card">
			<div class="card-content">
				<h2 class="is-size-2 has-text-weight-bold"><%=lib.getNombre()%></h2>
				<div class="content">

					<div class="field">
						<label class="label">Codigo</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getSerialNumber()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Autor</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getAutor().getAutor()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Año de Publicacion</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getAnio()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Idioma</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getIdioma().getIdioma()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Editorial</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getEditorial().getEditorial()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Categoria</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getCategoria().getCategoria()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Sub Genero</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getSubGenero().getSubgenero()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Unidades Disponible</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getUnidades()%>">
						</div>
					</div>

					<div class="field">
						<label class="label">Cantidad de Paginas</label>
						<div class="control">
							<input class="input" type="text" disabled
								value="<%=lib.getCantidadPaginas()%>">
						</div>
					</div>
					
					<div></div>
					
					<div class="field btn">
						<a href="${pageContext.request.contextPath}/libros/" class="button is-link">Regresar</a>
					</div>

				</div>
			</div>
		</div>
	</main>
</body>
</html>
