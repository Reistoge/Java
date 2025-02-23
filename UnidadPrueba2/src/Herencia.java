
public class Herencia {
		
	public static void main(String[] args) {
		SeleccionadoraEspecial x = new SeleccionadoraEspecial();
		int r =x.seleccionarMayor(10,25);
		System.out.println(r);
		
		
		
	}
}
class Seleccionadora{
	public int seleccionarMayor(int i, int j) {
		if(i>j) return i;
		return j;
	}
}
class SeleccionadoraEspecial extends Seleccionadora{
	public int seleccionarMayor(int i, int j) {
		return i+j;
		
	}
	
	
}
