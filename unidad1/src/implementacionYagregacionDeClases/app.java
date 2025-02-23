package implementacionYagregacionDeClases;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaPersonas Bolsa1= new ListaPersonas(4);
		Persona p1=new Persona(12, "Pedro", "21456732");
		Persona p2=new Persona(21, "gvbe", "45456732");
		Persona p3=new Persona(56, "erf", "67436732");
		Persona p4=new Persona(6, "Ag", "11111111");
		Persona p5=new Persona(7, "45", "22222222");

		Bolsa1.registrarPersona(p1);
		Bolsa1.registrarPersona(p2);
		Bolsa1.registrarPersona(p3);
		Bolsa1.registrarPersona(p4);
		Bolsa1.agregarPersona(p5);
		Bolsa1.eliminarPersona("11111111");
		
		 
		System.out.println(Bolsa1.toString());
			
	
	}

}
