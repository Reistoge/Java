import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		File txt= new File("estado.txt");
		Scanner scan = new Scanner(txt);
		ISistema sistema= new SistemaImp();
		while(scan.hasNextLine()) {
			String linea=scan.nextLine();
			String[] partesLinea= linea.split(",");
			sistema.agregarAlumno(partesLinea[1]);
			
		}
		
	}
	public static void menu() {
		
	}
}
