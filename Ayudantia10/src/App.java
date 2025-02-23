import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

	public static void main(String[] args) throws FileNotFoundException {

		
		ISistema sistemaCuentas = new SistemaImp();
		File txt = new File ("cuentas.txt");
		Scanner scan = new Scanner(txt);
		while(scan.hasNextLine()) {
			
			sistemaCuentas.addCuenta(scan.nextLine().strip().split(";"));
		}
		System.out.println(sistemaCuentas.mostrarCuentas());
		scan= new Scanner(System.in);
		scan.nextLine();
		sistemaCuentas.calcularIntereses();
		System.out.println(sistemaCuentas.mostrarCuentas());
		
	}

}
