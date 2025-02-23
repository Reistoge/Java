package IntentoPrueba1;

public class Rol {
	String fechaInicio;
	String fechaFinal;
	String nombre;
	String unidad;
	
	Persona P;
	public Rol(String fechaInicio, String fechaFinal, String nombre,String unidad, Persona p) {
		this.unidad=unidad;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.nombre = nombre;
		P = p;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Persona getP() {
		return P;
	}
	public void setP(Persona p) {
		P = p;
	}
	 
	@Override
	public String toString() {
		return "Rol [fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", nombre=" + nombre + ", P=" + P.nombre				+ "]";
	}
	@Override
	public boolean equals(Object o) {
		Rol r= (Rol) o;
		if(r.nombre.equals(this.nombre)&& r.unidad.equals(this.nombre)&& r.fechaInicio.equals(this.fechaInicio) && r.fechaFinal.equals(this.fechaFinal)) {
			return false;
		}
		return false;
		
	}
	
	
	
	
}
