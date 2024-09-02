-- Active: 1721449357725@@localhost@5432@sistema_biblioteca1
---------------------- TABLAS ----------------------------

DROP DATABASE IF EXISTS sistema_biblioteca1;
CREATE DATABASE sistema_biblioteca1;
\c sistema_biblioteca1;  -- Conectarse a la base de datos creada

-- Crear tabla de Editoriales
CREATE TABLE Editoriales (
    idEditorial SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla de Autores
CREATE TABLE Autores (
    idAutor SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla de Categorias       TAMBIEN SE LE PUEDE LLAMAR GENERO xd (para PHP)
CREATE TABLE Categorias (
    idCategoria SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla de Subgeneros
CREATE TABLE Subgeneros (
    idSubgenero SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla de Idiomas
CREATE TABLE Idiomas (
    idIdioma SERIAL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL UNIQUE
);

-- Crear tabla de Libros
CREATE TABLE Libros (
    idLibro SERIAL PRIMARY KEY,
    serialNumber VARCHAR(15) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    idAutor INT NOT NULL REFERENCES Autores(idAutor),
    idIdioma INT NOT NULL REFERENCES Idiomas(idIdioma),
    idEditorial INT NOT NULL REFERENCES Editoriales(idEditorial),
    idCategoria INT NOT NULL REFERENCES Categorias(idCategoria),
    idSubgenero INT NOT NULL REFERENCES Subgeneros(idSubgenero),
    anio INT NOT NULL,
    unidades INT NOT NULL,
    cantPaginas INT NOT NULL,
    urlImagen text
);

-- Crear tabla de Clientes
CREATE TABLE Clientes (
    idCliente SERIAL PRIMARY KEY,
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    telefono VARCHAR(9) NOT NULL UNIQUE,
    correo VARCHAR(50) NOT NULL UNIQUE,
    direccion VARCHAR(80) NOT NULL,
    fechaNacimiento DATE NOT NULL
);

-- Crear tabla de Prestamos
CREATE TABLE Prestamos (
    idPrestamo SERIAL PRIMARY KEY,
    idCliente INT NOT NULL REFERENCES Clientes(idCliente),
    cantidad INT,
    fechaPrestamo TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    fechaDevolucion TIMESTAMPTZ NOT NULL
);

-- Crear tabla de Estado_prestamos
CREATE TABLE EstadoPrestamos (
    idEstado SERIAL PRIMARY KEY,
    nombre VARCHAR(15)
);

-- Crear tabla de Detalle_prestamos
CREATE TABLE DetallePrestamos (
    idDetallePrestamo SERIAL PRIMARY KEY,
    idPrestamo INT NOT NULL REFERENCES Prestamos(idPrestamo),
    idLibro INT NOT NULL REFERENCES Libros(idLibro),
    idEstado INT NOT NULL DEFAULT 2 REFERENCES EstadoPrestamos(idEstado),
    unidades INT NOT NULL
);

-- Crear tabla de Devoluciones
CREATE TABLE Devoluciones (
    idDetallePrestamo INT PRIMARY KEY REFERENCES DetallePrestamos(idDetallePrestamo),
    fechaDevolucion TIMESTAMPTZ NOT NULL DEFAULT NOW()
);




---------------------------- PROCEDIMIENTOS Y FUNCIONES -------------------------------



-- LIBRO

CREATE OR REPLACE FUNCTION getlibros(
	)
    RETURNS TABLE(
        libroId integer,
        serialNumber character varying,
        nombre character varying,
        idAutor integer, 
        autor character varying,
        idIdioma integer,
        idioma character varying, 
        idEditorial integer,
        editorial character varying, 
        idCategoria integer,
        categoria character varying, 
        idSubgenero integer,
        subgenero character varying, 
        anio integer,
        unidades integer, 
        cantPaginas integer,
        urlImagen text
    )
    LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT
        l.idLibro,
        l.serialNumber,
        l.nombre,
        a.idAutor,
        a.nombre,
        i.idIdioma,
        i.nombre,
        e.idEditorial,
        e.nombre,
        c.idCategoria,
        c.nombre,
        s.idSubgenero,
        s.nombre,
        l.anio,
        l.unidades,
        l.cantPaginas,
        l.urlImagen
    FROM
        Libros l
    INNER JOIN
        Autores a ON a.idAutor = l.idAutor
    INNER JOIN
        Idiomas i ON i.idIdioma = l.idIdioma
    INNER JOIN
        Editoriales e ON e.idEditorial = l.idEditorial
    INNER JOIN
        Categorias c ON c.idCategoria = l.idCategoria
    INNER JOIN
        Subgeneros s ON s.idSubgenero = l.idSubgenero;
END;
$BODY$;


SELECT * FROM getlibros();


CREATE OR REPLACE PROCEDURE addLibro(
	serialNumber character varying,
	nombre character varying,
	idAutor integer,
	idIdioma integer,
	idEditorial integer,
	idCategoria integer,
	idSubgenero integer,
	anio integer,
	unidades integer,
	cantPaginas integer,
	urlImagen text
)
    LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
    INSERT INTO Libros (
        serialNumber,
        nombre,
        idAutor,
        idIdioma,
        idEditorial,
        idCategoria,
        idSubgenero,
        anio,
        unidades,
        cantPaginas,
        urlImagen
    ) VALUES (
        serialNumber,
        nombre,
        idAutor,
        idIdioma,
        idEditorial,
        idCategoria,
        idSubgenero,
        anio,
        unidades,
        cantPaginas,
        urlImagen
    );
END;
$BODY$;

CALL addlibro('NJANS123', 'Metamorfosis', 1, 1, 1, 1, 1, 1925, 3, 145, null);


-- AUTOR
CREATE OR REPLACE FUNCTION getAutores()
RETURNS TABLE(idAutor INT, nombre VARCHAR) AS $$
BEGIN
    RETURN QUERY
    SELECT a.idAutor, a.nombre
    FROM Autores a;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM getAutores();


CREATE OR REPLACE PROCEDURE addAutor(nombre VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Autores (nombre)
    VALUES (nombre);
END;
$$;
CALL addAutor('Mario Vargas Llosa');


-- CATEGORIA

CREATE OR REPLACE PROCEDURE addCategoria(nombre VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Categorias (nombre)
    VALUES (nombre);
END;
$$;
CALL addcategoria('Terror');

CREATE OR REPLACE FUNCTION getCategorias()
RETURNS TABLE(idCategoria INT, nombre VARCHAR) AS $$
BEGIN
    RETURN QUERY
    SELECT *
    FROM categorias;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM getcategorias();



-- EDITORIAL
CREATE OR REPLACE PROCEDURE addEditorial(nombre VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Editoriales (nombre)
    VALUES (nombre);
END;
$$;

CALL addEditorial('Penguin Random House');

CREATE OR REPLACE FUNCTION getEditoriales()
RETURNS TABLE(idEditorial INT, nombre VARCHAR) AS $$
BEGIN
    RETURN QUERY
    SELECT *
    FROM Editoriales;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM geteditoriales();



-- IDIOMA

CREATE OR REPLACE PROCEDURE addIdioma(nombre VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Idiomas (nombre)
    VALUES (nombre);
END;
$$;

-- Llamada de ejemplo al procedimiento
CALL addIdioma('Español');

CREATE OR REPLACE FUNCTION getIdiomas()
RETURNS TABLE(idIdioma INT, nombre VARCHAR) AS $$
BEGIN
    RETURN QUERY
    SELECT *
    FROM Idiomas;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM getidiomas();


-- SUBGENERO

CREATE OR REPLACE PROCEDURE addSubgenero(nombre VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Subgeneros (nombre)
    VALUES (nombre);
END;
$$;

-- Llamada de ejemplo al procedimiento
CALL addSubgenero('Fantasía Épica');

CREATE OR REPLACE FUNCTION getSubgeneros()
RETURNS TABLE(idSubgenero INT, nombre VARCHAR) AS $$
BEGIN
    RETURN QUERY
    SELECT *
    FROM Subgeneros;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM getsubgeneros();