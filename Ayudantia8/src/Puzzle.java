
public class Puzzle extends Videojuego {
	
	String numeroNiveles,dificultad;
 
	public Puzzle(String[] line) {
		super(line);
		this.numeroNiveles = line[6].strip();
		this.dificultad = line[7].strip();
	}
	@Override
	public String getInfo() {
		return	super.info(this)+"Numero de niveles: "+this.numeroNiveles+"\n"
					+ "dificultad"+this.dificultad;
	}


	 
	 
	
	
	
}
