import java.util.List;

public class Animal {
	protected int x,y;
	protected double masa;

	protected String nombre;
	protected AlimentacionStrategy[] strat;
	protected int vida;
	public Animal(String n,double masa,int x, int y, AlimentacionStrategy strat) {
		this.x = x;
		this.y = y;
		this.nombre= n;
		this.masa= masa;
		this.strat = new AlimentacionStrategy[2];
		this.strat[0]=strat;
		this.setVida(3);
		
	}

	
//	AlimentacionStrategy estrategiaReversa= new AlimentacionReversa();
//	AlimentacionStrategy estrategiaNormal= new AlimentacionNormal( );
//	Al ser la estrategia parte del animal, puede ser llamada con su propio comportamiento.
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
			
			mundo.remover(a);
		}
		
	}
	public AlimentacionStrategy[] getStrat() {
		return strat;
	}
	public void setStrat(AlimentacionStrategy[] strat) {
		this.strat = strat;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

		
		
		
		
		
		
		
		
	
	
}
