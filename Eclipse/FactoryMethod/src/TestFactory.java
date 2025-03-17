import java.util.List;

public class TestFactory {
	public static void main(String[] args) {
		
		// factory te permite crear clases de una manera más estructurada.
		// Consideraciones:
		// factory puede tambien almacenar esas clases que va creando (depende del objetivo)
		// el acceso de factory tambien dependera del objetivo.
		// intenta de que factory se encargue principalmente en la forma que se creen los objetos (SOLID)
		Vehiculo ve1 = VehiculoFactory.getVehiculo("auto", "1234");
		Vehiculo ve2 = VehiculoFactory.getVehiculo("auto", "5346");
		Vehiculo ve3 = VehiculoFactory.getVehiculo("camion", "4321");
		Vehiculo ve4 = VehiculoFactory.getVehiculo("camion", "4321");
		
		
	}
}
class VehiculoFactory{
	
	// esta clase se preocupara solo de crear vehiculos.
	public static Vehiculo getVehiculo(String tipo,String patente) {
		// factory se preocupa de la creacion de las distinas instancias de vehiculos.
		
		if("auto".equalsIgnoreCase(tipo)) return new Auto (patente);
		
		else if("camion".equalsIgnoreCase(tipo)) return new Camion(patente);
		
		else {
			System.out.println("tipo desconocido");
			return null;
		}
	}
	
	
}
abstract class  Vehiculo{
	
	String patente;
	float velocidad;
	boolean prendido;
	public Vehiculo(String patente) {
		this.patente= patente;
		
		
		prendido=true;
	}
	public abstract void acelerar();
	public float getVelocidad() {
		return this.velocidad;
	}
	
	
	
}
class Auto extends Vehiculo{

	public Auto(String patente) {
		super(patente);
		// TODO Auto-generated constructor stub
		this.velocidad=100;
	}

	@Override
	public void acelerar() {
		System.out.println("Auto acelera con velocidad maxima de "+this.velocidad);
		// TODO Auto-generated method stub
		
	}
	
}
class Camion extends Vehiculo{

	public Camion(String patente) {
		super(patente);
		// TODO Auto-generated constructor stub
		this.velocidad=50;
	}

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		System.out.println("Camion acelera con velocidad maxima de "+this.velocidad);
	}
	
}
