package IntentoPrueba1;
import java.util.*;
public class Universidad {
	static String[] Roles;
	static String[] Unidades;
	public static Persona[] personas;
	public static void main(String[] args) {
		personas=new Persona[0];
		Roles= new String[0];
		Unidades=new String[0];
		System.out.println(personas.length);
		 
		
		menu();
		
	}
	public static void menu() {
		Scanner scan=new Scanner(System.in);
		//Scanner scan=new Scanner(System.in);
		System.out.println("UCN");
		System.out.println("        MENU        ");
		System.out.println("seleccione una opcion");
		printOpciones();
		
		int opcion=scan.nextInt();
		while(opcion<0 || opcion >4) {
			System.out.println("Opcion invalida");
			System.out.println("seleccione una opcion: ");
			printOpciones();
			opcion=scan.nextInt();
		}
		
		if(opcion==1) {
			opcion1();
		}
		else if(opcion==2) {
			opcion2();
		}
		else if(opcion==3) {
			opcion3();
		}
		else if(opcion==4);{
			opcion4();
		}
	}
	public static void printOpciones() {
		System.out.println("1) Agregar Persona:");
		System.out.println("2) Agregar Unidad");
		System.out.println("3) Asociar Persona a una unidad entre ciertas fechas");
		System.out.println("4) Reportabilidad");
	}
	public static Persona[] agregarPersona(Persona p) {
		Persona[] nuevaP= new Persona[personas.length+1];
		for(int i=0;i<personas.length;i++) {
			nuevaP[i]=personas[i];
			
		}
		nuevaP[personas.length]=p;
		personas=nuevaP;
		
		
		return null;
	}
	public static void agregarRol(String r) {
		String[] nuevaR= new String[Roles.length+1];
		for(int i=0;i<Roles.length;i++) {
			nuevaR[i]=Roles[i];
			
		}
		nuevaR[Roles.length]=r;
		Roles=nuevaR;
		
		
		 
	}
	public static void agregarUnidad(String r) {
		String[] nuevaR= new String[Unidades.length+1];
		for(int i=0;i<Unidades.length;i++) {
			nuevaR[i]=Unidades[i];
			
		}
		nuevaR[Unidades.length]=r;
		Unidades=nuevaR;
		
		
	}
	public static void opcion1() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Ingrese el nombre de la persona: ");
		String nombre=scan.nextLine();
		System.out.print("Ingrese el rut:  ");
		String rut=scan.nextLine();
		
		Persona p= new Persona(rut,nombre);
		agregarPersona(p);
		
		// leemos el rol de la nueva persona y su unidad
		System.out.print("cuantos roles quiere agregar a esta nueva persona ?");
		int n=scan.nextInt();
		for(int i=0;i<n;i++) {
			scan=new Scanner(System.in);
			System.out.print("Rol de la persona: ");
			String nombreDelRol=scan.nextLine();
			
//			if(p.isRol(nombreDelRol)){
//				System.out.println("La persona ya cumple con este rol, desea añadir una nueva unidad a este rol ?");
//				System.out.println("ingrese la nueva unidad.");
//				// mostrar roles de la persona
//				nombreDelRol=scan.nextLine().toLowerCase().strip();
//			}
			
			 
			 
			System.out.print("A que unidad pertenece este rol ?:  ");
			String nombreUnidadRol=scan.nextLine()  ;
			
			System.out.print("Fecha de inicio");
			String fechaInicio=scan.nextLine()  ;
			
			System.out.print("Fecha de termino");
			String fechaTermino=scan.nextLine()  ;
			
			if(!is(nombreDelRol,Roles)) {
				System.out.println("Rol Nuevo !!");
				agregarRol(nombreDelRol);
			}
			if(!is(nombreUnidadRol,Unidades)) {
				System.out.println("Unidad Nueva !!");
				agregarUnidad(nombreUnidadRol);
			}
			
			boolean añadir=true;
			
			Rol rolP= new Rol(fechaInicio, fechaTermino, nombreDelRol,nombreUnidadRol, p);
			if(i!=0) {
				
				for(Rol r: p.roles) {
					
					if(r.equals(rolP)) {añadir=false;}
				}
			}
			if(añadir ) {
				p.agregarRol(rolP);
				
			}
			
		}
		
		
		
		System.out.println("Persona agregada exitosamente !!");
		
		
		
		
		
		
	}
	
	
	public static void opcion2() {
		
	}
	public static void opcion3() {
		
	}
	public static void opcion4() {
		
	}
	public static void rolDePersonasPorFecha() {
		
	}
	public static void cantPersonasEnCadaUnidad() {
		
	}
	public static void buscarPersona(String rut) {
		
	}
	public static void historialRoles() {
		
	}
	public static boolean is(String s, String[] array) {
		for (String strings: array) {
			if(strings.equals(s)) {
				return true;
			}
		}
		return false;
	}
	public static Persona personaAnt() {
		return null;
	}
	public static Persona personaRoles() {
		return null;
		
		
	}
	
	

}
