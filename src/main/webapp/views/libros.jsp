<!DOCTYPE html>
<html>
<head>
    <title>Libros</title>
    <script>
        async function fetchLibros() {
            try {
                let response = await fetch('api/libros');
                let data = await response.json();
                console.log(data[0].name);
                document.getElementById('libros-list').innerHTML = data.map(libro =>{console.log(libro.name); return '<li>' + libro.name + '</li>';}).join('');
            } catch (error) {
                console.error('Error fetching libros:', error);
            }
        }

        async function fetchLibroById(id) {
            try {
                let response = await fetch(`/biblioteca/api/oli/${id}`);
                let data = await response.json();
                console.log(data);
                document.getElementById('libro-details').innerHTML = `Título: ${data.title}`;
            } catch (error) {
                console.error('Error fetching libro by ID:', error);
            }
        }

        window.onload = function() {
            fetchLibros();
        };
    </script>
</head>
<body>
    <h1>Libros</h1>
    <ul id="libros-list">
    </ul>

    <h2>Detalles del libro</h2>
    <div id="libro-details">
    </div>
</body>
</html>
