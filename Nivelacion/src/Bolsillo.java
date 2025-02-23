	import java.util.ArrayList;

public class Bolsillo<T1> {
	
	private ArrayList<T1> Bolsa;
	 
	 
	private String Color;
	public Bolsillo(String C ) {
		Color=C;
		Bolsa=new ArrayList<T1>();
		
		// como puedo hacer para ir checkeando el tipo de clase.
		
		 
	}
	public void GuardarEnBolsillo(T1 Obj) {
		
		Bolsa.add(Obj);
		 
		if(Obj instanceof Medalla) {
			System.out.println("Añadiste una medalla !!!");
			
		}
		
		
		
	}
	public void MostrarBolsillo() {
		
			
		 for (T1 t1 : Bolsa) {
			 if(t1 instanceof Medalla ) {
				 Medalla MedallaTemp;
				 MedallaTemp=(Medalla) t1;
				 System.out.println(MedallaTemp.getMaterial());
				 
			 }
			  
		}
		 
	}
	
	
}
