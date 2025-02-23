
public class StrategiaFactory {
	public static StrategiaFactory instance;
	// singleton.
	private void StrategiaFactory() {		
	}
	public static StrategiaFactory getInstance() {
		return( instance ==null ? new StrategiaFactory() : instance);
	}
	public  AlimentacionStrategy createStrategy(String tipo) {
		if("OPTIMA".equalsIgnoreCase(tipo)) {
			return new AlimentacionOptima();
		}
		else if("PACIFICA".equalsIgnoreCase(tipo)) {
			return new AlimentacionPacifica();
		}
		else if("REVERSA".equalsIgnoreCase(tipo)) {
			return new AlimentacionReversa();
		}
		else if("NORMAL".equalsIgnoreCase(tipo)) {
			return new AlimentacionNormal();
		}
		return null;
	}
	public void swapStrategies(Animal a) {
		AlimentacionStrategy temp= a.getStrat()[0];
		a.getStrat()[0]=a.getStrat()[1];
		a.getStrat()[1]=temp;
		
		
	}
}
