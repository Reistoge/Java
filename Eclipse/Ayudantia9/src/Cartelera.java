import java.util.ArrayList;
import java.util.List;

public class Cartelera {
	String id;
	List<Pelicula> peliculas;
	String fechaInicio;
	String fechaTermino;
	
	
	public Cartelera(String id, String fechaInicio, String fechaTermino) {
		this.id = id;
		this.peliculas = new ArrayList<Pelicula>();
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
	}
	public String getId() {
		return id;
	}
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public void setId(String id) {
		this.id = id;
	}
}
