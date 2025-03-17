import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RealAction extends Pelicula{

	List<String > estrellas;
	String director;
	String e;
	public RealAction(String tipo, String titulo, String año, String generos,String director, String estrellasToString) {
		super(tipo, titulo, año, generos);
		// TODO Auto-generated constructor stub
		this.director=director;
		this.e=estrellasToString;
		String[] estrellasPartes=estrellasToString.split("/");
		this.estrellas = new ArrayList<String>(Arrays.asList(estrellasPartes));
		
		
	}
	public List<String> getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(List<String> estrellas) {
		this.estrellas = estrellas;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getInfo() {
		return super.getInfo()+", "+this.getDirector()+", "+this.e;
	}

}
