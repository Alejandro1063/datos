package ejercicio1.modelo;

public class Pelicula {

	
	private String titulo;
	private Integer film_id;
	private Integer longitud;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}
	public Integer getLongitud() {
		return longitud;
	}
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", film_id=" + film_id + ", longitud=" + longitud + "]";
	}

	
}
