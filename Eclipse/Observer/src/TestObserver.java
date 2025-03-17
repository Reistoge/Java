import java.util.ArrayList;
import java.util.List;

public class TestObserver {

	public static void main(String[] args) {
		
		
		IObservable youtuber1= new Youtuber("Pablo","2134");
		IObserver u1= new Subscriptor("Pedro", "1234");
		IObserver u2= new Subscriptor("Carlos", "8934");
		IObserver u3= new Subscriptor("Juan", "1454");
		IObserver admin= new Administrador("Usuario231", "1454","Jefe");
		IObservable youtuber2= new Youtuber("RubiusOMG","5353");
		// registramos observers.
		youtuber1.registerObserver(u1);
		youtuber1.registerObserver(u2);
		youtuber1.registerObserver(u3);
		youtuber2.registerObserver(admin);
		youtuber2.registerObserver(u3);
		
		// clases que pueden notificar ejecutan el metodo update de cada observador.
		youtuber1.notifyObservers();
		youtuber2.notifyObservers();
		
	}

}

interface IObserver {
	// en este caso queremos que los observadores se les pueda enviar una notificacion.

	void notificacion(String mensaje);
	String mostrarInfo();
}

interface IObservable {
	// estos metodos pueden tener parametros o no en este caso vamos a pedir un subscriptor.
	// esto es todo lo que hacer un usuario observado.
	void registerObserver(IObserver s);

	void removeObserver(IObserver s);

	void notifyObservers();
}

class Subscriptor implements IObserver {
	// un subscriptor observa un youtuber al cual le llegaran notificaciones
	// observa
	String nombre , id;
	public Subscriptor(String n, String id) {
		this.nombre=n;
		this.id=id;
	}
	@Override
	public void notificacion(String mensaje) {
		
		System.out.println(mensaje);
	}
	public String mostrarInfo() {
		return this.nombre;
	}
	 

}
class Administrador implements IObserver {
	// el administrador tambien observara los movimientos del youtuber pero de una manera distinta
	// el observa
	String nombre,id,cargo;
	public Administrador(String string, String string2, String string3) {
		this.nombre=string;
		this.id=string2;
		this.cargo=string3;
	}
	@Override
	public void notificacion(String mensaje) {
		System.out.println("-ADMINISTRADOR-");
		System.out.println(mensaje);
		// funcionalidad extra como poder buscar a ese usuario a partir del mensaje.
		
	}
	@Override
	public String mostrarInfo() {
		return this.nombre;
	}
	 
	
}
class Youtuber implements IObservable {
	// el youtber sube videos y notifica a los usuarios.
	// el youtuber es "observable"
	String nombre, id;
	List<IObserver> subs;

	public Youtuber(String n, String id) {
		this.nombre = n;
		this.id = id;
		subs= new ArrayList<IObserver>();
	};



	@Override
	public void registerObserver(IObserver s) {
		System.out.println(s.mostrarInfo()+" se ha suscrito a " +this.nombre);
		subs.add(s);
	}

	@Override
	public void removeObserver(IObserver s) {
		System.out.println(s.mostrarInfo()+" se ha desuscrito a " +this.nombre);
		subs.remove(s);
	}

	@Override
	public void notifyObservers() {
		for(IObserver s: subs) {
			s.notificacion("Hey "+s.mostrarInfo()+", "+this.nombre+" ha subido un nuevo video !!");
		}
	}
 
}
