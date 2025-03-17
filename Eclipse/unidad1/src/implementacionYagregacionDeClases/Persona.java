package implementacionYagregacionDeClases;

public class Persona {
	String nombre,rut;
	int edad;
	
	
	public Persona(int e,String n,String r) {
		edad=e;
		nombre=n;
		rut =r;
		
		
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


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", rut=" + rut + ", edad=" + edad + "]";
	}
	
	
}
