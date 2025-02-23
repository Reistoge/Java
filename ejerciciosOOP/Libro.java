package ejerciciosOOP;

public class Libro {
	private String Titulo;
	private String Autor;
	private int añoDePublicacion;
		
	
	
	
	// dos formas de settear los atributos
	public Libro(String Titulo_, String Autor_, int añoDePublicacion_) {
		Titulo=Titulo_;
		Autor=Autor_;
		añoDePublicacion=añoDePublicacion_;
		
	}
	public void MostrarInformacion() {
		
		System.out.println("Titulo: "+Titulo);
		System.out.println("Autor: "+Autor);
		System.out.println("Año de publicacion: "+añoDePublicacion);
	
		
		
	}
	public String getTitulo() {
		return Titulo;
	}
	public String getAutor() {
		return Autor;
		
	}
	public int GetañoDePublicacion(){
		return añoDePublicacion;
	}
	public void setTitulo(String nuevoTitulo) {
		
		this.Titulo=nuevoTitulo;
	}
	public void setAutor(String nuevoAutor) {
		this.Autor=nuevoAutor;
	}
	public void SetañoDePublicacion(int nuevoañoDePublicacion) {
		this.añoDePublicacion=nuevoañoDePublicacion;
				
	}
	
	
}
