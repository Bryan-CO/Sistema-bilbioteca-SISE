<!DOCTYPE html>
<%@ page import="models.Libro" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Libro</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <h1>Editar Libro</h1>

    <form action="${pageContext.request.contextPath}/edit" method="post">
        <!-- Hidden field to spoof the PUT method -->
        <input type="hidden" name="_method" value="PUT">
        
        <input type="hidden" name="id" value="${libro.idLibro}">

        <label for="txtSerialNumber">Número de Serie:</label>
        <input type="text" id="txtSerialNumber" name="txtSerialNumber" value="${libro.serialNumber}" required>
        <br><br>

        <label for="txtNombre">Nombre:</label>
        <input type="text" id="txtNombre" name="txtNombre" value="${libro.nombre}" required>
        <br><br>

        <label for="txtAño">Año:</label>
        <input type="text" id="txtAño" name="txtAño" value="${libro.anio}" required>
        <br><br>

        <label for="txtIdAutor">ID del Autor:</label>
        <input type="text" id="txtIdAutor" name="txtIdAutor" value="${libro.autor.autorId}" required>
        <br><br>

        <label for="txtIdIdioma">ID del Idioma:</label>
        <input type="text" id="txtIdIdioma" name="txtIdIdioma" value="${libro.idioma.idiomaId}" required>
        <br><br>

        <label for="txtIdEditorial">ID de la Editorial:</label>
        <input type="text" id="txtIdEditorial" name="txtIdEditorial" value="${libro.editorial.editorialId}" required>
        <br><br>

        <label for="txtIdCategoria">ID de la Categoría:</label>
        <input type="text" id="txtIdCategoria" name="txtIdCategoria" value="${libro.categoria.categoriaId}" required>
        <br><br>

        <label for="txtIdSubgenero">ID del Subgénero:</label>
        <input type="text" id="txtIdSubgenero" name="txtIdSubgenero" value="${libro.subGenero.subgeneroId}" required>
        <br><br>

        <label for="txtUnidades">Unidades:</label>
        <input type="text" id="txtUnidades" name="txtUnidades" value="${libro.unidades}" required>
        <br><br>

        <label for="txtCantPaginas">Cantidad de Páginas:</label>
        <input type="text" id="txtCantPaginas" name="txtCantPaginas" value="${libro.cantidadPaginas}" required>
        <br><br>

        <input type="submit" value="Actualizar Libro">
    </form>

    <a href="${pageContext.request.contextPath}/libros">Volver a la lista de libros</a>
</body>
</html>

