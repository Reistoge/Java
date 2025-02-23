import java.util.List;

public class Perro extends Animal {

	public Perro(String n, double masa, int x, int y, AlimentacionStrategy strat) {
		super(n, masa, x, y, strat);
		// TODO Auto-generated constructor stub
		this.strat[1]= StrategiaFactory.getInstance().createStrategy("reversa");
	}
	
	public void vivir(Zoo mundo) {
		// cada animal buscara los mas
		// cercanos y evaluara si los puede comer
		
		System.out.println(this.getNombre()+" está viviendo");
		List<Animal> posibles = mundo.getCercanos(x,y);
		for(Animal a : posibles ) {
				
			if(!strat[0].puedeComer(this, a)  ) {
				setVida(getVida() - 1);
				continue;
			}
			System.out.println("\t"+this.getNombre()+" se come a "+a.getNombre());
			System.out.println("\ty cambia su estrategia a reversa.");
			StrategiaFactory.getInstance().swapStrategies(this);
			mundo.remover(a);
		}
		
	}

}
