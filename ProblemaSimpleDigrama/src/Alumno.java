import java.util.ArrayList;
import java.util.List;

public class Alumno {
	// enborroso
	String nombre, rut;
	List<Asignatura> asignaturas;
	public Alumno( String rut) {
		this.rut = rut;
		this.asignaturas = new ArrayList<Asignatura>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	public String mostrarAlumno() {
		return "Nombre: "+ this.nombre +"\nRut: "+this.rut;
	}
	public String mostrarInfo() {
		String asignaturasText="";
		for(Asignatura A: asignaturas)
		{
			asignaturasText+= A.toString();
		}
		return "Nombre: "+ this.nombre +"\nRut: "+this.rut+"\nAsignaturas: "+asignaturasText;
		
	}
	

	
	
	
}
