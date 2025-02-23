import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		leerAtracciones();
		leerVisitantes();
		Sistema.getInstance().atracciones.get(0).notifyObservers();
	
	}
	public static void leerAtracciones() throws FileNotFoundException{
		AtraccionFactory factory = new AtraccionFactory();
		Scanner scan = new Scanner(new File("atracciones.txt"));
		while(scan.hasNextLine()) {
			String[] datos = scan.nextLine().split(",");
			factory.crearAtraccion(datos);
		}
	}
	public static void leerVisitantes() throws FileNotFoundException {
		AtraccionFactory factory= new AtraccionFactory();
		Scanner scan = new Scanner(new File("visitantes.txt"));
		while(scan.hasNextLine()) {
			String[] datos= scan.nextLine().split(",");
			factory.crearVisitante(datos);
		}
		
	}

}
 
