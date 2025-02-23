import java.util.ArrayList;
import java.util.List;

public class GestionReservasSingleton {

	
	private static GestionReservasSingleton instance;
	List<Habitacion> habitaciones;
	List<Reserva> reservas;
	HabitacionFactory factoryHabitacion;
	IVisitor visitor;
	
	private GestionReservasSingleton() {
		factoryHabitacion = new HabitacionFactory();
		reservas = new ArrayList<Reserva>();
		visitor= new ITarifaVisitor();
		habitaciones = new ArrayList<Habitacion>();
		
	};
	 
	
	public static GestionReservasSingleton getInstance() {
		if(instance== null) {
			instance= new GestionReservasSingleton();
			
		}
		return instance;
 
		
	}
	public void crearHabitacion(String[] datos) {
		 Habitacion nuevaHabitacion= factoryHabitacion.crearHabitacion(datos);
		 if(nuevaHabitacion!=null) {
			 habitaciones.add(nuevaHabitacion);
		 }
		 else {
			 System.out.println("error agregando habitacion");
		 }
	}

	public boolean aplicarTarifa(String numeroHabitacion) {
		Habitacion h = buscarHabitacion(numeroHabitacion);
		
		if(h!=null) {
			System.out.println("aplicando descuento tarifa a la habitacion "+h.getNumeroHabitacion()+" con tarifa de "+h.getPrecioPorNoche());
			h.accept(visitor);
			System.out.println("nueva tarifa es de "+h.getPrecioPorNoche()+" pesos");
			return true;
		}
		else {
			return false;
		}
		
	}

	public Habitacion buscarHabitacion(String numeroHabitacion) {
		// TODO Auto-generated method stub
		for(Habitacion h : habitaciones) {
			if(h.getNumeroHabitacion().equalsIgnoreCase(numeroHabitacion)) {
				return h;
			}
		}
		return null;
	}


	public void calcularDescuentos(String contexto) {
		for(Reserva r : reservas) {
			System.out.println(r.getCosto()+" "+r.getNombreHuesped()+" "+r.getHabitacion().getTipoHabitacion());
		}
		DescuentosStrategy contextoStrategy= new DescuentosStrategy();
		try {
			contextoStrategy.setStrategy(Integer.parseInt(contexto));
			
			for(Reserva r : reservas) {
				contextoStrategy.getStrategy().aplicarDescuento(r);
			}
			
		}
		catch (Exception e) {
			System.out.println("error aplicando descuentos");
		}
		System.out.println("descuentos aplicados ");
		for(Reserva r : reservas) {
			System.out.println(r.getCosto()+" "+r.getNombreHuesped()+" "+r.getHabitacion().getTipoHabitacion());
		}

		
	}
	public void crearReserva(String[] datos) {
		
		Reserva r= new Reserva(datos);
		reservas.add(r);
		
	}
	
}

