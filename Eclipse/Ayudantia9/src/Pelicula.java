import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Pelicula {
	String tipo,titulo,año;
	List<String> generos;
	String g;
	protected Pelicula(String tipo, String titulo, String año, String generos) {
		this.tipo = tipo;
		this.titulo = titulo;
		this.año = año;
		this.g=generos;
		String[] generosPartes=generos.split("/");
		this.generos = new ArrayList<String>(Arrays.asList(generosPartes));
		
	}
	public static Pelicula crearPelicula(String line) {
		String[] partesLine=line.split(",");
		String tipo=partesLine[0];
		String titulo=partesLine[1];
		String año=partesLine[2];
		String genero=partesLine[3];
		Pelicula p=null;
		if(tipo.equalsIgnoreCase("animated")) {
			String estudioAnimacion=partesLine[4];
			String estiloAnimacion=partesLine[5];
			  p= new Animated(tipo,titulo,año,genero,estudioAnimacion,estiloAnimacion);
		}
		else if(tipo.equalsIgnoreCase("realaction")) {
			String director=partesLine[4];
			String estrellas=partesLine[5];
			  p = new RealAction(tipo,titulo,año,genero,director,estrellas);
			
		}
		return p;
		
		
		
	 
	}
	public String getInfo() {
		return this.getTipo()+", "+this.getTitulo()+", "+this.getAño()+", "+this.getG();
	}
	 
	public static String peliculaToString(Pelicula p) {
		return p.getInfo();
	}
	 
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public List<String> getGeneros() {
		return generos;
	}
	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	
}
