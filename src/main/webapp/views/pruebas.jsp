<!DOCTYPE html>
<%@page import="models.Libro"%>
<%@page import="java.util.List"%>
<html data-theme="light">
<head>
    <title>Libros</title>
 <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
</head>



<body style="background-color: #fff">
  <div class="container mt-5">
   <h2 class="col-md-4 center">Listado de Catalogos</h2>
   <div class="row">
     <%
     List<Libro> listarLibros = (List<Libro>) request.getAttribute("libros");
        if(listarLibros != null && !listarLibros.isEmpty()){
            for(Libro libro : listarLibros){
     %>
           <div class="col-md-4 mt-4">
            <a  href="/Biblioteca/libros/<%= libro.getNombre()%>">
               <div class="card">
                   <img class="card-img-top" src="<%= libro.getImagenUrl()%>" alt="Imagen del catálogo">
                    <div class="card-body">
                            <h5 class="card-title">Nombre del Libro :<%= libro.getNombre() %></h5>
                            <p class="card-text">Autor: <%= libro.getAutor().getAutor() %></p>
                            <p class="card-text">: <%= libro.getCantidadPaginas() %></p>

                            <!--  a href="sucursales/reservas/ sucursal.getId() " class="btn btn-primary">Hacer Reserva</a-->
                        </div>
               </div>
               </a>
           </div>
           <%
       }
   } else {
       %>
       <div class="col">
           <p>No se Encontraron Catálogos.</p> </div>
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
