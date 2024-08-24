package models;

public class Libros {
	private Integer idLibro;
	private String SerialNumber;
	private String nombre;
	private Autor autor;
	private Integer anio;
	private Idiomas idioma;
	private Editorial editorial;
	private Categoria categoria;
	private SubGenero subGenero;
	private Integer unidades;
	private Integer cantidadPaginas;
	private String imagenUrl;
	
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public String getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
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
	public Idiomas getIdioma() {
		return idioma;
	}
	public void setIdioma(Idiomas idioma) {
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
	public SubGenero getSubGenero() {
		return subGenero;
	}
	public void setSubGenero(SubGenero subGenero) {
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
