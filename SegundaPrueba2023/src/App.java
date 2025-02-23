import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {

	}

	public static void menu() {
		
	}

	public static void printOpciones() {

	}

	public void leerMedicamentos() throws FileNotFoundException {

		Scanner scan = new Scanner(new File("medicamentos.txt"));
		while(scan.hasNextLine()) {
			String[] datos=scan.nextLine().split(",");
			SistemaImpl.getInstance().crearConsulta(datos);
		}


	}

	public void leerPacientes() throws FileNotFoundException {

		Scanner scan = new Scanner(new File("pacientes.txt"));
		while(scan.hasNextLine()) {
			String[] datos=scan.nextLine().split(",");
			SistemaImpl.getInstance().crearNuevoPaciente(datos);
		}


	}

	public void leerConsultas() throws FileNotFoundException {

		Scanner scan = new Scanner(new File("consultas.txt"));
		while(scan.hasNextLine()) {
			String[] datos=scan.nextLine().split(",");
			SistemaImpl.getInstance().crearConsulta(datos);
			
		}

	}
}
