import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestStrategy {
	public static void main(String[] args) {
		// procedemos a usar nuestras estrategias
		 menu();
		
		
	}
	public static void menu() {
		var scan = new Scanner(System.in);
		var personas = new ArrayList<Persona>();
		var opcion="";
		OrdenadorPersonas ordenador= new OrdenadorPersonas();
		while(!opcion.equalsIgnoreCase("0")) {
			System.out.print("Opcion ?:");
			opcion = scan.nextLine().strip();
			System.out.println("cambiando estrategia");
			ordenador.setStrategia(Integer.parseInt(opcion));
			ordenador.strategia.sortAscendant(personas);
			ordenador.strategia.sortDescendant(personas);
		}
	}
}
class OrdenadorPersonas{
	// contexto
	IStrategy strategia;
	public OrdenadorPersonas(){
		strategia=null;
	}
	public IStrategy getStrategia() {
		return strategia;
	}
	// aqui cambiamos la estrategia dependiendo de las opciones !!
	// puede ser tambien en main pero este seria como un factory.
	public void setStrategia(int opcionStrategy) {
		 switch(opcionStrategy) {
		 	case 1:
		 		this.strategia=new OrdenarPorNombre();
		 		break;
		 	case 2:
		 		this.strategia= new OrdenarPorEdad();
		 		break;
		 	case 3:
		 		this.strategia=new OrdenarFactorExtra();
		 		break;
		 	case 4:
		 		this.strategia= new OrdenarPorDinero();
		 		break;
		 }
	}
	
	
}
interface IStrategy {
	// nuestra estrategia soluciona o esta ligada a
	// un cierto contexto, en este caso
	// a ordenar en base al atributo de una persona.
	// todas usaran la lista de personas pero haran
	// cosas distintas para ordenarlas
	void sortAscendant(List<Persona> personas);

	void sortDescendant(List<Persona> personas);

	void clear();

}

class Persona {
	String nombre;
	int edad;
	float dinero;
	List<Videojuego> videojuegos;

	public Persona(String nombre, int edad, float dinero, List<Videojuego> videojuegos) {
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
		this.videojuegos = videojuegos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public List<Videojuego> getVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(List<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}

}

class Videojuego {
	boolean terminado;
	String Titulo;
	float ranking;
	
	
	public Videojuego(boolean terminado, String titulo, float ranking) {
		this.terminado = terminado;
		Titulo = titulo;
		this.ranking = ranking;
	}
	public boolean isTerminado() {
		return terminado;
	}
	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public float getRanking() {
		return ranking;
	}
	public void setRanking(float ranking) {
		this.ranking = ranking;
	}
}

class OrdenarPorNombre implements IStrategy {

	@Override
	public void sortAscendant(List<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("Ordenando por nombre de forma ascendente: ");
	}

	@Override
	public void sortDescendant(List<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("Ordenando por nombre de forma descendente: ");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}

class OrdenarPorEdad implements IStrategy {

	@Override
	public void sortAscendant(List<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("ordenando por edad de manera ascendente: ");
	}

	@Override
	public void sortDescendant(List<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("ordenando por edad de manera descendente: ");

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}

class OrdenarPorDinero implements IStrategy {

	@Override
	public void sortAscendant(List<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("ordenando por cantidad de dinero de manera ascendente: ");
	}

	@Override
	public void sortDescendant(List<Persona> personas) {
		System.out.println("ordenando por cantidad de dinero de manera ascendente: ");
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}

class OrdenarFactorExtra implements IStrategy {

	@Override
	public void sortAscendant(List<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("Se ordena por factor extra (Videojuegos): ");
	}

	@Override
	public void sortDescendant(List<Persona> personas) {
		// TODO Auto-generated method stub
		System.out.println("Se ordena por factor extra (Videojuegos): ");

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
