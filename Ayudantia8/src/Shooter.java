
public class Shooter extends Videojuego{
	 
	String cantidadArmasDisponibles,esMultijugador;
	public Shooter(String[] line) {
		super(line);
		this.cantidadArmasDisponibles = line[6].strip();
		this.esMultijugador = line[7].strip();
	}


	@Override
	public String getInfo() {
		return super.info(this)+
				"Cantidad de armas disponibles:"+ this.cantidadArmasDisponibles+"\r\n"
				+ "Multijugador:"+this.esMultijugador;
		// TODO Auto-generated method stub
		
	}
	
}
