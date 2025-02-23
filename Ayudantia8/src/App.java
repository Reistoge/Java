import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {
	
	static ISistema sistemaJuegos= new SistemaJuegos();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		String op="";
		leerJuegos();
		
		while(!op.equalsIgnoreCase("0")) {
			Scanner scan = new Scanner(System.in);
			menu();
			op = scan.nextLine();
			if(op.equalsIgnoreCase("1")) {
				System.out.println("Ingrese la informacion: ");
				sistemaJuegos.ingresarVideojuego(scan.nextLine());
			}
			else if(op.equalsIgnoreCase("2")) {
				System.out.println("nombre: ");
				sistemaJuegos.eliminarVideojuego(scan.nextLine());
			}
			else if(op.equalsIgnoreCase("3")) {
				System.out.println("ingrese el criterio de busqueda: ");
				System.out.println("1) jugados por desarrollador");
				System.out.println("2) no jugados por lanzamiento");
				String criterio= scan.nextLine();
				String buscar;
				if(criterio.equalsIgnoreCase("1")) {
					System.out.println("desarrollador");
					 buscar= scan.nextLine();
					
				}else {
					System.out.println("año de lanzamiento");
					buscar= scan.nextLine();
				}
						
				System.out.println(sistemaJuegos.busqueda(criterio, buscar));
				 
				
			}
			else if(op.equalsIgnoreCase("4")) {
				System.out.println("Shooter jugados");
				System.out.println(sistemaJuegos.noJugados("shooter"));
				System.out.println("tiempo total de rpg");
				System.out.println(sistemaJuegos.tiempoTotalRpg());
			}
			 
			
			
		}
		
	}
	public static void menu() {
		System.out.println("1) ingresar\r\n"
				+ "2) eliminar\r\n"
				+ "3) busqueda\r\n"
				+ "4) informe\r\n"
				+ "");
	}
	public static void leerJuegos() throws FileNotFoundException {
		File txt= new File("videojuegos.txt");

		Scanner scan = new Scanner(txt);
		while(scan.hasNextLine()) {
			sistemaJuegos.ingresarVideojuego(scan.nextLine());
		}
		
		
	}
	
	
}
