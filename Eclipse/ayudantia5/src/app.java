import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.*;

public class app {

	static ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	//static Player Jugador = new Player();
	static ArrayList<Player> Jugadores=new ArrayList<Player>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File txt = new File("textoH.txt");
		Scanner scan = new Scanner(txt);
		int n = 0;
		n = Integer.parseInt(scan.nextLine());
		while (n > 0) {
			String line = scan.nextLine();
			String[] splitLine = line.split(" ");
			Habitacion h1 = new Habitacion(splitLine[0]);
			Habitacion h2 = new Habitacion(splitLine[2]);
			h1.setDireccion(splitLine[1].toLowerCase().strip(), splitLine[2]);
			h2.setDireccionOpuesta(splitLine[1].toLowerCase().strip(), splitLine[0]);
			if (buscarHabitacion(splitLine[0]) == null) {
				habitaciones.add(h1);
			}
			if (buscarHabitacion(splitLine[2]) == null) {
				habitaciones.add(h2);
			}

			// h2.setDireccion(arrayLine[1].strip(), h1);

			n--;
		}
		
		String line = scan.nextLine();
		String[] splitLine = line.split(" ");
		buscarHabitacion(splitLine[1]).setEntrada(true);
		;
		line = scan.nextLine();
		splitLine = line.split(" ");
		for (int i = 1; i < splitLine.length; i++) {
			buscarHabitacion(splitLine[i]).setSalida(true);
			;
		}
		line = scan.nextLine();
		splitLine = line.split(" ");
		for (int i = 1; i < splitLine.length; i++) {
			buscarHabitacion(splitLine[i]).setDragon(true);

		}
		line = scan.nextLine();
		splitLine = line.split(" ");
		for (int i = 1; i < splitLine.length; i++) {
			buscarHabitacion(splitLine[i]).setOro(true);
			;
		}
		for(Habitacion h: habitaciones) {
			
			System.out.println(h.toString());
		}
		
			
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			System.out.println(line);
			splitLine = line.split(" ");
			leerMovimientos(splitLine);
			
			
		}
		
		for (Player j : Jugadores) {
			System.out.println(j.toString() + "\n");
		}
		

	}

	public static void leerMovimientos(String[] m) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Nombre del Jugador: ");
		Player Jugador = new Player(scan.nextLine());
		
		String pos = Jugador.getPos();
		
		Habitacion h = buscarHabitacion(pos);
		
		for (int i = 0; i <= m.length-1; i++) {
			
			//moverPersonaje(m[i].toLowerCase().strip(), Jugador,Jugador);
			System.out.println(Jugador.nombre+" esta en la pos "+Jugador.pos);
		}
		
		Jugadores.add(Jugador);
	}

	public static void moverPersonaje(String mov, Habitacion h,Player Jugador) {

		if (mov.equals("n")) {
			if (h.getNorte().equals("wall") ) {

				System.out.println("Personaje "+Jugador.nombre +" se ha estampado con el muro");

			} else {
				Habitacion h2=buscarHabitacion(h.getNorte());
				Jugador.setPos(h2.nombre);
				if (h2.isDragon()) {
					Jugador.setVivo(false);
					System.out.println("Personaje se ha topado con un Dragon en la habitacion " + h.getNombre());
					// se muere
				} else if (h2.isEntrada()) {
					System.out.println("Has llegado a la entrada de nuevo " + h.getNombre());

				} else if (h2.isOro()) {
					System.out.println("Has encontrado Oro en " + h.getNombre());
					Jugador.setOro(Jugador.getOro() + 1);
				} else if (h2.isSalida()) {
					System.out.println("Te has topado con la salida en " + h.getNombre());
					Jugador.setAfuera(true);
				}
				 

			}

		} else if (mov.equals("s")) {

			if (h.getSur().equals("wall") ) {

				System.out.println("Personaje "+Jugador.nombre +" se ha estampado con el muro");

			} else {
				Habitacion h2=buscarHabitacion(h.getSur());
				Jugador.setPos(h2.nombre);
				if (h2.isDragon()) {
					Jugador.setVivo(false);
					System.out.println("Personaje se ha topado con un Dragon en la habitacion " + h.getNombre());
					// se muere
				} else if (h2.isEntrada()) {
					System.out.println("Has llegado a la entrada de nuevo " + h.getNombre());

				} else if (h2.isOro()) {
					System.out.println("Has encontrado Oro en " + h.getNombre());
					Jugador.setOro(Jugador.getOro() + 1);
				} else if (h2.isSalida()) {
					System.out.println("Te has topado con la salida en " + h.getNombre());
					Jugador.setAfuera(true);
				}
				 

			}

		} else if (mov.equals("o")) {
			if (h.getOeste().equals("wall") ) {

				System.out.println("Personaje "+Jugador.nombre +" se ha estampado con el muro");

			} else {
				Habitacion h2=buscarHabitacion(h.getOeste());
				Jugador.setPos(h2.nombre);
				if (h2.isDragon()) {
					Jugador.setVivo(false);
					System.out.println("Personaje se ha topado con un Dragon en la habitacion " + h.getNombre());
					// se muere
				} else if (h2.isEntrada()) {
					System.out.println("Has llegado a la entrada de nuevo " + h.getNombre());

				} else if (h2.isOro()) {
					System.out.println("Has encontrado Oro en " + h.getNombre());
					Jugador.setOro(Jugador.getOro() + 1);
				} else if (h2.isSalida()) {
					System.out.println("Te has topado con la salida en " + h.getNombre());
					Jugador.setAfuera(true);
				}
				 

			}

		} else if (mov.equals("e")) {

			if (h.getEste().equals("wall") ) {

				System.out.println("Personaje "+Jugador.nombre +" se ha estampado con el muro");

			} else {
				Habitacion h2=buscarHabitacion(h.getEste());
				Jugador.setPos(h2.nombre);
				if (h2.isDragon()) {
					Jugador.setVivo(false);
					System.out.println("Personaje se ha topado con un Dragon en la habitacion " + h.getNombre());
					// se muere
				} else if (h2.isEntrada()) {
					System.out.println("Has llegado a la entrada de nuevo " + h.getNombre());

				} else if (h2.isOro()) {
					System.out.println("Has encontrado Oro en " + h.getNombre());
					Jugador.setOro(Jugador.getOro() + 1);
				} else if (h2.isSalida()) {
					System.out.println("Te has topado con la salida en " + h.getNombre());
					Jugador.setAfuera(true);
				}
				 

			}
		}
	}

	public static Habitacion buscarHabitacion(String n) {

		for (Habitacion h : habitaciones) {
			if (h.nombre.equals(n)) {
				return h;
			}

		}

		return null;
	}

}

class Player {
	@Override
	public String toString() {
		return "Player [nombre=" + nombre + ", pos=" + pos + ", oro=" + oro + ", vivo=" + vivo + ", afuera=" + afuera
				+ "]";
	}

	String nombre;
	String pos;
	int oro;
	boolean vivo;
	boolean afuera;

	public Player(String n) {
		vivo = true;
		pos = "E";
		oro = 0;
		afuera = false;
		nombre=n;
	}

	public boolean isAfuera() {
		return afuera;
	}

	public void setAfuera(boolean afuera) {
		this.afuera = afuera;
	}

	public int getOro() {
		return oro;
	}

	public String getPos() {
		return pos;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	
}
