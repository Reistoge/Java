
public class Reserva {
	
	String nombreHuesped,estado,duracionEstadia;
	Habitacion habitacion;
	float costo;
	 
	
	public Reserva(String[] datos) {
		
		habitacion = GestionReservasSingleton.getInstance().buscarHabitacion(datos[0].strip());
		this.nombreHuesped = datos[1];
		this.estado = datos[2];
		this.duracionEstadia = datos[3];
		 
		costo = habitacion.precioPorNoche*Integer.parseInt(duracionEstadia);
	}
	
	 

	public float getCosto() {
		return costo;
	}



	public void setCosto(float costo) {
		this.costo = costo;
	}



	public Habitacion getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}


	public String getNombreHuesped() {
		return nombreHuesped;
	}
	public void setNombreHuesped(String nombreHuesped) {
		this.nombreHuesped = nombreHuesped;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDuracionEstadia() {
		return duracionEstadia;
	}
	public void setDuracionEstadia(String duracionEstadia) {
		this.duracionEstadia = duracionEstadia;
	}
	 
 
	
	 

}
