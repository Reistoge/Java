
public class AlimentacionNormal implements AlimentacionStrategy {

	 
	@Override
	public boolean puedeComer(Animal animal, Animal otro) {
		if(animal ==otro ) {
			return false;
		}
		if(otro.getMasa()>=animal.getMasa()){
			return false;
			
		}
		return true;
		
		
		
		
	}

}
