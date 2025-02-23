
public class DescuentosStrategy  {
	IStrategy estrategia;
	
	public DescuentosStrategy() {
		// TODO Auto-generated constructor stub
	}
	public void setStrategy(int opcion) {
		switch(opcion) {
		 case 1:
			estrategia= new EstanciaProlongada(); 
			break;
		 case 2:
			 estrategia = new TemporadaBaja();
		}
	}
	public IStrategy getStrategy() {
		return estrategia;
	}
	 
	
	
	
	
}
