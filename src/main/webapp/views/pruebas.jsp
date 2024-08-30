<<<<<<< HEAD:src/main/webapp/views/libros.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de libros</title>
<link href="${pageContext.request.contextPath}/views/styles/sidebar.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/views/styles/libros.css"
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
		<a href="principal.html" class="active"> <i data-feather="home"></i>
			<span>Principal</span>
		</a> <a href="libros.html"> <i data-feather="book"></i> <span>Libros</span>
		</a> <a href="herramientas.html"> <i data-feather="tool"></i> <span>Herramientas</span>
		</a> <a href="clientes.html"> <i data-feather="users"></i> <span>Clientes</span>
		</a> <a href="prestamos.html"> <i data-feather="dollar-sign"></i> <span>Prestamos</span>
		</a>
	</div>
	<section class="frame">
		<main class="contenido">
			<%
			List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
			if (listaLibros != null && !listaLibros.isEmpty()) {
				for (Libro lib : listaLibros) {
			%>
			<div class="card has-background-grey-lighter has-text-link-dark">
				<div class="card-image">
					<figure class="image is-3by4">
						<img src="<%=lib.getImagenUrl()%>" alt="Portada de <%=lib.getNombre()%>" style="object-fit: cover; width: 100%; height: 100%;"/>
					</figure>
				</div>
				<a href="${pageContext.request.contextPath}/libros/<%=lib.getLibroId()%>"
					class="card-content">
					<div class="media">
						<div class="media-content">
							<p class="title is-4 has-text-grey"><%=lib.getNombre()%></p>
							<p class="subtitle is-5"><%=lib.getAutor().getAutor()%></p>
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
=======
<!DOCTYPE html>
<%@page import="models.Categoria"%>
<%@page import="java.util.List"%>
<html>
<head>
    <title>Listado de Categoria</title>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
</head>

<body style="background-color: #fff">
<body style="background-color: #fff">
  <div class="container mt-5">
    <h2 class="col-md-4 center">Listado de Categoria</h2>
    <div class="row">
      <%
      List<Categoria> listarCategoria = (List<Categoria>) request.getAttribute("categoria");
      if (listarCategoria != null && !listarCategoria.isEmpty()) {
          for (Categoria categoria : listarCategoria) {
      %>
        <div class="col-md-4 mt-4">
          <div class="card">
            <div class="card-body">
              <p class="card-text">categoria: <%= categoria.getCategoria() %></p>
            </div>
          </div>
        </div>
      <%
          }
      } else {
      %>
        <div class="col">
          <p>No se encontraron autores.</p>
        </div>
      <%
      }
      %>
    </div>
  </div>


  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN60jIeHz"
      crossorigin="anonymous"></script>

</body>
</html>

>>>>>>> arango:src/main/webapp/views/pruebas.jsp
