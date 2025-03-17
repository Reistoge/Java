
public class AlimentacionOptima implements AlimentacionStrategy {

	@Override
	public boolean puedeComer(Animal animal, Animal otro) {
		// TODO Auto-generated method stub
		 // si el otro no se lo puede comer y la masa es menor esta garantizado comerselo.
		if(animal==otro) {
			return false;
		}
		 if(otro.getMasa()<animal.getMasa()) {
			 if(otro.getStrat()[0] instanceof AlimentacionOptima) {
				 
				 return true;
			 }
			 
		 }
		
		return false;
		
		
		
	}

}
