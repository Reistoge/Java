package Logica;

public class Actividad implements ActividadComponent {
	String nombre;
	String descripcion;

	public Actividad(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	@Override
	public String getDatos() {
		// se necesitan los datos separados por coma.
		return this.nombre + "\t" + this.descripcion;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
