 
public class Singleton {
	
	// hacer una especie de comunicador entre clases.
	 
	private static Singleton instance;
 
	
	
	private Singleton()   {
	 
	}
	public static Singleton getInstance()   {
		
		// return (instance == null) ?  new Singleton(): instance;
		if(instance==null) {
			instance= new Singleton();
		}
		return instance;
		
		
		
	}
	 
	
	 
	
	
	
	
}
