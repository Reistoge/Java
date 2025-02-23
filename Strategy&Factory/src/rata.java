import java.util.List;

public class rata extends Animal {

	public rata(String n, double masa, int x, int y, AlimentacionStrategy strat) {
		super(n, masa, x, y, strat);
		// TODO Auto-generated constructor stub
		getStrat()[1]= StrategiaFactory.getInstance().createStrategy("normal");
	}
	public void vivir(Zoo mundo) {
		// cada animal buscara los mas
		// cercanos y evaluara si los puede comer
		
		System.out.println(this.getNombre()+" está viviendo");
		List<Animal> posibles = mundo.getCercanos(x,y);
		for(Animal a : posibles ) {
				
			
			
			if(!strat[0].puedeComer(this, a)  ) {
				StrategiaFactory.getInstance().swapStrategies(a);
				System.out.println("\t"+this.getNombre()+" le cambio su estrategia a "+a.getNombre() +" !!");
				continue;
			}
			else if(getVida()%2==0) {
				StrategiaFactory.getInstance().swapStrategies(this);
				System.out.println("\t"+this.getNombre()+" cambio su estrategia !!");
				continue;
			}
			System.out.println("\t"+this.getNombre()+" se come a "+a.getNombre());
			StrategiaFactory.getInstance().swapStrategies(this);
			mundo.remover(a);
		}
		
	}


}
