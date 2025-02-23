import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class App {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan= new Scanner(System.in);
		File txt1= new File("recursos.txt");
		Biblioteca b= new Biblioteca(txt1);
		
		String op="";
		while(!op.equals("6")) {
			System.out.println("Seleccione una opcion: ");
			System.out.println("1) Ingresar recurso");
			System.out.println("2) Eliminar recurso");
			System.out.println("3) Buscar recurso por filtro");
			System.out.println("4) Informe");
			System.out.println("5) Recursos");
			System.out.println("6) Salir");	
			op= scan.nextLine();
			if(op.equals("1")) {
				b.ingresarRecurso();
			}
			else if(op.equals("2")) {
				b.eliminarRecurso();
			}
			else if(op.equals("3")) {
				b.buscarRecurso();
			}
			else if(op.equals("4")) {
				b.informe();
			}
			else if(op.equals("5")) {
				b.mostrarTodo();
			}
			
		}
		
		
	}
	
	

	public static  void Informe() {
		
	}
}
class Biblioteca{
	
	ArrayList<Recurso> recursos;	
	
	public Biblioteca(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		recursos=new ArrayList<Recurso>();
		while(scan.hasNextLine()) {
			String[] partes= scan.nextLine().split(",");
			if(partes[0].toLowerCase().equals("libro")) {
			 Recurso l= new Libro(partes[1],partes[2],partes[3],partes[4],partes[5],partes[6]);
			 	recursos.add(l);
			}
			else {
				
				Recurso v= new Video(partes[1],partes[2],partes[3],partes[4],partes[5],partes[6]);
				recursos.add(v);
				
			}
			
			
		}
	}
	public void mostrarTodo() {
		for(Recurso r: recursos) {
			mostrarRecurso(r);
		}
	}
	public void ingresarRecurso() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ingrese la informacion del nuevo recurso");
		String[] partes= scan.nextLine().split(",");
		if(partes[0].toLowerCase().equals("libro")) {
			Recurso r= new Libro(partes[1],partes[2],partes[3],partes[4],partes[5],partes[6]);
		 	recursos.add(r);
		}
		else {
			
			Recurso r= new Video(partes[1],partes[2],partes[3],partes[4],partes[5],partes[6]);
			recursos.add(r);
			
		}
	
		
		
	}
	public void eliminarRecurso() {
		System.out.println("Cual es el titulo del recurso que desea eliminar ?");
		Scanner scan= new Scanner(System.in);
		String t=scan.nextLine();
		for(Recurso r: recursos) {
			if(r.titulo.toLowerCase().equals(t.toLowerCase())) {
				recursos.remove(r);
				break;
			}	
		}
		
	}
	public void buscarRecurso() {
		Scanner scan= new Scanner(System.in);
		System.out.print("Selecciona un filtro: \n"
				+ "1)Autor\n"
				+ "2)Genero\n"
				+ "3)Año de publicacion\n"
				+ "> ");
		
		String op=scan.nextLine();
		System.out.print("Cual ?: ");
		String filtro=scan.nextLine().strip();
		System.out.println("Estos fueron los recursos encontrados.");
		if(op.equals("1")) {
			// autor
			
			for(Recurso r: recursos) {
				if(r.autor.equals(filtro)) {
					mostrarRecurso(r);
				}
			}
		}
		else if (op.equals("2")) {
			// genero
			for(Recurso r: recursos) {
				if(r.genero.toLowerCase().equals(filtro.toLowerCase())) {
					mostrarRecurso(r);
				}
			}
		}
		else if (op.equals("3")) {
			// año publicacion
			for(Recurso r: recursos) {
				if(r.publicacion.toLowerCase().equals(filtro.toLowerCase())) {
					mostrarRecurso(r);
				}
			}
		}
		
		
		
	}
	public void informe() {
		for(Recurso r: recursos) {
			
			if(r.tipo.equals("libro")) {
				boolean mostrarInfo=false;
				Libro l= (Libro) r;
				if(l.numeroDePaginas<300) {
					mostrarInfo=true;
				}
				
				if(mostrarInfo) {
					mostrarRecurso(r);
					
				}
			}
			else {
				boolean mostrarInfo=false;
				Video l= (Video) r;
				if(l.formato.toLowerCase().equals("vhs")) {
					mostrarInfo=true;
				}
				if(mostrarInfo) {
					mostrarRecurso(r);
					
				}
			}
		}
		
	}
	public void mostrarRecurso(Recurso r) {
		System.out.println(r.toString()+"\n\n"); 
	}
	
}
abstract class Recurso{
	String tipo;
	String titulo,autor,publicacion,genero;
	public Recurso(String t,String a, String p,String g) {
		this.titulo=t;
		this.autor=a;
		this.publicacion=p;
		this.genero=g;
		
	}
	
}
class Libro extends Recurso{
	int numeroDePaginas,numeroDeEdicion;
	public Libro(String t, String a, String p, String g,String nPaginas,String nEdicion) {
		super(t, a, p, g);
		this.tipo="libro";
		this.numeroDePaginas=Integer.parseInt(nPaginas);
		this.numeroDeEdicion=Integer.parseInt(nEdicion);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Libro: "+this.titulo+
				"\nAutor: "+this.autor+
				"\nPublicacion: "+this.publicacion+
				"\nGenero"+this.genero+
				"\nNumero de Paginas: "+this.numeroDePaginas+
				"\nNumero de Edicion: "+this.numeroDeEdicion;
	}
	
	

}
class Video extends Recurso{
	String formato;
	boolean subtitulos;
	public Video(String t, String a, String p, String g,String f,String s) {
		super(t, a, p, g);
		this.formato=f;
		if(s.equals("si")) {
			this.subtitulos=true;
		}
		else {
			this.subtitulos=false;
		}
		this.tipo="video";
		
		
	}
	public String toString() {
		return "Video: "+this.titulo+
				"\nAutor: "+this.autor+
				"\nPublicacion: "+this.publicacion+
				"\nGenero"+this.genero+
				"\nFormato: "+this.formato+
				"\nSubtitulos: "+this.subtitulos;
	}
}

