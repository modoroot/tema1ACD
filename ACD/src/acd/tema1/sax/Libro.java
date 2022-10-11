package acd.tema1.sax;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String autor;
	private String estado;

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", estado=" + estado + "]";
	}

}
