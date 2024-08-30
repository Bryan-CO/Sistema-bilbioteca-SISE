-- Eliminar la base de datos si existe y crearla de nuevo
DROP DATABASE IF EXISTS biblioteca_owo;
CREATE DATABASE biblioteca_owo;
\c biblioteca_owo;  -- Conectarse a la base de datos creada

-- Crear tabla de Editoriales
CREATE TABLE Editoriales (
    editorial_id SERIAL PRIMARY KEY,
    editorial VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla de Autores
CREATE TABLE Autores (
    autor_id SERIAL PRIMARY KEY,
    autor VARCHAR(50) NOT NULL
);

-- Crear tabla de Categorias
CREATE TABLE Categorias (
    categoria_id SERIAL PRIMARY KEY,
    categoria VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla de Subgeneros
CREATE TABLE Subgeneros (
    subgenero_id SERIAL PRIMARY KEY,
    subgenero VARCHAR(50) NOT NULL UNIQUE
);

-- Crear tabla de Idiomas
CREATE TABLE Idiomas (
    idioma_id SERIAL PRIMARY KEY,
    idioma VARCHAR(20)
);

-- Crear tabla de Libros
CREATE TABLE Libros (
    libro_id SERIAL PRIMARY KEY,
    serial_number VARCHAR(15) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    id_autor INT NOT NULL REFERENCES Autores(autor_id),
    año INT NOT NULL,
    id_idioma INT NOT NULL REFERENCES Idiomas(idioma_id),
    id_editorial INT NOT NULL REFERENCES Editoriales(editorial_id),
    id_categoria INT NOT NULL REFERENCES Categorias(categoria_id),
    id_subgenero INT NOT NULL REFERENCES Subgeneros(subgenero_id),
    unidades INT NOT NULL,
    cant_paginas INT NOT NULL
);

-- Crear tabla de Clientes
CREATE TABLE Clientes (
    cliente_id SERIAL PRIMARY KEY,
    dni VARCHAR(8) NOT NULL UNIQUE,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    telefono VARCHAR(9) NOT NULL UNIQUE,
    correo VARCHAR(50) NOT NULL UNIQUE,
    direccion VARCHAR(80) NOT NULL,
    fecha_nacimiento DATE NOT NULL
);

-- Crear tabla de Prestamos
CREATE TABLE Prestamos (
    prestamo_id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL REFERENCES Clientes(cliente_id),
    cantidad INT,
    fecha_prestamo TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    fecha_devolucion TIMESTAMPTZ NOT NULL
);

-- Crear tabla de Estado_prestamos
CREATE TABLE Estado_prestamos (
    estado_id SERIAL PRIMARY KEY,
    estado VARCHAR(15)
);

-- Crear tabla de Detalle_prestamos
CREATE TABLE Detalle_prestamos (
    detalle_prestamo_id SERIAL PRIMARY KEY,
    prestamo_id INT NOT NULL REFERENCES Prestamos(prestamo_id),
    libro_id INT NOT NULL REFERENCES Libros(libro_id),
    estado_id INT NOT NULL DEFAULT 2 REFERENCES Estado_prestamos(estado_id),
    unidades INT NOT NULL
);

-- Crear tabla de Devoluciones
CREATE TABLE Devoluciones (
    detalle_prestamo_id INT PRIMARY KEY REFERENCES Detalle_prestamos(detalle_prestamo_id),
    fecha_devolucion TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
