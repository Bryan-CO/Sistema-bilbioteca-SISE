<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title></title>
    <link href="${pageContext.request.contextPath}/views/styles/sidebar.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/views/styles/principal.css" rel="stylesheet" />
    <link
      href="https://fonts.googleapis.com/css2?family=Lato&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
      rel="stylesheet"
    />
    <script src="https://unpkg.com/feather-icons"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    <!-- <script src="https://cdn.tailwindcss.com"></script>
    <script>
      tailwind.config = {
        theme: {
          extend: {
            colors: {
              primary: 'hsl(217, 71%, 53%)',
              secondary: 'hsl(48, 100%, 67%)',
            },
          },
        },
      }
    </script> -->
  </head>

  <body class="">
    <input type="checkbox" id="check" class="hidden" checked />
    <label for="check">
      <i data-feather="menu" id="btn"></i>
      <i data-feather="x-circle" id="cancel"></i>
    </label>
    <div class="sidebar">
      <header>Menu</header>
      <a href="${pageContext.request.contextPath}/views/principal.jsp" class="active">
        <i data-feather="home"></i>
        <span>Principal</span>
      </a>
      <a href="${pageContext.request.contextPath}/libros/">
        <i data-feather="book"></i>
        <span>Libros</span>
      </a>
      <a href="#">
        <i data-feather="tool"></i>
        <span>Herramientas</span>
      </a>
      <a href="#">
        <i data-feather="users"></i>
        <span>Clientes</span>
      </a>
      <a href="#">
        <i data-feather="dollar-sign"></i>
        <span>Prestamos</span>
      </a>
    </div>
    <section class="frame">
      <main class="contenido">
        <div class="card has-background-link">
          <div class="card-image">
            <figure class="image is-4by3">
              <img
                src="${pageContext.request.contextPath}/views/img/book.jpg"
                alt="Placeholder image"
              />
            </figure>
          </div>
          <a href="${pageContext.request.contextPath}/libros/" class="card-content">
              <div class="media">
                <div class="media-content">
                  <p class="title is-4 has-text-white-ter">Libros</p>
                </div>
              </div>
          </a>
        </div>
        <div class="card has-background-danger">
          <div class="card-image">
            <figure class="image is-4by3">
              <img
                src="https://t3.ftcdn.net/jpg/03/46/72/02/360_F_346720286_p7xp9Esj45XJOyB2InJHJ8ZLeAD9pR1V.jpg"
                alt="Placeholder image"
              />
            </figure>
          </div>
          <a href="" class="card-content">
              <div class="media">
                <div class="media-content">
                  <p class="title is-4 has-text-white-ter">Clientes</p>
                </div>
              </div>
          </a>
        </div>
        <div class="card has-background-info">
          <div class="card-image">
            <figure class="image is-4by3">
              <img
                src="https://cdn-icons-png.flaticon.com/512/1037/1037442.png"
                alt="Placeholder image"
              />
            </figure>
          </div>
          <a href="" class="card-content">
              <div class="media">
                <div class="media-content">
                  <p class="title is-4 has-text-white-ter">Herramientas</p>
                </div>
              </div>
          </a>
        </div>
        <div class="card has-background-primary">
          <div class="card-image">
            <figure class="image is-4by3">
              <img
                src="https://th.bing.com/th/id/OIP.M39wfE4V4qjcBUK9qpVcywHaHa?rs=1&pid=ImgDetMain"
                alt="Placeholder image"
              />
            </figure>
          </div>
          <a href="" class="card-content">
              <div class="media">
                <div class="media-content">
                  <p class="title is-4 has-text-white-ter">Prestamos</p>
                </div>
              </div>
          </a>
        </div>
      </main>
    </section>
    <script>
      feather.replace()
    </script>
  </body>
</html>
