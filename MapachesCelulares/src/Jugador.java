
public class Jugador {
	String nombre;
	int turno;
	boolean perdio;
	
	public Jugador(String nombre ) {
		 
		this.nombre = nombre;
		this.turno = 0;
		this.perdio=false;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public boolean isPerdio() {
		return perdio;
	}
	public void setPerdio(boolean perdio) {
		this.perdio = perdio;
	}
	
}
