//LISTAR AUTOR

CREATE OR REPLACE FUNCTION getAutores()
RETURNS TABLE(autor_id INT, autor VARCHAR) AS $$
BEGIN
    RETURN QUERY
    SELECT a.autor_id, a.autor
    FROM Autores a;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM getAutores();

// AGREGAR AUTOR

CREATE OR REPLACE FUNCTION añadir_autor(autor VARCHAR)
RETURNS VOID
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Autores (autor)
    VALUES (autor);
END;
$$;
SELECT añadir_autor('Mario Vargas Llosa');



// AGREGAR LIBRO

CREATE OR REPLACE FUNCTION public."añadir_libro"(
	serial_number character varying,
	nombre character varying,
	id_autor integer,
	"año" integer,
	id_idioma integer,
	id_editorial integer,
	id_categoria integer,
	id_subgenero integer,
	unidades integer,
	cant_paginas integer)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
    INSERT INTO Libros (
        serial_number,
        nombre,
        id_autor,
        año,
        id_idioma,
        id_editorial,
        id_categoria,
        id_subgenero,
        unidades,
        cant_paginas
    ) VALUES (
        serial_number,
        nombre,
        id_autor,
        año,
        id_idioma,
        id_editorial,
        id_categoria,
        id_subgenero,
        unidades,
        cant_paginas
    );
END;
$BODY$;

// EDITAR LIBRO

CREATE OR REPLACE FUNCTION public.editar_libro(
	p_id_libro integer,
	p_serial_number character varying,
	p_nombre character varying,
	p_id_autor integer,
	"p_año" integer,
	p_id_idioma integer,
	p_id_editorial integer,
	p_id_categoria integer,
	p_id_subgenero integer,
	p_unidades integer,
	p_cant_paginas integer)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
    UPDATE Libros
    SET
        serial_number = p_serial_number,
        nombre = p_nombre,
        id_autor = p_id_autor,
        año = p_año,
        id_idioma = p_id_idioma,
        id_editorial = p_id_editorial,
        id_categoria = p_id_categoria,
        id_subgenero = p_id_subgenero,
        unidades = p_unidades,
        cant_paginas = p_cant_paginas
    WHERE libro_id = p_id_libro;
END;
$BODY$;

// LISTAR LIBRO

CREATE OR REPLACE FUNCTION public.getlibros(
	)
    RETURNS TABLE(libro_id integer, serial_number character varying, nombre character varying, autor character varying, "año" integer, idioma character varying, editorial character varying, categoria character varying, subgenero character varying, unidades integer, cant_paginas integer,imagen_url text)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
    RETURN QUERY
    SELECT
        l.libro_id,
        l.serial_number,
        l.nombre,
        a.autor,
        l.año,
        i.idioma,
        e.editorial,
        c.categoria,
        s.subgenero,
        l.unidades,
        l.cant_paginas
        l.imagen_url
    FROM
        Libros l
    INNER JOIN
        Autores a ON a.autor_id = l.id_autor
    INNER JOIN
        Idiomas i ON i.idioma_id = l.id_idioma
    INNER JOIN
        Editoriales e ON e.editorial_id = l.id_editorial
    INNER JOIN
        Categorias c ON c.categoria_id = l.id_categoria
    INNER JOIN
        Subgeneros s ON s.subgenero_id = l.id_subgenero;
END;
$BODY$;

