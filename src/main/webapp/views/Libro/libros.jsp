<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Libro"%>
<!DOCTYPE html>
<html data-theme="light">
<head>
<meta charset="UTF-8">
<title>Listado de libros</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/views/styles/sidebar.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/views/Libro/styles/libros.css"
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
	<input type="checkbox" id="check" class="hidden" checked />
	<label for="check"> <i data-feather="menu" id="btn"></i> <i
		data-feather="x-circle" id="cancel"></i>
	</label>
	<div class="sidebar">
		<header>Menu</header>
		<a href="${pageContext.request.contextPath}/home/"> <i data-feather="home"></i>
			<span>Principal</span>
		</a> <a href="${pageContext.request.contextPath}/libros/" class="active"> <i data-feather="book"></i> <span>Libros</span>
		</a> <a href="${pageContext.request.contextPath}/herramientas/"> <i data-feather="tool"></i> <span>Herramientas</span>
		</a> <a href="#"> <i data-feather="users"></i> <span>Clientes</span>
		</a> <a href="#"> <i data-feather="dollar-sign"></i> <span>Prestamos</span>
		</a>
	</div>
	<section class="frame">
		<main class="contenido">
			<a href="${pageContext.request.contextPath}/libros/new" class="button is-link full">Agregar</a>
			<%
			List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
			if (listaLibros != null && !listaLibros.isEmpty()) {
				for (Libro lib : listaLibros) {
			%>
			<div class="card has-background-grey-lighter has-text-link-dark">
				<a
					href="${pageContext.request.contextPath}/libros/<%=lib.getLibroId()%>">
					<div class="card-image">
						<figure class="image is-3by4">
							<img src="<%=lib.getImagenUrl()%>"
								alt="Portada de <%=lib.getNombre()%>"
								style="object-fit: cover; width: 100%; height: 100%;" />
						</figure>
					</div>
					<div class="card-content">
						<div class="media">
							<div class="media-content">
								<p class="title is-4 has-text-grey"><%=lib.getNombre()%></p>
								<p class="subtitle is-5"><%=lib.getAutor().getAutor()%></p>
							</div>
						</div>
					</div>
				</a>
			</div>
			<%
			}
			} else {
			%>
			<div class="col">
				<p>No se encontraron libros.</p>
			</div>
			<%
			}
			%>
		</main>
	</section>
	<script>
		feather.replace()
	</script>
</body>
</html>
