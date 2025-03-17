import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zoo {
	private List<Animal> animales= new LinkedList<>();
	
	public void agregarAnimal(Animal animal) {
		this.animales.add(animal);
		
		
	}

	public void ejecutar() {
		while(true) {
				int n = animales.size();
				darUnaVuelta();
				if(animales.size()== n) break;
				
		}
		
		
	}

	private void darUnaVuelta() {
		for(int i =0; i<animales.size(); i++) {
			animales.get(i).vivir(this);
		}
		
	}

	public List<Animal> getCercanos(int x, int y) {
		// TODO Auto-generated method stub
		
		
		List<Animal> cercanos = new ArrayList<Animal>();
		for(Animal a : animales) {
			if( esCercano(a,x,y)) {
				cercanos.add(a);
			}
		}
		return cercanos;
	}

	private boolean esCercano(Animal a, int x, int y) {
		
		// el zoo provee un metodo para que los animales puedan saber
		// que otros animales los rodean
		double dx= a.getX()-x;
		double dy=a.getY()-y;
		double d= Math.sqrt(dx*dx+dy*dy);
		if(d==0) {
			return false;
		}
		return d<30;
		
	}



	public void remover(Animal a) {
		
		this.animales.remove(a);
	}
 
}
