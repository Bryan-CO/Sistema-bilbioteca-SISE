<!DOCTYPE html>
<%@page import="models.Autor"%>
<%@page import="java.util.List"%>
<html>
<head>
    <title>Autores</title>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
</head>

<body style="background-color: #fff">
  <div class="container mt-5">
    <h2 class="col-md-4 center">Listado de Autores</h2>
    <div class="row">
      <%
      List<Autor> listarAutor = (List<Autor>) request.getAttribute("autor");
      if (listarAutor != null && !listarAutor.isEmpty()) {
          for (Autor autor : listarAutor) {
      %>
        <div class="col-md-4 mt-4">
          <div class="card">
            <div class="card-body">
              <p class="card-text">Autor: <%= autor.getAutor() %></p>
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

