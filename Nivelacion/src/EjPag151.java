
public class EjPag151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bolsillo<Medalla> Medallero=new Bolsillo<Medalla>("Rojo");
		Medallero.GuardarEnBolsillo(new Medalla("PLATA"));
		Medallero.GuardarEnBolsillo(new Medalla("ORO"));
		Medallero.GuardarEnBolsillo(new Medalla("PLATA"));
		Medallero.GuardarEnBolsillo(new Medalla("BRONCE"));
		
		Medallero.MostrarBolsillo();
		
	}

}
