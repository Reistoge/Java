import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class app {
  public static ISistema sistemaPeliculas= new SistemaPeliculas();
  public static void main(String[] args) throws FileNotFoundException {
	  leerPeliculas();
	  Scanner scan= new Scanner(System.in);
	  String op="";
	  while(!op.equalsIgnoreCase("0")) {
		  menu();
		  op= scan.nextLine();
		  if(op.equalsIgnoreCase("1")) {
			  System.out.println("Ingrese los datos ");
			  System.out.println("Tipo, Título, Año, Género1/Género2, Director o Estudio, Estrellas o Estilo de Animación");
			  String input = scan.nextLine();
			  while(!sistemaPeliculas.crearPelicula(input)){
				  System.out.println("Para añadir una pelicula debe seguir esta estructura");
				  System.out.println("Tipo, Título, Año, Género1/Género2, Director o Estudio, Estrellas o Estilo de Animación");
				  input=scan.nextLine();
			  }
			  
		  }
		  else if(op.equalsIgnoreCase("2")) {
			  System.out.println("Ingrese el Nombre de la pelicula");
			  String input= scan.nextLine().strip();
			  boolean out= sistemaPeliculas.eliminarPelicula(input);
			  if(out) {
				  System.out.println(input+" fue eliminada correctamente!.");
			  }
			  else {
				  System.out.println(input+" no se ha encontrado.");
			  }
		  }
		  else if(op.equalsIgnoreCase("3")) {
			  System.out.print("Ingrese el criterio (año,genero,estilo de animacion, director) : ");
			  String criterio=scan.nextLine().strip();
			  System.out.println();
			  System.out.print("Cual: ");
			  String busqueda=scan.nextLine().strip();
			  System.out.println(sistemaPeliculas.mostrarPeliculasPorCriterio(criterio, busqueda));
		  }
		  else if(op.equalsIgnoreCase("4")) {
			  System.out.println(sistemaPeliculas.mostrarActoresUnicos());
		  }
		  else if(op.equalsIgnoreCase("5")) {
			 System.out.println("Ingrese los datos");
			 System.out.print("id/fechaInicio/fechaTermino");
			 String[] partes=scan.nextLine().strip().split("/");
			while(partes.length!=3) {
				partes=scan.nextLine().strip().split("/");
				
			}
			sistemaPeliculas.crearCartelera(partes[0], partes[1], partes[2]);
			for(int i =0; i <5;i++) {
				System.out.print("Pelicula "+i+"):");
				if(sistemaPeliculas.asignarCartelera(scan.nextLine(), partes[0])) {
					System.out.println("Pelicula "+i+" agregada con exito:");
				}
				else {
					System.out.println("hubieron problemas añadiendo esta pelicula, intente en otro momento.");
				}
				
			}
			sistemaPeliculas.mostrarCartelera(partes[0]);
			
			
		  }
	  }
	  
	  
	  
	  
	  
	  
  }
  public static void menu() {
	  System.out.println("1) Ingresar películas (de acción real y animadas).\r\n"
	  		+ "2) Eliminar películas según su título.\r\n"
	  		+ "3) Mostrar películas según los criterios de búsqueda\r\n"
	  		+ "4) Muestre la lista de actores únicos que aparecen en todas las películas.\r\n"
	  		+ "5) Generar y mostrar cartelera con 5 películas cada una\r\n"
	  		+ "\r\n"
	  		+ "");
  }
  public static void leerPeliculas() throws FileNotFoundException {
	  File txt= new File("peliculas.txt");
	  Scanner scan= new Scanner(txt);
	  while(scan.hasNextLine()) {
		  sistemaPeliculas.ingresarPelicula(scan.nextLine());
	  }
  }
}
