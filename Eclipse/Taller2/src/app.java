//Ferran Rojas Rut: 21.642.668-1
//Maximo Sarno Rut: 21.853.202-0
//Vicente Melendez Rut: 21.661.220-5
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class app {
	//
	
	
	public static ArrayList<Progenitor> Progenitores;
	public static ArrayList<Descendiente> Descendientes;
	public static ArrayList<Progenitora> Progenitoras;

	public static void main(String[] args) throws FileNotFoundException {

	 
	 


		// String a=Persona.BuildString(8);
		Progenitores = new ArrayList<Progenitor>();
		Descendientes = new ArrayList<Descendiente>();
		Progenitoras = new ArrayList<Progenitora>();
		leerDescendientes();
		leerProgenitoras();
		leerProgenitores();
		menu();
	}

	public static void menu() {
		// menu: printea y permite seleccionar las opciones al usuario
		
		Scanner scan = new Scanner(System.in);
		
		boolean terminar = false;
		
		while (terminar == false) {
			printOpciones();
			int op = 0;
			System.out.print("> ");
			op = devolverNumero(scan.nextLine());
			while (op <= 0 || op > 5) {

				System.out.println("Opcion invalida.");
				printOpciones();
				System.out.print("> ");
				op = devolverNumero(scan.nextLine());
			}
			switch (op) {
			case 1:
				// buscar persona Rut.
				// ver quienes son sus familiares.
				opcion1();
				break;
			case 2:

				// agregar progenitor/a y descendiente.
				opcion2();
				break;
			case 3:
				// agregar pareja
				opcion3();
				break;
			case 4:
				// progenitora con más hijos
				// desplegar al progenitor con mas hijos
				// mostrar a las madres y padres solteros
				// mostrar a las progenitoras y progenitores con mayor edad ( por separado de
				// mayor a menor)
				informe();
				break;
			case 5:
				System.out.println("Usted a decidido salir del programa");
				terminar = true;
				break;

			}

		}

	}

	public static void opcion1() {
		// pide al usuario que ingrese un rut y muestra
		// la informacion de este, si el rut no es encontrado
		// vuelve a preguntarle que ingrese un rut.
		
		// pregunta por la persona la cual quiere buscar,
		// despues una vez ingresada la persona, usando try catch casteando el "Object" por las clases Progenitor/Progenitora/Descendiente
		// una vez que es casteado correctamente,
		// osea que en un try no avanza al siguiente catch, muestra la informacion de esa persona. 
		Scanner scan = new Scanner(System.in);
		System.out.print(	"\nIngrese el rut de la persona que desea buscar\n> ");
		
		Object p = buscarPersona(scanRut());

		// verificamos si es progenitor, progenitora o descendiente.

		try {
			
			Progenitor pr = (Progenitor) p;
			
			// es progenitor
			System.out.println("Acabas de seleccionar al Progenitor: " + pr.getNombre() + "\n");
			System.out.println(pr.toString());
			// tab
			System.out.println("	MADRE");
			pr.mostrarMadre(Progenitoras);
			System.out.println();
			
			System.out.println("	PAREJA");
			pr.mostrarPareja(Progenitoras,Progenitores);
			System.out.println();
			
			System.out.println("	HERMAN@S");
			pr.mostrarHermanos(Progenitoras, Progenitores);
			System.out.println();

			System.out.println("	HIJ@S");
			pr.buscarHijos(Descendientes);
			System.out.println();

		} catch (Exception e) {
			 //no es progenitor 
		}
		try {
			Progenitora pa = (Progenitora) p;
			// es progenitora
			System.out.println("Acabas de seleccionar a la progenitora: " + pa.getNombre() + "\n");
			System.out.println(pa.toString());
			// tab
			System.out.println("	MADRE");
			pa.mostrarMadre(Progenitoras);
			System.out.println("	PAREJA");
			pa.mostrarPareja(Progenitores,Progenitoras);
			System.out.println("	HERMAN@S");
			pa.mostrarHermanos(Progenitoras, Progenitores);
			System.out.println("	HIJ@S");
			pa.buscarHijos(Descendientes,Progenitoras,Progenitores);

		} catch (Exception e) {
			// System.out.println("no es progenitora");
		}
		try {
			Descendiente d = (Descendiente) p;
			// es descendiente
			System.out.println("Acabas de seleccionar al descendiente " + d.getNombre() + "\n");
			System.out.println(d.toString());
			System.out.println("	PROGENITOR");
			d.mostrarPadre(Progenitores);
			System.out.println("	PROGENITORA");
			d.mostrarMadre(Progenitoras);
			System.out.println("	HERMAN@S");
			d.buscarHermanos(Descendientes);

		} catch (Exception e) {
			// System.out.println("no es descendiente");
		}

	}

	public static void opcion2() {
		// agrega a una persona dependiendo si es Progenitor/descendiente/Progenitora 
		//llamando a las funciones que se encargan de agregar al Progenit@r o Descendiente dependiendo del caso
		Scanner scan = new Scanner(System.in);
		System.out.print("Desea agregar un \n1)Progenitor\n2)Progenitora\n3)Descendiente\n\n> ");
		int op = devolverNumero(scan.nextLine());
		while (op < 1 || op > 3) {
			System.out.println("OPCION INVALIDA");
			System.out.print("Desea agregar un \n1)Progenitor\n2)Progenitora\n3)Descendiente\n\n> ");
			op = devolverNumero(scan.nextLine());
		}
		switch (op) {
		case 1:
			// se quiere agregar un progenitor
			agregarProgenitor();
			break;
		case 2:
			// se quiere agregar una progenitora
			agregarProgenitora();
			break;
		case 3:
			// se quiere agregar un descendiente
			agregarDescendiente();
			break;
		}

	}

	private static void agregarDescendiente() {
//		 pregunta por todos los datos necesarios para agregar aun descendiente(nombre,rut,rut madre rut padre) incluyendo las prevenciones de error
//		 para despues instanciar un Objeto de la clase Descendiente con esos datos Mostrar su informacion al usuario y agregarlo al arrayList Descendientes para que
//		 para que de esta manera exista en la base de datos.
		Scanner scan = new Scanner(System.in);
		// se le pide al usuario que ingrese los datos del nuevo pariente
		System.out.print("Ingrese el nombre del nuevo descendiente\n> ");
		String nombre = scan.nextLine();

		System.out.println();

		// usuario que ingresa los datos.
		System.out.print("Ingrese la edad de " + nombre + "\n> ");
		int edad = scannearNumero("" + "Input invalido, debe ingresar un numero para la edad, vuelva a intentarlo\n"
				+ "Ingrese la edad de " + nombre + "\n> ");

		System.out.print("Ingrese el rut de " + nombre + "\n> ");
		String rut = registrarRut();

		System.out.println();

		System.out.print("Ingrese el rut de la madre de " + nombre);
		String rutMadre = registrarRutPersona();
		while (rut.equals(rutMadre)) {
			System.out.print("no puede ingresar el mismo rut de " + nombre);
			rutMadre = registrarRutPersona();
		}
		System.out.println();
		System.out.print("Ingrese el rut del padre de " + nombre);
		String rutPadre = registrarRutPersona();
		// se verifica de que el rut a ingresar a la madre y padre sea 
		// valido y no contradiga la funcionalidad del programa.
		while (rut.equals(rutPadre) || rutPadre.equals(rutMadre) && !rutMadre.toLowerCase().equals("no-identificada")) {
			System.out.print("no puede ingresar el mismo rut de " + nombre);
			rutPadre = registrarRutPersona();
		}
		System.out.println();
		Descendiente d = new Descendiente(nombre, edad, rut, rutMadre, rutPadre);

		System.out.println(d.toString());
		// se añade al arrayList
		Descendientes.add(d);
		System.out.println("Descendiente " + nombre + " agregado exitosamente !!");

	}

	private static void agregarProgenitora() {
//		 pregunta por todos los datos necesarios para agregar aun Progenitora(nombre,rut,edad,rut madre rut pareja) incluyendo las prevenciones de error
//		 para despues instanciar un Objeto de la clase Progenitora con esos datos Mostrar su informacion al usuario y agregarlo al arrayList Progenitora  
//		 para que de esta manera exista en la base de datos.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese el nombre de la nueva Progenitora\n> ");
		// se le pide al usuario que ingrese los datos del nuevo pariente
		String nombre = scan.nextLine();
		System.out.println();
		// usuario Ingresando datos
		System.out.print("Ingrese la edad de " + nombre + "\n> ");
		int edad = scannearNumero("" + "Input invalido, debe ingresar un numero para la edad, vuelva a intentarlo\n"
				+ "Ingrese la edad de " + nombre + "\n> ");

		System.out.println();

		System.out.print("Ingrese el rut de " + nombre + "\n> ");
		String rut = registrarRut();

		System.out.println();

 
		System.out.print("Ingrese el rut de la pareja de " + nombre);
		String rutPareja="";
		
		//se verifica si la pareja es valida y que los datos de la pareja 
		// y el rut de la madre no contradigan el funcionamiento del programa.
		
		boolean parejaValida=false;
		while (parejaValida==false && !rutPareja.toLowerCase().equals("no-identificada")) {
			// En caso de que no este identificada se salta la verificacion, si no 
			// lo es se le vuelve a pedir el rut de persona hasta que sea una pareja valida.
			
			rutPareja = registrarRutPersona();
			
			if(rutPareja.strip().equals(rut)
				 && !rutPareja.strip().toLowerCase().equals("no-identificada")) {
				System.out.println("no puede ingresar el mismo rut de " + nombre);
				parejaValida=false;
				//rutPareja = registrarRutPersona();
				continue;
				
			}
			
			 
			Object p=buscarPersona(rutPareja);
			if(p!=null) {
				
				
					if(esProgenitor(p)) {
						Progenitor pareja= (Progenitor) p;
						if(!pareja.parejaNoIdentificada()) {
							// invalido
							System.out.println("Progenitor seleccionado "+pareja.getNombre()+" ya tiene pareja, el rut que debe ingresar para la pareja de "+nombre+" debe ser de una persona solter@");
							parejaValida=false;
							continue;
						}
						else {
							// valido
							pareja.setRutPareja(rut);
							parejaValida=true;
							continue;
						}
						
					}
					
					else if(esProgenitora(p)) {
						Progenitora pareja= (Progenitora) p;
						if(!pareja.parejaNoIdentificada()) {
							// invalido
							System.out.println("Progenitora seleccionada "+pareja.getNombre()+" ya tiene pareja, el rut que debe ingresar para la pareja de "+nombre+" debe ser de una persona solter@");
							parejaValida=false;
							continue;
						}
						else {
							// valido
							pareja.setRutPareja(rut);
							parejaValida=true;
							continue;
						}
					}
					
					else if(esDescendiente(p)) {
						// invalido 
						Descendiente d=(Descendiente) p;
						System.out.println(d.getNombre()+ " es un descendiente no tiene un atributo de pareja, ingrese rut valido");
						parejaValida=false;
						continue;
						
						
						}
						rutPareja = registrarRutPersona();
					}
				
			else if(p==null && !rutPareja.toLowerCase().equals("no-identificada")){
				System.out.println("Este rut no existe en la base de datos se asumira que el rut de la pareja no esta identificada,"
						+ "\nsi quieres crear una pareja desde 0 debes primero crear a l@s progenitor@s con el rut de"
						+ "\nparejas no-identificada (0) y despues asignarles pareja (opcion menu 3) ");
				parejaValida=false;
				continue;
				}
			else if(p==null && rutPareja.toLowerCase().equals("no-identificada")){
				
				parejaValida=true;
				continue;
			}
			
		}

		System.out.print("Ingrese el rut de la madre de " + nombre);
		String rutMadre = registrarRutPersona();
 		// tiene que ser un rut nuevo.
		while (rutMadre.equals(rut)
				|| rutPareja.equals(rutMadre) && !rutMadre.toLowerCase().equals("no-identificada")) {
			System.out.println("no puede ingresar el mismo rut de " + nombre);
			rutMadre = registrarRutPersona();
		}
		
		
		

		Progenitora pa = new Progenitora(nombre, edad, rut, rutPareja, rutMadre);
		System.out.println(pa.toString());
		// se añade al arrayList
		Progenitoras.add(pa);
		System.out.println("Progenitor " + nombre + " agregado exitosamente !!");
	}

	private static void agregarProgenitor() {
//		 pregunta por todos los datos necesarios para agregar a un Progenitor(nombre,rut,edad,rut madre rut pareja) incluyendo las prevenciones de error
//		 para despues instanciar un Objeto de la clase Progenitor con esos datos Mostrar su informacion al usuario y agregarlo al arrayList Progenitor  
//		 para que de esta manera exista en la base de datos.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese el nombre del nuevo Progenitor\n> ");
		// se le pide al usuario que ingrese los datos del nuevo pariente
		String nombre = scan.nextLine();
		System.out.println();
		// Usuario ingresando datos
		System.out.print("Ingrese la edad de " + nombre + "\n> ");
		int edad = scannearNumero("" + "Input invalido, debe ingresar un numero para la edad, vuelva a intentarlo\n"
				+ "Ingrese la edad de " + nombre + "\n> ");

		System.out.println();

		System.out.print("Ingrese el rut de " + nombre + "\n> ");
		String rut = registrarRut();

		
		System.out.print("Ingrese el rut de la pareja de " + nombre);
		String rutPareja="";
		//se verifica si la pareja es valida y que los datos de la pareja 
		// y el rut de la madre no contradigan el funcionamiento del programa.
		boolean parejaValida=false;
		// se verifica si la pareja es valida.
		while (parejaValida==false && !rutPareja.toLowerCase().equals("no-identificada")) {
			rutPareja = registrarRutPersona();
			// En caso de que no este identificada se salta la verificacion, si no 
			// lo es se le vuelve a pedir el rut de persona hasta que sea una pareja valida.
			if(rutPareja.strip().equals(rut)
				 && !rutPareja.strip().toLowerCase().equals("no-identificada")) {
				System.out.println("no puede ingresar el mismo rut de " + nombre);
				parejaValida=false;
				//rutPareja = registrarRutPersona();
				continue;
				
			}
			
			 
			Object p=buscarPersona(rutPareja);
			if(p!=null) {
				
				if(esProgenitor(p)) {
					Progenitor pareja= (Progenitor) p;
					if(!pareja.parejaNoIdentificada()) {
						// invalido
						System.out.println("Progenitor seleccionado"+pareja.getNombre()+" ya tiene pareja, el rut que debe ingresar para la pareja de "+nombre+" debe ser de una persona solter@");
						parejaValida=false;
						continue;
					}
					else {
						// valido
						pareja.setRutPareja(rut);
						parejaValida=true;
						continue;
					}
					
				}
				
				else if(esProgenitora(p)) {
					Progenitora pareja= (Progenitora) p;
					if(!pareja.parejaNoIdentificada()) {
						// invalido
						System.out.println("Progenitora seleccionada"+pareja.getNombre()+" ya tiene pareja, el rut que debe ingresar para la pareja de "+nombre+" debe ser de una persona solter@");
						parejaValida=false;
						continue;
					}
					else {
						// valido
						pareja.setRutPareja(rut);
						parejaValida=true;
						continue;
					}
				}
				
				else if(esDescendiente(p)) {
					// invalido 
					Descendiente d=(Descendiente) p;
					System.out.println(d.getNombre()+ " es un descendiente no tiene un atributo de pareja, ingrese rut valido");
					parejaValida=false;
					continue;
					
					
					}
					rutPareja = registrarRutPersona();
				}
				
			else if(p==null && !rutPareja.toLowerCase().equals("no-identificada")){
					System.out.println("Este rut no existe en la base de datos se asumira que el rut de la pareja no esta identificada,"
							+ "\nsi quieres crear una pareja desde 0 debes primero crear a l@s progenitor@s con el rut de"
							+ "\nparejas no-identificada (0) y despues asignarles pareja (opcion menu 3) ");
					parejaValida=false;
					continue;
				}
			else if(p==null && rutPareja.toLowerCase().equals("no-identificada")){
				
				parejaValida=true;
				continue;
			}
		}

		System.out.print("Ingrese el rut de la madre de " + nombre);
		String rutMadre = registrarRutPersona();
		
 		// tiene que ser un rut nuevo.
		while (rutMadre.equals(rut)
				|| rutPareja.equals(rutMadre) && !rutMadre.toLowerCase().equals("no-identificada")) {
			System.out.println("no puede ingresar el mismo rut de " + nombre);
			rutMadre = registrarRutPersona();
		}

		Progenitor pr = new Progenitor(nombre, edad, rut, rutMadre, rutPareja);
		System.out.println(pr.toString());
		// se añade al arrayList
		Progenitores.add(pr);
		System.out.println("Progenitor " + nombre + " agregada exitosamente !!");
	}
	
	public static void agregarPareja() {
	//		 esta funcion pregunta al usuario por los rut de las personas a las cuales se les quiere asignar una pareja,
	//		 para esto l@s Progenitor@s deben cumplir con un cierto criterio este es que en su atributo rutPareja contener el string "no-identificadas".
	//		 se le preguntara primero al usuario si quiere ver quienes son las personas quienes cumplen con este criterio.
	//		 una vez mostrada la informacion o no, pedira al usuario ingresar 2 ruts, los cuales seran verificados si cumplen con el criterio,
	//		 si no es el caso preguntara que ingrese de nuevo hasta que se ingresen dos ruts que sean validos (cumplen el criterio).
			
			Scanner scan =new Scanner(System.in);
			
			
			boolean valido = false;
			while (valido == false) {
				System.out.println("Quieres ver l@s Progenitor@s a los cuales puedes agregarle pareja ? (1: si , 2: no)");
				int op =scannearNumero("opcion invalida.");
				while(op >2 || op <0) {
					System.out.println("opcion invalida");
				}
				if(op == 1) {
					// se muestra a los progenitores validos
					mostrarProgenitoresSinPareja();
				}
				System.out.println("\n");
				
				System.out.println("RUT DE LAS PAREJAS");
				System.out.print("PERSONA 1\n> ");
				String rut1 = scanRut();
				Object p1 = buscarPersona(rut1);
	
				System.out.print("PERSONA 2\n> ");
				String rut2 = scanRut();
				Object p2 = buscarPersona(rut2);
											
				//posibilidades de parejas.
				//hombre y hombre
				//mujer y hombre
				//hombre y mujer
				//mujer y mujer
				try {
					Progenitor pr1 = (Progenitor) p1;
					
					// persona uno es hombre
	
					try {
	
						Progenitora pa2 = (Progenitora) p2;
						if (pr1.getRutPareja().toLowerCase().equals("no-identificada")
								&& pa2.getRutPareja().toLowerCase().equals("no-identificada")) {
	
							System.out.println(pr1.getNombre() + " y " + pa2.getNombre() + " son ahora pareja!");
							pr1.setRutPareja(pa2.getRut());
							pa2.setRutPareja(pr1.getRut());
							// progenitor con progenitora solteros, valido.
							valido = true;
							break;
						} else {
							if (pr1.getRutPareja().toLowerCase().equals("no-identificada")) {
								System.out.println(
										"Progenitor " + pr1.getRut() + " (" + pr1.getNombre() + ") ya tiene pareja ");
								// si este progentir ya tiene pareja
							}
							if (pa2.getRutPareja().toLowerCase().equals("no-identificada")) {
								System.out.println(
										"Progenitora " + pa2.getRut() + " (" + pa2.getNombre() + ") ya tiene pareja ");
								// progenitora ya tiene pareja
							}
							// no es valido
							valido = false;
							
						}
					} catch (Exception e2) {
						
						// NUEVO
						// progenitor con progenitor o con descendiente
						try{
							//progenitor con progenitor ¿VALIDO?
							Progenitor pr2 = (Progenitor) p2;
							if (pr1.getRutPareja().toLowerCase().equals("no-identificada")
									&& pr2.getRutPareja().toLowerCase().equals("no-identificada")) {
	
								System.out.println(pr1.getNombre() + " y " + pr2.getNombre() + " son ahora pareja!");
								pr1.setRutPareja(pr2.getRut());
								pr2.setRutPareja(pr1.getRut());
								// progenitor con progenitora solteros, valido.
								valido = true;
								break;
							} else {
								if (pr1.getRutPareja().toLowerCase().equals("no-identificada")) {
									System.out.println(
											"Progenitor " + pr1.getRut() + " (" + pr1.getNombre() + ") ya tiene pareja ");
									// si este progentir ya tiene pareja
								}
								if (pr2.getRutPareja().toLowerCase().equals("no-identificada")) {
									System.out.println(
											"Progenitora " + pr2.getRut() + " (" + pr2.getNombre() + ") ya tiene pareja ");
									// progenitora ya tiene pareja
								}
								// no es valido
								valido = false;
								
							}
							
						}
						catch (Exception e) {
							 // progenitor con descendiente
							valido = false;
						}
						// valido = false;
					}
				}
	
				// persona uno es Progenitora
				catch (Exception e) {
	
					try {
						// persona uno es Progenitora
						Progenitora pa1 = (Progenitora) p1;
	
						try {
							// persona dos deberia ser progenitor
							Progenitor pr2 = (Progenitor) p2;
	
							if (pa1.getRutPareja().toLowerCase().equals("no-identificada")
									&& pr2.getRutPareja().toLowerCase().equals("no-identificada")) {
	
								pa1.setRutPareja(pr2.getRut());
								pr2.setRutPareja(pa1.getRut());
								System.out.println(pa1.getNombre() + " y " + pr2.getNombre() + " son ahora pareja!.");
								System.out.println(pa1.toString());
								System.out.println(pr2.toString());
								valido = true;
								break;
								// caso valido
							} else {
								// caso en el que uno es progenitor y otro progenitora pero ya tienen parejas, invalido.
								if (pa1.getRutPareja().toLowerCase().equals("no-identificada")) {
									System.out.println(pa1.getRut() + " (" + pa1.getNombre() + ") ya tiene pareja ");
								}
								if (pr2.getRutPareja().toLowerCase().equals("no-identificada")) {
									System.out.println(pr2.getRut() + " (" + pr2.getNombre() + ") ya tiene pareja ");
								}
								valido = false;
							}
						} catch (Exception e3) {
							// NUEVO
							
							// persona 1 es progenitora pero persona 2 no es progenitor .
							// progenitora con progenitora o con descendiente
							try{
								//progenitora con progenitora
								Progenitora pa2 = (Progenitora) p2;
								if (pa1.getRutPareja().toLowerCase().equals("no-identificada")
										&& pa2.getRutPareja().toLowerCase().equals("no-identificada")) {
	
									pa1.setRutPareja(pa2.getRut());
									pa2.setRutPareja(pa1.getRut());
									System.out.println(pa1.getNombre() + " y " + pa2.getNombre() + " son ahora pareja!.");
									System.out.println(pa1.toString());
									System.out.println(pa2.toString());
									valido = true;
									break;
									// caso valido
								} else {
									// caso en el que uno es progenitor y otro progenitora pero ya tienen parejas, invalido.
									if (pa1.getRutPareja().toLowerCase().equals("no-identificada")) {
										System.out.println(pa1.getRut() + " (" + pa1.getNombre() + ") ya tiene pareja ");
									}
									if (pa2.getRutPareja().toLowerCase().equals("no-identificada")) {
										System.out.println(pa2.getRut() + " (" + pa2.getNombre() + ") ya tiene pareja ");
									}
									valido = false;
								}
								
							}
							catch (Exception e4) {
								 // progenitora con descendiente
								valido = false;
							}
							// NUEVO valido = false;
						}
	
					} catch (Exception e2) {
						// persona uno no es ni progenitora ni progenitor
						valido = false;
					}
				}
	
				System.out.println(
						"PAREJA INVALIDA\nRecuerde que deben ser progenitores o progenitoras y estas no deben tener parejas (Rut pareja = NO-IDENTIFICADA).");
			}
	
		}

	public static void mostrarProgenitoresSinPareja() {
		// muestra a todos los progenitor@s del sistema alos cuales 
		// en su rutPareja contengan el string "no-identificada"
		System.out.println("PROGENITOR@S A LOS CUALES SE LE PUEDE AGREGAR UNA PAREJA: ");
		for(Progenitor p: Progenitores) {
			// por cada profenitor en progenitores mostrar su informacion si en su atributo rutPareja contiene el string "no-identificada" 
			if(p.getRutPareja().toLowerCase().equals("no-identificada")) {
				System.out.println(p.toString());
			}
		}
		for(Progenitora p: Progenitoras) {
			// por cada progenitora en progenitoras mostrar su informacion si en su atributo rutPareja contiene el string "no-identificada" 
			if(p.getRutPareja().toLowerCase().equals("no-identificada")) {
				System.out.println(p.toString());
			}
		}
		  
	}
	public static void opcion3() {
		// ejecuta la funcion agregarPareja.
		
		agregarPareja();
	}

	public static void informe() {
		//ejecuta las funciones encargadas de mostrar la informacion 
		//del informe (progenitoresConMasHijos,progenitoresSolteros,progenitoresMayores).
		System.out.println("            INFORME");
		progenitoresConMasHijos();
		System.out.println("    ----------------------------\n");
		progenitoresSolteros();
		System.out.println("    ----------------------------\n");
		progenitoresMayores();
		
	}
	public static void progenitoresConMasHijos() {
		// Encuentra a los progenitores con más hijos, para esto
		// cuenta el numero de hijos de cada progenit@r si encuentra un Progenit@r 
		// con más hijos que la variable temporal esta sera asignada a este Progenit@r, 
		// asi hasta que no hayan más Progenit@r con hijos que contar  (atributo nHijos es mayor)
		
		// variables temporales
		Progenitora maxPa =new Progenitora();
		Progenitor maxPr = new Progenitor();
		for(Progenitora p: Progenitoras) {
			// por cada progenitora contamos los numeros de hijos que tiene
			p.contarHijos(Descendientes,Progenitoras,Progenitores);
			if(p.nHijos>=maxPa.nHijos) {
				// se encontro una progenitora con más hijos, actualizar la variable
				maxPa=p;
			}
			
		}
		for(Progenitor pr: Progenitores) {
			// por cada progenitor contamos los numeros de hijos que tiene 
			pr.contarHijos(Descendientes);
			if(pr.nHijos>=maxPr.nHijos) {
				// se encontro una progenitor con más hijos, actualizar la variable
				maxPr=pr;
			}
			
		}
		System.out.print("    PROGENITORA CON MÁS HIJOS:");
		System.out.print(maxPa.toString());
		System.out.print("    Con un total de "+maxPa.nHijos+" hij@s\n\n");
		System.out.print("    PROGENITOR CON MÁS HIJOS:");
		System.out.print(maxPr.toString());
		System.out.println("    Con un total de "+maxPr.nHijos+" hij@s");
		
	}
 
	public static void progenitoresSolteros() {
		// Muestra los Progenitor@s los cuales cumplan con el criterio ser Progenitor@s Solteros 
		// (seria soltera cuando el hij@ no tiene a un padre identificado) 
		System.out.println("    PROGENITOR@S SOLTER@S:");
		int n=0;
		for(Progenitor pr: Progenitores){
 
			if(pr.hijos.size()>0) {
				n++;
				System.out.print("\n    "+n);
				pr.esSoltero(Descendientes);
			}
		}
		for(Progenitora pa: Progenitoras) {
 
			if(pa.hijos.size()>0) {
				n++;
				System.out.print("\n    "+n);
				pa.esSoltero(Descendientes,Progenitoras,Progenitores);
			}
			 
		}
		
		
	}
	public static int devolverNumero(String o) {
		// si la palabra por alguna razon no es un int se devolvera -1;
		try {
			Integer.parseInt(o.strip());

		} catch (Exception e) {
			return -1;
		}
		return Integer.parseInt(o.strip());
	}


	public static void printOpciones() {
		// muestra las opciones del menu
		System.out.println("\n\nBUSQUEDA DE FAMILIARES ANA MARIA\nSeleccione una opcion (1,2,3): \r\n"
				+ "1) Buscar persona \r\n" 
				+ "2) Agregar progenitora, progenitor o descendiente\r\n"
				+ "3) Asignar pareja (solo pareja sin pareja puede ser asignada)\r\n" 
				+ "4) Informe\r\n"
				+ "5) Salir");

	}

	public static void leerProgenitores() throws FileNotFoundException {
		// lee el texto de progenitores y por cada linea 
		// instancia un Progenitor y la añade al arraylist static Progenitores
		File txt = new File("Progenitores.txt");
		Scanner scan = new Scanner(txt);
		while (scan.hasNextLine()) {
			String line = scan.nextLine().strip();
			String[] linePartes = line.split(",");

			String nombre = linePartes[0];
			int edad = Integer.parseInt(linePartes[1]);
			String rut = (linePartes[2]);
			String rutMadre = linePartes[3];
			String rutPareja = linePartes[4];
			Progenitor pr = new Progenitor(nombre, edad, rut, rutMadre, rutPareja);
			Progenitores.add(pr);

		}
	}
	public static int scannearNumero(String errDisplay) {
		// Prevencion de error: preguntara hasta que el 
		// usuario ingrese un numero si no es el caso hara un display de errDisplay
		Scanner scan = new Scanner(System.in);
		int n = 0;
		n = devolverNumero(scan.nextLine());
		while (n == -1) {
			System.out.print(errDisplay);
			n = devolverNumero(scan.nextLine());
		}
		return n;
	}

	public static void leerProgenitoras() throws FileNotFoundException {
		// lee el texto de progenitoras y por cada linea 
		// instancia un Progenitora y la añade al arraylist static Progenitoras
		File txt = new File("Progenitoras.txt");
		Scanner scan = new Scanner(txt);
		while (scan.hasNextLine()) {
			String line = scan.nextLine().strip();
			String[] linePartes = line.split(",");

			String nombre = linePartes[0];
			int edad = Integer.parseInt(linePartes[1]);
			String rut = (linePartes[2]);
			String rutPareja = linePartes[3];
			String rutMadre = linePartes[4];
			Progenitora pa = new Progenitora(nombre, edad, rut, rutPareja, rutMadre);
			Progenitoras.add(pa);
		}

	}
	public static void progenitoresMayores() {
		// Determina la Progenitora y Progenitor de mayor edad usando un bubble 
		// sort para arraylist Progenitoras y Progenitores este ordena 
		// de mayor a menor dependiendo del atributo edad de las instancias.
		
		Progenitora maxPa =new Progenitora();
		Progenitor maxPr = new Progenitor();
		// determinar mayor ( no importa)
		for(Progenitora p: Progenitoras) {
			p.contarHijos(Descendientes,Progenitoras,Progenitores);
			if(p.edad>=maxPa.edad) {
				maxPa=p;
			}
			
		}
		// bubblesort para arraylist progenitores
		for(int i =0;i<Progenitores.size();i++) {
			for(int j=i+1;j<Progenitores.size();j++) {
				if(Progenitores.get(i).edad<Progenitores.get(j).edad) {
					Progenitor tempPr=Progenitores.get(i);
					Progenitores.set(i, Progenitores.get(j));
					Progenitores.set(j, tempPr);
					
				}
			}
			
			
		}
		// bubblesort para arraylist progenitoras
		for(int i =0;i<Progenitoras.size();i++) {
			for(int j=i+1;j<Progenitoras.size();j++) {
				if(Progenitoras.get(i).edad<Progenitoras.get(j).edad) {
					Progenitora tempPr=Progenitoras.get(i);
					Progenitoras.set(i, Progenitoras.get(j));
					Progenitoras.set(j, tempPr);
					
				}
			}
			
			
		}
		// determinar mayor (no importa)
		for(Progenitor pr: Progenitores) {
			pr.contarHijos(Descendientes);
			if(pr.edad>=maxPr.edad) {
				maxPr=pr;
			}
			
		}
//		System.out.println("    Progenitor con más edad es: "+maxPr.toString());
//		System.out.println("    Progenitora con más edad es: "+maxPa.toString());
		System.out.println("    Ordenamiento de edades descendente (Progenitores)".toUpperCase());
		for(Progenitor P : Progenitores) {
			System.out.println(P.toString());
		}
		System.out.println("    Ordenamiento de edades descendente (Progenitoras)".toUpperCase());
		for(Progenitora P: Progenitoras) {
			System.out.println(P.toString());
		}
		
	}

	public static String getCualquierRutExistente() {
		
		// retorna un string cualquiera para que el usuario tenga un rut de referencia.
		return Progenitores.get(0).getRut();
		
	}
	public static String scanRut() {
		// prevencion de errores: pide al usuario que ingrese un rut valido y ademas que este rut 
		// exista en la base de datos, es decir dentro los arraysList Descendientes, Progenitoras, Progenitores
		// se usara para buscar a una persona
		Scanner scan = new Scanner(System.in);

		String op = scan.nextLine();
		// ingresando un rut correcto
		boolean rutValido = validarRut(op.strip());
		boolean existe = (buscarPersona(op) != null);
		
		// mientras el rut sea valido y exista
		while (!rutValido || !existe) {
			
			// si solamente el rut es invalido
			if (!rutValido) {
				System.out.println("RUT INVALIDO");
				
				System.out.print("El formato de rut es con puntos (.) y guion (-) \nEjemplo: "+getCualquierRutExistente()+" (existe y es valido)\n> ");

				op = scan.nextLine();
				rutValido = validarRut(op.strip());
				existe = !(buscarPersona(op) == null);
			// en el caso que no exista	
			} else if (!existe) {
				System.out.println("No se han encontrado los datos suficientes \r\n"
						+ "de esta persona en la base de datos\r\n"
						+ "Esto es debido a: \r\n"
						+ "\r\n"
						+ "1)Usuario busco una persona que \r\n"
						+ "  directamente no existe en el \r\n"
						+ "  programa o en la base de datos \r\n"
						+ "  (Agregue la persona)\r\n"
						+ "\r\n"
						+ "2)Usuario busco una persona el \r\n"
						+ "  cual indirectamente no existe \r\n"
						+ "  en los datos.\r\n"
						+ "  Ejemplo: \r\n"
						+ "    2.1) Usuario al agregar una \r\n"
						+ "         persona nueva ingresa rut \r\n"
						+ "         nuevos a los parientes\r\n"
						+ "         de esa persona que \r\n"
						+ "         esta agregando.\r\n"
						+ "\r\n"
						+ "Para solucionar esta confusión debe agregar \r\n"
						+ "Tambien esta nuevas personas al programa \r\n"
						+ "ya puede ser por los .txt o por la opcion \r\n"
						+ "de agregar Personas. De esta manera se \r\n"
						+ "tendra se tendra la informacion suficiente\r\n"
						+ "de esta persona ya que solo tenemos el\r\n"
						+ "rut de 'alguien' el cual es pariente \r\n"
						+ "de una persona si existe.");
				
				
 
				
				System.out.println("\nPara continuar debe ingresar un rut existente\nEjemplo: "+getCualquierRutExistente()+" (existe y es valido).\n");
				System.out.print("Ingrese de nuevo un rut\n> ");
				op = scan.nextLine();

				rutValido = validarRut(op.strip());
				existe = !(buscarPersona(op) == null);
			}
		}
		return op;
	}

	public static String registrarRut() {
		// prevencion de errores: pide al usuario que ingrese un rut valido y ademas que este rut 
		// no exista en la base de datos es decir un rut nuevo, se usara para añadir a una persona.
		Scanner scan = new Scanner(System.in);

		String op = scan.nextLine();
		// ingresando un rut correcto
		boolean rutValido = validarRut(op.strip());
		boolean existe = (buscarPersona(op) != null);

		// si no es valido pero existe
		while (!rutValido || existe) {
			if (!rutValido) {
				System.out.println("RUT INVALIDO");
				System.out.print("El formato de rut es con puntos (.) y guion (-) \nEjemplo: 12.333.444-5\n> ");
				op = scan.nextLine();
				rutValido = validarRut(op.strip());
				existe = (buscarPersona(op) != null);
			// si existe le decimos que ingrese uno nuevo.
			} else if (existe) {
				System.out.println("Esta persona ya existe en la base de datos");
				System.out.println("Ingrese el rut de una nueva persona.\n> ");
				System.out.print("INDICACION ---> INGRESAR 0 SI NO ESTA IDENTIFCADA\n> ");
				op = scan.nextLine();

				rutValido = validarRut(op.strip());
				existe = (buscarPersona(op) != null);
			}
		}
		return op;
	}

	public static String registrarRutPersona() {
		// esta funcion retorna un rut, el cual será ingresado por el usuario y validado por 
		//la funcion usando validarRut, este string puede ser (no-identificada) o un rut.

	  
		Scanner scan = new Scanner(System.in);

		System.out.print("\nINDICACION ---> INGRESAR '0' SI NO ESTA IDENTIFCADA\n> ");
		String op = scan.nextLine();
		if (op.toLowerCase().equals("0")) {
			return "NO-IDENTIFICADA";
		}
		// ingresando un rut correcto
		boolean rutValido = validarRut(op.strip());

		while (!rutValido) {
			if (!rutValido) {
				System.out.println("RUT INVALIDO");
				System.out.println("El formato de rut es con puntos (.) y guion (-) \nEjemplo: 12.333.444-5");
				System.out.print("INDICACION ---> INGRESAR 0 SI NO ESTA IDENTIFCADA\n> ");
				op = scan.nextLine();
				if (op.toLowerCase().equals("0")) {
					return "NO-IDENTIFICADA";
				}
				rutValido = validarRut(op.strip());
			}
		}
		return op;
	}

	public static void leerDescendientes() throws FileNotFoundException {
		// lee el texto de Descendientes y por cada linea 
		// instancia un Progenitora y la añade al arraylist static Descendientes
		File txt = new File("Descendientes.txt");
		Scanner scan = new Scanner(txt);
		while (scan.hasNextLine()) {
			String line = scan.nextLine().strip();
			String[] linePartes = line.split(",");

			String nombre = linePartes[0];
			int edad = Integer.parseInt(linePartes[1]);
			String rut = (linePartes[2]);
			String rutMadre = linePartes[3];
			String rutPadre = linePartes[4];
			Descendiente d = new Descendiente(nombre, edad, rut, rutMadre, rutPadre);
			Descendientes.add(d);

		}
	}

	public static boolean validarRut(String op) {
		// prevencion de errores: esta funcion se encarga de que op cumpla con las 
		// condiciones y formato del rut de una persona.
		if (op.strip().length() == 12) {
			boolean puntos = true;
			boolean numeros = true;
			puntos = (op.charAt(2) == '.') && op.charAt(6) == '.' && op.charAt(10) == '-';
			for (int i = 0; i < op.length(); i++) {
				if (!(devolverNumero(op.charAt(i) + " ") != -1)) {
					if (i == 2 || i == 6 || i == 10 || i == 11) {
						continue;
					}
					numeros = false;
				}

			}
			return ((puntos && numeros));
		} 
		else if (op.strip().length() == 11) {
			boolean puntos = true;
			boolean numeros = true;
			puntos = (op.charAt(1) == '.') && op.charAt(5) == '.' && op.charAt(9) == '-';
			for (int i = 0; i < op.length(); i++) {
				if (!(devolverNumero(op.charAt(i) + " ") != -1)) {
					if (i == 1 || i == 5 || i == 9 || i == 10) {
						continue;
					}
					numeros = false;
				}

			}
			return ((puntos && numeros));
		} else {
			return (false);
		}
		
	}
	
	public static Object buscarPersona(String rut) {
		// las clases Descendiente, Progenitora y Progenitor derivan de la clase object
		// esta funcion retorna un objeto de la clase "Object" este objeto sera la Progenit@r/Descendiente que estoy buscando 
		// el parametro String rut servira para buscar a esa persona dentro de los arreglos ya que este rut es unico (solo puede estar en una de estas tres listas)
		// para despues poder usar este "Object" debo castearlo tomando en cuenta ClassCastException que se encargan las funciones Opcion1() y agregarPareja()
		
		// Se entiende que se pudo haber retornado un string determinando la clase que al momento de encontrar al Progenitor/Progenitora/Descendiente por su rut
		// para asi poder hacer un casteo determinando el retorno de ese string
		for (Progenitor p : Progenitores) {
			
			if (p.getRut().equals(rut)) {
				// encontro el rut y es un progenitor
				return p;
			}
		}
		for (Progenitora p : Progenitoras) {
			if (p.getRut().equals(rut)) {
				// encontro el rut y es un progenitora
				return p;
			}
		}
		for (Descendiente d : Descendientes) {
			if (d.getRut().equals(rut)) {
				// encontro el rut y es un descendiente
				return d;
			}
		}
		return null;

	}
	public static boolean esProgenitor(Object Progenitor) {
		// su funcion es retornar un Progenitor y verificar si este puede 
		// ser casteado a una instancia Progenitor si este logra exitosamente ser casteado
		// se retorna true (el objeto es un progenitor) en caso de que 
		// no pueda ser casteado pasa al catch ClassCastException
		// retornando false (clase no puede ser casteada y no es Progenitor)
		
		try {
			// intenta castear este objeto
			Progenitor p =(Progenitor)Progenitor;
			// si pasa la linea de casteo significa que el objeto de parametro
			// es una Progenitor que no hubo problemas casteando el objeto
			return true;
		}
		catch(Exception e) {
			// no se pudo castear, no es Progenitor.
			return false;
		}
	}
	public static boolean esProgenitora(Object Progenitora) {
		// su funcion es retornar una Progenitora y verificar si este puede 
		// ser casteado a una instancia Progenitora si este logra exitosamente ser casteado
		// se retorna true (el objeto es una Progenitora) en caso de que 
		// no pueda ser casteado pasa al catch ClassCastException
		// retornando false (clase no puede ser casteada y no es Progenitora)
		try {
			// intenta castear este objeto
			Progenitora p =(Progenitora)Progenitora;
			// si pasa la linea de casteo significa que el objeto de parametro
			// es una Progenitora que no hubo problemas casteando el objeto

			return true;
		}
		catch(Exception e) {
			// no se pudo castear, no es Progenitora
			return false;
		}
		
	}
	public static boolean esDescendiente(Object Descendiente) {
		// su funcion es retornar un Descendiente y verificar si este puede 
		// ser casteado a una instancia Descendiente si este logra exitosamente ser casteado
		// se retorna true (el objeto es un Descendiente) en caso de que 
		// no pueda ser casteado pasa al catch ClassCastException
		// retornando false (clase no puede ser casteada y no es Descendiente)
		
		try {
			// intenta castear este objeto
			Descendiente p =(Descendiente)Descendiente;
			// si pasa la linea de casteo significa que el
			// objeto de parametro es un descendiente
			// que no hubo problemas casteando el objeto
			return true;
		}
		catch(Exception e) {
			// no se pudo castear, no es descendiente 
			return false;
		}
	}
	

}
