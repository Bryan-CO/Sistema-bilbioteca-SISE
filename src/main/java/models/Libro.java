package models;

public class Libro {
	private Integer libroId;
	private String serialNumber;
	private String nombre;
	private Autor autor;
	private Integer anio;
	private Idioma idioma;
	private Editorial editorial;
	private Categoria categoria;
	private Subgenero subGenero;
	private Integer unidades;
	private Integer cantidadPaginas;
	private String imagenUrl;
	
	public Integer getLibroId() {
		return libroId;
	}
	public void setLibroId(Integer libroId) {
		this.libroId = libroId;
	}
	public String getSerialNumber() {
		return this.serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Subgenero getSubGenero() {
		return subGenero;
	}
	public void setSubGenero(Subgenero subGenero) {
		this.subGenero = subGenero;
	}
	public Integer getUnidades() {
		return unidades;
	}
	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}
	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}
	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
	
	
	

}
