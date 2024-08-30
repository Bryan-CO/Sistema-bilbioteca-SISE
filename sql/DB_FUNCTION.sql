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

CREATE OR REPLACE FUNCTION addAutor(autor VARCHAR)
RETURNS VOID
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Autores (autor)
    VALUES (autor);
END;
$$;
SELECT addAutor('Mario Vargas Llosa');



// AGREGAR LIBRO

CREATE OR REPLACE FUNCTION public."addLibro"(
	serial_number character varying,
	nombre character varying,
	id_autor integer,
	anio integer,
	id_idioma integer,
	id_editorial integer,
	id_categoria integer,
	id_subgenero integer,
	unidades integer,
	cant_paginas integer,
	imagen_url text
)
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
        anio,
        id_idioma,
        id_editorial,
        id_categoria,
        id_subgenero,
        unidades,
        cant_paginas,
        imagen_url
    ) VALUES (
        serial_number,
        nombre,
        id_autor,
        anio,
        id_idioma,
        id_editorial,
        id_categoria,
        id_subgenero,
        unidades,
        cant_paginas,
        imagen_url
    );
END;
$BODY$;

// EDITAR LIBRO

CREATE OR REPLACE FUNCTION public.editLibro(
	p_id_libro integer,
	p_serial_number character varying,
	p_nombre character varying,
	p_id_autor integer,
	p_anio integer,
	p_id_idioma integer,
	p_id_editorial integer,
	p_id_categoria integer,
	p_id_subgenero integer,
	p_unidades integer,
	p_cant_paginas integer,
	p_imagen_url text
)
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
        anio = p_anio,
        id_idioma = p_id_idioma,
        id_editorial = p_id_editorial,
        id_categoria = p_id_categoria,
        id_subgenero = p_id_subgenero,
        unidades = p_unidades,
        cant_paginas = p_cant_paginas,
        imagen_url = p_imagen_url
    WHERE libro_id = p_id_libro;
END;
$BODY$;

// LISTAR LIBRO

CREATE OR REPLACE FUNCTION public.getlibros(
	)
    RETURNS TABLE(libro_id integer, serial_number character varying, nombre character varying, autor character varying, anio integer, idioma character varying, editorial character varying, categoria character varying, subgenero character varying, unidades integer, cant_paginas integer,imagen_url text)
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
        l.anio,
        i.idioma,
        e.editorial,
        c.categoria,
        s.subgenero,
        l.unidades,
        l.cant_paginas,
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

