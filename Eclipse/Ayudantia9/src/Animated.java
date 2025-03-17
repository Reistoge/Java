import java.util.List;

public class Animated extends Pelicula {

	String estudioAnimacion;
	String estiloAnimacion;
	public Animated(String tipo, String titulo, String año, String generos,String estudioAnimacion,String estiloAnimacion) {
		super(tipo, titulo, año, generos);

		
		this.estiloAnimacion=estiloAnimacion;
		this.estudioAnimacion=estudioAnimacion;
		
		
	}
	public String getEstudioAnimacion() {
		return estudioAnimacion;
	}
	public void setEstudioAnimacion(String estudioAnimacion) {
		this.estudioAnimacion = estudioAnimacion;
	}
	public String getEstiloAnimacion() {
		return estiloAnimacion;
	}
	public void setEstiloAnimacion(String estiloAnimacion) {
		this.estiloAnimacion = estiloAnimacion;
	}
	public String getInfo() {
		return super.getInfo()+", "+this.getEstudioAnimacion()+", "+this.estiloAnimacion;
	}

}
