
public class Configuracion {
	
	// singleton
	private String rutaDB = "jdbc:mysql://localhost:3306/mydatabase"; 
	private String hostServidor = "http://localhost:8080"; 
	private String operacion = "dev"; 
	private String temaUI = "dark"; 
	private static Configuracion instance;
	
	private Configuracion() {
		
	}
	public static Configuracion getInstance() {
		if(instance==null) {
			instance = new Configuracion();
			
		}
		return instance;
	}
	@Override
	public String toString() {
		return "Configuracion [rutaDB=" + rutaDB + ", hostServidor=" + hostServidor + ", operacion=" + operacion
				+ ", temaUI=" + temaUI + "]";
	}
}
