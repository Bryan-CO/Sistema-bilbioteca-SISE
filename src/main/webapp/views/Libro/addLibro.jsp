<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="add" method="post" class="form">

		<h2 class="is-size-2 has-text-weight-bold title">Agregar Libro</h2>

		<div class="field">
  		<label class="label">Codigo</label>
  		<div class="control">
    		<input class="input" type="text" placeholder="Ingrese Codigo">
  		</div>
		</div>

		<div class="field">
  		<label class="label">Nombre del Libro</label>
  		<div class="control">
    		<input class="input" type="text" placeholder="Ingrese el nombre">
  		</div>
		</div>

		<div class="field">
  		<label class="label">Autor</label>
  		<div class="control">
    		<div class="select">
      		<select>
        		<option>Select dropdown</option>
        		<option>With options</option>
      		</select>
    		</div>
  		</div>
		</div>

		<div class="field">
  		<label class="label">Año</label>
  		<div class="control">
    		<input class="input" type="number" placeholder="Ingrese el año de lanzamiento" min="1970">
  		</div>
		</div>

		<div class="field">
  		<label class="label">Idioma</label>
  		<div class="control">
    		<div class="select">
      		<select>
        		<option>Select dropdown</option>
        		<option>With options</option>
      		</select>
    		</div>
  		</div>
		</div>

		<div class="field">
  		<label class="label">Editorial</label>
  		<div class="control">
    		<div class="select">
      		<select>
        		<option>Editorial</option>
        		<option>With options</option>
      		</select>
    		</div>
  		</div>
		</div>

		<div class="field">
  		<label class="label">Categoria</label>
  		<div class="control">
    		<div class="select">
      		<select>
        		<option>Select dropdown</option>
        		<option>With options</option>
      		</select>
    		</div>
  		</div>
		</div>

		<div class="field">
  		<label class="label">Sub-Genero</label>
  		<div class="control">
    		<div class="select">
      		<select>
        		<option>Select dropdown</option>
        		<option>With options</option>
      		</select>
    		</div>
  		</div>
		</div>

		<div class="field">
  		<label class="label">Unidades</label>
  		<div class="control">
    		<input class="input" type="number" placeholder="Ingrese las unidades disponibles" min="1">
  		</div>
		</div>
		<div class="field">
  		<label class="label">Cantidad de Paginas</label>
  		<div class="control">
    		<input class="input" type="number" placeholder="Ingrese la cantidad de paginas" min="50">
  		</div>
		</div>

		<div class="field full">
  		<label class="label">Imagen</label>
  		<div class="control">
    		<input class="input" type="text" placeholder="Ingrese la url de la imagen">
  		</div>
		</div>

		<div class="field">
			<a href="" class="button is-link">Agregar</a>
		</div>
		
		<div class="field">
			<a href="${pageContext.request.contextPath}/libros/" class="button is-danger">Cancelar</a>
		</div>

	</form>
</body>
</html>
