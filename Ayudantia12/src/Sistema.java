import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sistema {

	List<Atraccion> atracciones = new ArrayList<Atraccion>();
	List<Visitante> visitantes = new ArrayList<Visitante>();
	private static Sistema instance;

	private Sistema() {

	}

	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}

	public Atraccion getAtraccion(String nombre) {
		// TODO Auto-generated method stub
		for (Atraccion a : atracciones) {
			if (a.getNombre().equalsIgnoreCase(nombre)) {
				return a;
			}
		}
		return atracciones.get(0);
		
	}

}

class AtraccionFactory {

	public AtraccionFactory() {

	}

	public void crearAtraccion(String[] datos) {
		String nombre = datos[0];
		String tipo = datos[1];
		String edadMinima = datos[2];
		String cantMaxima = datos[3];
		if (tipo.equalsIgnoreCase("montañarusa")) {
			Atraccion m = new MontañaRusa(nombre, tipo, edadMinima, cantMaxima);
			Sistema.getInstance().atracciones.add(m);

		} else if (tipo.equalsIgnoreCase("casadelterror")) {
			Atraccion c = new CasaDelTerror(nombre, tipo, edadMinima, cantMaxima);
			Sistema.getInstance().atracciones.add(c);
		} else if (tipo.equalsIgnoreCase("ruedadelafortuna")) {
			Atraccion r = new RuedaDeLaFortuna(nombre, tipo, edadMinima, cantMaxima);
			Sistema.getInstance().atracciones.add(r);

		}
		else {
			
		}

	}

	public void crearVisitante(String[] datos) {
		String nombre = datos[0];
		String edad = datos[1];
		String[] atracciones = Arrays.copyOfRange(datos, 2, datos.length);
		Visitante v = new Visitante(nombre, edad, atracciones);
		var a=Sistema.getInstance().atracciones;
		for (String s : atracciones) {
			Atraccion atraccion = Sistema.getInstance().getAtraccion(s);
			atraccion.registerObserver(v);
		}
	}

}

interface IObserver {
	// en este caso queremos que los observadores se les pueda enviar una
	// notificacion.

	void notificacion();

	void mostrarInfo();

}

interface IObservable {
	// estos metodos pueden tener parametros o no en este caso vamos a pedir un
	// subscriptor.
	// esto es todo lo que hacer un usuario observado.
	void registerObserver(IObserver s);

	void removeObserver(IObserver s);

	void notifyObservers();
}

class Visitante implements IObserver {
	String nombre, edad;
	ArrayList<String> atraccionesVisitadas;

	public Visitante(String nombre, String edad, String[] atracciones) {
		this.nombre = nombre;
		this.edad = edad;
		this.atraccionesVisitadas =  new ArrayList<String>( 
	            Arrays.asList(atracciones)) ;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public ArrayList<String> getAtraccionesVisitadas() {
		return atraccionesVisitadas;
	}

	public void setAtraccionesVisitadas(ArrayList<String> atraccionesVisitadas) {
		this.atraccionesVisitadas = atraccionesVisitadas;
	}

	@Override
	public void mostrarInfo() {
		// TODO Auto-generated method stub
		System.out.println(this.nombre + " " + this.edad);
	}

	@Override
	public void notificacion() {
		// TODO Auto-generated method stub
		System.out.println(this.nombre + "tienes que ir a probar lo nuevo !!");
	}

}

abstract class Atraccion implements IObservable {
	String nombre, tipo, edadMinima, cantMaxPersonas;
	ArrayList<IObserver> visitantes;

	public Atraccion(String nombre, String tipo, String edadMinima, String cantMaxPersonas) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.edadMinima = edadMinima;
		this.cantMaxPersonas = cantMaxPersonas;
		visitantes = new ArrayList<IObserver>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(String edadMinima) {
		this.edadMinima = edadMinima;
	}

	public String getCantMaxPersonas() {
		return cantMaxPersonas;
	}

	public void setCantMaxPersonas(String cantMaxPersonas) {
		this.cantMaxPersonas = cantMaxPersonas;
	}

	@Override
	public void registerObserver(IObserver s) {
		System.out.println("usuario suscrito");
		visitantes.add(s);

	}

	@Override
	public void removeObserver(IObserver s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (IObserver v : visitantes) {
			System.out.println(this.nombre + " tiene una nueva atraccion !!");
			v.notificacion();
		}
	}

	abstract void accept(IVisitor v);

}

class MontañaRusa extends Atraccion {

	public MontañaRusa(String nombre, String tipo, String edadMinima, String cantMaxPersonas) {
		super(nombre, tipo, edadMinima, cantMaxPersonas);
		// TODO Auto-generated constructor stub
	}

	@Override
	void accept(IVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}

}

class CasaDelTerror extends Atraccion {

	public CasaDelTerror(String nombre, String tipo, String edadMinima, String cantMaxPersonas) {
		super(nombre, tipo, edadMinima, cantMaxPersonas);
		// TODO Auto-generated constructor stub
	}

	@Override
	void accept(IVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}

}

class RuedaDeLaFortuna extends Atraccion {

	public RuedaDeLaFortuna(String nombre, String tipo, String edadMinima, String cantMaxPersonas) {
		super(nombre, tipo, edadMinima, cantMaxPersonas);
		// TODO Auto-generated constructor stub
	}

	@Override
	void accept(IVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}

}

interface IVisitor {
	void visit(RuedaDeLaFortuna r);

	void visit(MontañaRusa m);

	void visit(CasaDelTerror c);
}

class Operaciones implements IVisitor {
	public Operaciones() {
		
	}
	@Override
	public void visit(RuedaDeLaFortuna r) {
		// inspeccion
		System.out.println("se realiza la inspeccion para La rueda de la fortuna");
		System.out.println(r.getNombre()+" "+r.getEdadMinima());
	}

	@Override
	public void visit(MontañaRusa m) {
		// mantenimiento
		System.out.println("se realiza la inspeccion para la Montaña rusa");
		System.out.println(m.getNombre()+" "+m.getEdadMinima());

	}

	@Override
	public void visit(CasaDelTerror c) {
		// supervision
		System.out.println("se realiza la inspeccion para La casa del terror");
		System.out.println(c.getNombre()+" "+c.getEdadMinima());
	}

}
