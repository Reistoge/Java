package Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class app {

	public static String[] clases = { "mago", "cazador", "clerigo", "guerrero" };
	public static Equipo equipo;

	public static void main(String[] args) throws FileNotFoundException {
	
		menu();
		
	}

	public static void menu() throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Crea tu equipo !: ");
		crearEquipo();
		System.out.println("Creaste tu equipo !!");
		boolean continuar=true;
		
		while (continuar==true) {
			System.out.println("Selecciona un nivel: ");
			String nivel = scan.nextLine();
			while (!opcionValida(new String[] { "1", "2", "3" }, nivel)) {
				System.out.println("no existe este nivel... ingrese uno valido");
				nivel = scan.nextLine();

			}
			File txt = new File("level" + nivel + ".txt");
			cargarNivel(txt);
			if(equipo.isEstado()) {
				System.out.println("Has completado el nivel !!");
				equipo.MostrarEquipo();
				System.out.println("Quieres seguir jugando ? (si/no) : ");
				String opcion="";
				opcion = scan.nextLine();
				while (!opcionValida(new String[] { "si","no" }, opcion)) {
					System.out.println("Ingrese una opcion correcta");
					opcion = scan.nextLine();

				}
				if(opcion.equals("no")) {
					break;
				}
				
			}
			else {
				System.out.println("GAME OVER");
				equipo.MostrarEquipo();
				break;
			}
		}
		System.out.println("Gracias por Jugar !!");
	}

	public static void crearEquipo() {
		equipo = new Equipo();

		equipo.setPersonaje(crearPersonaje(), 0);
		System.out.println("Has creado a "+equipo.getEquipo()[0].clase+" "+equipo.getEquipo()[0].nombre+"\n\n");
		equipo.setPersonaje(crearPersonaje(), 1);
		System.out.println("Has creado a "+equipo.getEquipo()[1].clase+" "+equipo.getEquipo()[1].nombre+"\n\n");
		equipo.setPersonaje(crearPersonaje(), 2);
		System.out.println("Has creado a "+equipo.getEquipo()[2].clase+" "+equipo.getEquipo()[2].nombre+"\n\n");
		equipo.MostrarEquipo();

	}

	/**
	 * @param txt
	 * @throws FileNotFoundException
	 */
	public static void cargarNivel(File txt) throws FileNotFoundException {
		Scanner control=new Scanner(System.in);
		Scanner scan = new Scanner(txt);
		String line = scan.nextLine().toLowerCase();
		int n = Integer.parseInt(line);
		Mapache[] mapaches = new Mapache[n];
		int sum = 0;
		while (scan.hasNextLine()) {
			sum++;
			int turno=1;
			line = scan.nextLine().toLowerCase();
			String[] splitLine = line.split(",");
			Mapache m = new Mapache(sum,Float.parseFloat(splitLine[0]), Float.parseFloat(splitLine[1]));
			while (m.getVida() >= 0 && equipo.isEstado()) {
				
				System.out.println("Ronda " + sum);
				System.out.println("Turno "+turno);
				System.out.println("Mapache " + sum + " esta preparado para atacar !");
				control.nextLine();
				equipo.MostrarEquipo();
				System.out.println("Escoge un personaje 1, 2, 3:  ");
				Personaje p=seleccionarPersonaje();
				if(p.clase.equals("clerigo")){
					System.out.println("Que personaje desea curar ?");
					Personaje p2=seleccionarPersonaje();
					p.curar(p2);
					int randomI= (int) Math.round(Math.random()*(2.5f));
					m.atacar(equipo.getEquipo()[randomI]);
					control.nextLine();
					}
				
				else {
					// personaje ataca a mapache
					p.atacar(m);
					if(m.getVida()<=0) {
						System.out.println("Has derrotado al Mapache "+sum+"!");
						equipo.ganarExp();
						control.nextLine();
						continue;
						// ganar experiencia 
					}
					else {
						int randomI= (int) Math.round(Math.random()*(2.5f));
						m.atacar(equipo.getEquipo()[randomI]);
						control.nextLine();
					}
					 
				}
				turno++;
				
			}
			

		}

	}

	public static Personaje crearPersonaje() {
		Scanner scan = new Scanner(System.in);
		String clase;
		boolean valido;
		System.out.println("Cual sera la clase de tu personaje ?");
		for(String s: clases) {
			System.out.println("-"+s+ "- ");
		}
		System.out.print("Clase: ");
		clase = scan.nextLine().toLowerCase();
		while (!opcionValida(clases, clase)) {
			System.out.println("ingrese una clase valida");
			for(String s: clases) {
				System.out.print("-"+s+ ". ");
			}
			System.out.println();
			clase = scan.nextLine().toLowerCase();

		}
		System.out.println("Perfecto !!");
		String[] datosP;
		String nombre;

		if (clase.equals("mago")) {
			datosP = new String[5];

			System.out.print("ingresa el nombre de tu " + clase + ": ");
			datosP[0] = scan.nextLine();

			System.out.print("ingresa la vida de tu " + datosP[0]+":");
			datosP[1] = scan.nextLine();
			while (!esNumero(datosP[1])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la vida de tu " + datosP[0]+":");
				datosP[1] = scan.nextLine();
			}
			System.out.print("ingresa la mana de tu " + datosP[0]+":");
			datosP[2] = scan.nextLine();
			while (!esNumero(datosP[2])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la mana de tu " + datosP[0]+":");
				datosP[2] = scan.nextLine();
			}
			System.out.print("ingresa la ataque de tu " + datosP[0]+":");
			datosP[3] = scan.nextLine();
			while (!esNumero(datosP[3])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa el ataque de tu " + datosP[0]+":");
				datosP[3] = scan.nextLine();
			}
			System.out.print("ingresa la inteligencia de tu " + datosP[0]+":");
			datosP[4] = scan.nextLine();

			while (!esNumero(datosP[4])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la vida de tu " + datosP[0]+":");
				datosP[4] = scan.nextLine();
			}

			Personaje p = new Personaje(datosP, clase);
			return p;

		} else if (clase.equals("clerigo")) {
			datosP = new String[4];

			System.out.print("ingresa el nombre de tu " + clase + ": ");
			datosP[0] = scan.nextLine();

			System.out.print("ingresa la vida de tu " + datosP[0]+":");
			datosP[1] = scan.nextLine();
			while (!esNumero(datosP[1])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la vida de tu " + datosP[0]+":");
				datosP[1] = scan.nextLine();
			}
			System.out.print("ingresa la mana de tu " + datosP[0]+":");
			datosP[2] = scan.nextLine();
			while (!esNumero(datosP[2])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la mana de tu " + datosP[0]+":");
				datosP[2] = scan.nextLine();
			}

			System.out.print("ingresa la inteligencia de tu " + datosP[0]+":");
			datosP[3] = scan.nextLine();
			while (!esNumero(datosP[3])) {
				System.out.println("opcion invalida");
				System.out.print ("ingresa la inteligencia de tu " + datosP[0]+":");
				datosP[3] = scan.nextLine();
			}
			Personaje p = new Personaje(datosP, clase);
			return p;

		} else if (clase.equals("guerrero")) {
			datosP = new String[4];

			System.out.print("ingresa el nombre de tu " + clase + ": ");
			datosP[0] = scan.nextLine();

			System.out.print("ingresa la vida de tu " + datosP[0]+":");
			datosP[1] = scan.nextLine();
			while (!esNumero(datosP[1])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la vida de tu " + datosP[0]+":");
				datosP[1] = scan.nextLine();
			}
			System.out.print("ingresa el escudo de tu " + datosP[0]+":");
			datosP[2] = scan.nextLine();
			while (!esNumero(datosP[2])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa el escudo de tu " + datosP[0]+":");
				datosP[2] = scan.nextLine();
			}
			System.out.print("ingresa el ataque de tu " + datosP[0]+":");
			datosP[3] = scan.nextLine();
			while (!esNumero(datosP[3])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa el ataque de tu " + datosP[0]+":");
				datosP[3] = scan.nextLine();
			}
			Personaje p = new Personaje(datosP, clase);
			return p;

		} else if (clase.equals("cazador")) {

			datosP = new String[4];

			System.out.print("ingresa el nombre de tu " + clase + ": ");
			datosP[0] = scan.nextLine();

			System.out.print("ingresa la vida de tu " + datosP[0]+":");
			datosP[1] = scan.nextLine();
			while (!esNumero(datosP[1])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la vida de tu " + datosP[0]+":");
				datosP[1] = scan.nextLine();
			}
			System.out.print("ingresa la ataque de tu " + datosP[0]+":");
			datosP[2] = scan.nextLine();
			while (!esNumero(datosP[2])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa la ataque de tu " + datosP[0]+":");
				datosP[2] = scan.nextLine();
			}
			System.out.print("ingresa la destreza de tu " + datosP[0]+":");
			datosP[3] = scan.nextLine();
			while (!esNumero(datosP[3])) {
				System.out.println("opcion invalida");
				System.out.print("ingresa el destreza de tu " + datosP[0]+":");
				datosP[3] = scan.nextLine();
			}
			Personaje p = new Personaje(datosP, clase);

			return p;
		}
		return null;

	}

	public static Personaje seleccionarPersonaje() {
		while (true) {
			Scanner scan = new Scanner(System.in);
			String opc = scan.nextLine();
			if (!opcionValida(new String[] { "1", "2", "3" }, opc)) {
				System.out.print("Selecciona un personaje dentro del rango permitido.: ");
				opc = scan.nextLine();

			}
			int n = Integer.parseInt(opc);
			if (equipo.getEquipo()[n - 1].isVivo()) {
				 
				return equipo.getEquipo()[n - 1];
			} 
			else {
				System.out.println("Este personaje a muerto y no se puede seleccionar");
				System.out.println("Porfavor vuelve a escoger un personaje");
			}
		}
	}

	public static boolean opcionValida(String[] restricciones, String opcion) {
		for (String r : restricciones) {
			if (r.equals(opcion)) {
				return true;
			}
		}
		return false;

	}

	public static boolean esNumero(String n) {
		try {
			Float.parseFloat(n);
		} catch (Exception e) {
			return false;
		}

		return true;

	}

}
