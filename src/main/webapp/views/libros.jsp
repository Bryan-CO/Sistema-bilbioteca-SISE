<!DOCTYPE html>
<%@page import="models.Libros"%>
<%@page import="java.util.List"%>
<html>
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
   List<Libros> listarLibros = (List<Libros>) request.getAttribute("libros");
   if(listarLibros != null && !listarLibros.isEmpty()){
       for(Libros libro : listarLibros){
           %>
           <div class="col-md-4 mt-4">
            <a  href="/Biblioteca/libros/<%= libro.getNombre()%>">
               <div class="card">
                   <img class="card-img-top" src="<%= libro.getImagenUrl()%>" alt="Imagen del catálogo">
                   
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
