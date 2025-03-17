
public class Rpg extends Videojuego{
	String duracion,numeroPersonajes;

	 

	public Rpg(String[] line) {
		super(line);
		this.duracion=line[6].strip();
		this.numeroPersonajes=line[7].strip();
	}



	@Override
	public String getInfo() {
		
		return  super.info(this)+
				"Duracion: "+this.duracion+"\r\n"
				+ "Numero de Personajes: "+this.numeroPersonajes+"\n";
		// TODO Auto-generated method stub
		
	}

}
