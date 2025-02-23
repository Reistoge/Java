
public abstract class Habitacion {
	String numeroHabitacion,tipoHabitacion;
	float precioPorNoche;
	
	
	
	
	 
	public Habitacion(String numeroHabitacion, String tipoHabitacion, float precioPorNoche) {
		this.numeroHabitacion = numeroHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.precioPorNoche = precioPorNoche;
	}




	public abstract void accept(IVisitor v);




	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}




	public void setNumeroHabitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}




	public String getTipoHabitacion() {
		return tipoHabitacion;
	}




	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}




	public float getPrecioPorNoche() {
		return precioPorNoche;
	}




	public void setPrecioPorNoche(float precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}



 



	 
	 

}
class Sencilla extends Habitacion{
	String desayuno;
	public Sencilla(String numeroHabitacion, String tipoHabitacion, float precioPorNoche) {
		super(numeroHabitacion, tipoHabitacion, precioPorNoche);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(IVisitor v) {
		v.visit(this);
		
	}

	public String getDesayuno() {
		return desayuno;
	}

	public void setDesayuno(String desayuno) {
		this.desayuno = desayuno;
	}
	
	
	
	
}

class Doble extends Habitacion{
	int numeroDeCamas;
	public Doble(String numeroHabitacion, String tipoHabitacion, float precioPorNoche) {
		super(numeroHabitacion, tipoHabitacion, precioPorNoche);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(IVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}

	public int getNumeroDeCamas() {
		return numeroDeCamas;
	}

	public void setNumeroDeCamas(int numeroDeCamas) {
		this.numeroDeCamas = numeroDeCamas;
	}
	
}
class Suite extends Habitacion{
	
	String accesoLounge;
	public Suite(String numeroHabitacion, String tipoHabitacion, float precioPorNoche) {
		super(numeroHabitacion, tipoHabitacion, precioPorNoche);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void accept(IVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}


	public String getAccesoLounge() {
		return accesoLounge;
	}


	public void setAccesoLounge(String accesoLounge) {
		this.accesoLounge = accesoLounge;
	}
	
}
