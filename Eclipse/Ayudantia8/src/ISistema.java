
public interface ISistema {
	
	 
	// todos los sistemas pueden eliminar un Videojuego
	void eliminarVideojuego(String nombre);
	

	boolean ingresarVideojuego(String nextLine);

	String busqueda(String criterio,String busqueda);
	String noJugados(String tipo);
	int tiempoTotalRpg( );
}
