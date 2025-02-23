
public class AnimalFactory {

	public static AnimalFactory instance;
	// singleton.
	private void AnimalFactory() {		
	}
	public static AnimalFactory getInstance() {
		return( instance ==null ? new AnimalFactory() : instance);
	}
	public void process(Animal a,String tipo) {
		if("gato".equalsIgnoreCase(tipo)) {
			a=(Gato) a;
			 
		}
		else if("perro".equalsIgnoreCase(tipo)) {
			a = (Perro) a;
			 
		}
		else if("rata".equalsIgnoreCase(tipo)) {
			a = (rata) a;
			 
		}
		 
	}
	 
	
}
