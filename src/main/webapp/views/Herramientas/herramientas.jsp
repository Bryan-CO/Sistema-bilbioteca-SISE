<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/views/styles/sidebar.css"
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
		<a href="${pageContext.request.contextPath}/views/principal.jsp" class="active"> <i data-feather="home"></i>
			<span>Principal</span>
		</a> <a href="${pageContext.request.contextPath}/libros/"> <i data-feather="book"></i> <span>Libros</span>
		</a> <a href="#"> <i data-feather="tool"></i> <span>Herramientas</span>
		</a> <a href="#"> <i data-feather="users"></i> <span>Clientes</span>
		</a> <a href="#"> <i data-feather="dollar-sign"></i> <span>Prestamos</span>
		</a>
	</div>
	<section class="frame">
	</section>
	<script>
		feather.replace()
	</script>
</body>
</html>