
public class HabitacionFactory {

	public HabitacionFactory() {
		
	}
	public Habitacion crearHabitacion(String[] datos) {
		 
		// TODO Auto-generated method stub
		 String numeroH=datos[0];
		 String tipoH=datos[1];
		 float precioPorNoche = Float.parseFloat(datos[2]);
		 if(tipoH.equalsIgnoreCase("Sencilla")) {
			 Sencilla s = new Sencilla(numeroH,tipoH,precioPorNoche);
			 s.setDesayuno(datos[3]);
			 return s;
		 }
		 else if(tipoH.equalsIgnoreCase("Doble")){
			 Doble d = new Doble(numeroH,tipoH,precioPorNoche);
			 d.setNumeroDeCamas(Integer.parseInt(datos[3]));
			 return d;
		 }
		 else if(tipoH.equalsIgnoreCase("Suite")) {
			 Suite sui=new Suite(numeroH,tipoH,precioPorNoche);
			 sui.setAccesoLounge(datos[3]);
			 return sui;
		 }
		 return null;
	}

}
