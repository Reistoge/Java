import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	
	static int profit = 0;

	static String[] clientNames = new String[10];
	static int[] clientBills = new int[10];
	
	static int clientNumber = -1;
	
	static String[] plateNames = new String[10];
	static String[] plateTypes = new String[10];
	static int[] plateValues = new int[10];
	static int[] platePrices = new int[10];
	static int[] plateRequests = new int[10];
	
	static int numOfPlates = 0;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int input;
		
		getMenu();
		
		do {
			printHeader();
			//mostrar opciones hasta que se ingrese valida
			while (true) {
				printMenuOptions();
				input = devolverNumero(scan.nextLine());
				 
			    if ((input > 2) || (input < 0))
			        System.out.println("Opción Inválida");
			    else
			        break;
			}
			
			if (input == 1) {
				clientNumber++;
				do {
					printMenu();
					
					System.out.print("\nSeleccione plato: ");
					int plate = devolverNumero(scan.nextLine()) - 1;
					
					while(plate < 0 || plate > numOfPlates -1) {
						System.out.println("\nOpción Inválida");
						System.out.print("Seleccione plato: ");
						plate = devolverNumero(scan.nextLine()) - 1;
					}
					
					clientBills[clientNumber] += platePrices[plate];
					plateRequests[plate]++;
					
					while (true) {
						printOrderOptions();
						input = devolverNumero(scan.nextLine());
					    if ((input > 1) || (input < 0))
					        System.out.println("Opción Inválida");
					    else
					        break;
					}
					
				} while (input == 1);
				
				System.out.print("\nIngrese nombre del cliente: ");
				clientNames[clientNumber] = scan.nextLine();
				
				printBill(clientNames[clientNumber], clientBills[clientNumber]);
				profit += clientBills[clientNumber];
				
				input = -1;
				
			}
			
			else if (input == 2) {
				//ordena los clientes por costo de la factura
				for(int a = 0; a < clientNames.length -1; a++) {
					for(int b = a + 1; b < clientNames.length; b++) {
						if (clientBills[a] < clientBills[b]) {
							swapStr(clientNames, a , b);
							swapInt(clientBills, a , b);
						}
					}
				}
				
				getReport();
				
				//para que no lo tome como 0 al terminar una compra y termine el programa completo
				input = -1;
			}
			
		} while (input != 0);

		scan.close();
	}
	//funciones print menu
	public static void printHeader() {
		System.out.println("\n╒═══════════════════════════════════╕");
		System.out.println(  "│      The Biggers Restaurants      │");
		System.out.println(  "╘═══════════════════════════════════╛");
	}
	
	public static void printMenuOptions() {
		System.out.println("Por favor haga una selección");
		System.out.println("1. Nueva Compra");
		System.out.println("2. Informe");
		System.out.println("0. Cerrar el sistema");
	}

	public static void printOrderOptions() {
		System.out.println("\nPor favor haga una selección");
		System.out.println("1. Agregar al pedido");
		System.out.println("0. Finalizar compra");
	}
	//factura
	public static void printBill(String clientName, int ammount) {
		System.out.println("\n  ┌vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv┐");
		System.out.println(  "  │            FACTURA            │");
		System.out.println(  "  │  Cliente: " + clientName);
		System.out.println(  "  │ ───────────────────────────── │");
		System.out.println(  "  │  Costo             " + ammount);
		System.out.println(  "  └-------------------------------┘");
	}
	//swap elementos de lista
	public static void swapStr(String[] array, int a, int b) {
		String aux = array[a];
		array[a] = array[b];
		array[b] = aux;
	}
	
	public static void swapInt(int[] array, int a, int b) {
		int aux = array[a];
		array[a] = array[b];
		array[b] = aux;
	}
	
	public static void getMenu() {
		int lineNumber = 0;
		//intenta abrir el archivo de la carta y ordenar los platos por tipo
		try {
			Scanner scanFile = new Scanner(new File("carta.txt"));
			
			while(scanFile.hasNext()) {
				String line = scanFile.nextLine();
				String[] data = line.split(",");
				plateNames[lineNumber] = data[0].strip();
				plateTypes[lineNumber] = data[1].strip();
				platePrices[lineNumber] = Integer.parseInt(data[2].strip());
				
				if (plateTypes[lineNumber].equals("básico")) {
					plateValues[lineNumber] = 2;
				} else {
					plateValues[lineNumber] = 1;
				}
				
				numOfPlates++;
				
				lineNumber++;
			}
			
			scanFile.close();
			
			for(int a = 0; a < plateNames.length -1; a++) {
				for(int b = a + 1; b < plateNames.length; b++) {
					if (plateValues[a] < plateValues[b]) {
						swapStr(plateNames, a , b);
						swapStr(plateTypes, a , b);
						swapInt(plateValues, a , b);
						swapInt(platePrices, a , b);
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("⚠ Error: carta.txt no encontrado ⚠");
		}
	}
	
	public static int devolverNumero(String o) {
		// si la palabra por alguna razon no es un int se devolvera -1;
		try {
			Integer.parseInt(o);
			
		} catch (Exception e) {
			return -1;
		}
		return Integer.parseInt(o);
	}
	
	//imprime la carta
	public static void printMenu() {
		
		int plate = 0;
		int nextPlateType = plateValues[0];
		
		System.out.println("┌───────────────────────────────────┐");
		System.out.println("│          Platos  Básicos          │");
		System.out.println("└───────────────────────────────────┘");
		
		while (nextPlateType == 2) {
			
			System.out.println(plate + 1 + ". │ " + platePrices[plate] + " │ " + plateNames[plate]);
			
			plate++;
			nextPlateType = plateValues[plate];
		}
		
		System.out.println("┌───────────────────────────────────┐");
		System.out.println("│          Platos  Premium          │");
		System.out.println("└───────────────────────────────────┘");
		
		while (nextPlateType == 1) {
			
			System.out.println(plate + 1 + ". │ " + platePrices[plate] + " │ " + plateNames[plate]);
			
			plate++;
			nextPlateType = plateValues[plate];
		}
	}

	//Devuelve el informe
	public static void getReport() {
		
		//Crea una copia de las listas de platos, ya que si ordena las originales, la carta se desconfigura
		String[] tempPlateNames = plateNames;
		int[] tempPlatePrices = platePrices;
		int[] tempPlateRequests = plateRequests;
		
		System.out.println("┌───────────────────────────────────┐");
		System.out.println("╵              Informe              ╵");
		System.out.println("  Platos mas Caros");
		
		//ordena los platos por precio 
		for(int a = 0; a < tempPlateNames.length -1; a++) {
			for(int b = a + 1; b < tempPlateNames.length; b++) {
				if (tempPlatePrices[a] < tempPlatePrices[b]) {
					swapStr(tempPlateNames, a , b);
					swapInt(tempPlatePrices, a , b);
					swapInt(tempPlateRequests, a , b);
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			if (tempPlatePrices[i] != 0) {
				System.out.println("  " + (i+1) + ". " + tempPlateNames[i] + " (" + tempPlatePrices[i] + ")");
			} else {
				System.out.println("  " + (i+1) + ". <none>");
			}
			
		}
		
		System.out.println("\n  Top Clientes");
		//imprime 3 clientes top
		for (int i = 0; i < 3; i++) {
			if (clientBills[i] != 0) {
				System.out.println("  " + (i+1) + ". " + clientBills[i] + " " + clientNames[i]);
			} else {
				System.out.println("  " + (i+1) + ". <none>");
			}
			
		}
		
		System.out.println("\n  Ganancias del día: " + profit);
		
		//ordena platos por n de solicitud
		for(int a = 0; a < tempPlateNames.length -1; a++) {
			for(int b = a + 1; b < tempPlateNames.length; b++) {
				if (tempPlateRequests[a] < tempPlateRequests[b]) {
					swapStr(tempPlateNames, a , b);
					swapInt(tempPlatePrices, a , b);
					swapInt(tempPlateRequests, a , b);
				}
			}
		}
		
		System.out.println("\n  Platos más pedidos");
		
		for (int i = 0; i < 10; i++) {
			if (tempPlateRequests[i] != 0) {
				System.out.println("  " + (i+1) + ". " + tempPlateNames[i] + " x" + tempPlateRequests[i]);
			}
		}
		
		
		System.out.println("\n└───────────────────────────────────┘");
	}

}