import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class App {
	public static void main(String[] args) throws FileNotFoundException {
		leerHabitaciones();
		leerReservas();
		menu();
	}
	
	
	public static void menu() {
		Scanner scan= new Scanner(System.in);
		String opcion="";
		while(!opcion.equals("0")) {
			opciones();
			opcion = scan.nextLine();
			if(opcion.equals("1")) {
				 String numeroH,tipoH,precioPorNoche,parametroExtra;
				 System.out.print("ingrese numero de habitacion: ");
				 numeroH=scan.nextLine().strip();
				 System.out.print("ingrese tipo: ");
				 tipoH=scan.nextLine().strip();
				 System.out.print("ingrese costo por noche: ");
				 precioPorNoche=scan.nextLine().strip();
				 System.out.print("ingrese parametro extra: ");
				 parametroExtra= scan.nextLine().strip();
				 String[] datos= {numeroH,tipoH,precioPorNoche,parametroExtra};
				 GestionReservasSingleton.getInstance().crearHabitacion(datos);
				  
				
			}
			else if(opcion.equals("2")) {
				System.out.print("ingrese el numero de la habitacion para el cambio  de tarifa: ");
				String numeroHabitacion=scan.nextLine().strip();
				GestionReservasSingleton.getInstance().aplicarTarifa(numeroHabitacion);
				
			}
			else if(opcion.equals("3")) {
				System.out.println("1) Descuento por estancia prolongada.\r\n"
						+ "2) Descuento por temporada baja.");
				String contexto= scan.nextLine().strip();
				GestionReservasSingleton.getInstance().calcularDescuentos(contexto);
				
			}
			
		}
		scan.close();
		
	}
	public static void opciones() {
		System.out.println("1) Agregar una nueva reservación: Permite al usuario introducir nuevas reservaciones al sistema. \r\n"
				+ "2) Cambiar tarifa por noche de una habitación: Recibe el numero de una habitación y cambia su \r\n"
				+ "tarifa dependiendo del tipo de habitación: \r\n"
				+ "	1. Sencilla: Aumenta en un 10% su tarifa por noche. \r\n"
				+ "	2. Doble: Aumenta en un 15% su tarifa por noche. \r\n"
				+ "	3. Suite:  Aumenta en un 20% su tarifa por noche. \r\n"
				+ "3) Calcular descuentos: Permite calcular descuentos al costo de las reservas dependiendo de: \r\n"
				+ "	1. Descuento por estancia prolongada: Si la duración de la estancia es mayor a 10 dias, se \r\n"
				+ "	aplica un descuento de un 20%. \r\n"
				+ "	2. Descuento por temporada baja: Se aplica un descuento de 15%.");
		
	}
	public static void leerHabitaciones() throws FileNotFoundException {
		 
		Scanner scan = new Scanner (new File("habitaciones.txt"));
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			GestionReservasSingleton.getInstance().crearHabitacion(line.split(";"));
		}
	}
	public static void leerReservas() throws FileNotFoundException {
		
		Scanner scan = new Scanner (new File("reservas.txt"));
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			GestionReservasSingleton.getInstance().crearReserva(line.split(";"));
		}
	}

}

