
public interface ISistema {
	void ingresarPelicula(String input);
	boolean eliminarPelicula(String input);
	String mostrarPeliculasPorCriterio(String input,String input2); 
	String mostrarActoresUnicos();
	public boolean crearPelicula(String line);
	public boolean asignarCartelera(String titulo,String Cartelera);
	public void crearCartelera(String id, String fechaInicio,String fechaTermino);
	public String mostrarCartelera(String input);
	 
	 	
	 
}
