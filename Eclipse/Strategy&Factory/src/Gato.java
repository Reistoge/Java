import java.util.List;

public class Gato extends Animal{

	public Gato(String n, double masa, int x, int y, AlimentacionStrategy strat) {
		super(n, masa, x, y, strat);
		// TODO Auto-generated constructor stub
		getStrat()[1]= StrategiaFactory.getInstance().createStrategy("pacifica");
	}
	
	public void vivir(Zoo mundo) {
		// cada animal buscara los mas
		// cercanos y evaluara si los puede comer
		
		System.out.println(this.getNombre()+" está viviendo");
		List<Animal> posibles = mundo.getCercanos(x,y);
		for(Animal a : posibles ) {

			if(!strat[0].puedeComer(this, a)  ) {
				setVida(getVida() - 1);
				
				if(getVida()==1) {
					System.out.println("La estrategia de alimentacion de"+this.getNombre()+" es ahora optima");
					StrategiaFactory.getInstance().createStrategy("optima");
				}
				
				continue;
			}
			System.out.println("\t"+this.getNombre()+" se come a "+a.getNombre());
			
			mundo.remover(a);
		}
		
	}
	
	

}
