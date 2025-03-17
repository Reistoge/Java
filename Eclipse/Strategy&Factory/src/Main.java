import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

//		TODO:
//		-PERMITIR ESPECIFICAR LA ESTRATEGIA DE ALIMENTACION A CADA ANIMAL POR SEPARADO.
//		-AGREGAR ESTRATEGIA NUEVA, SIMULAR A LOS ANIMALES QUE NO SE COMEN A OTROS ANIMALES.
		
//		TODO EXTRA:
//		-CREA UN TIPO DE ANIMAL QUE CADA CIERTA CANTIDAD DE LLAMaDAS AL METODO VIVIR CAMBIE DE ESTRATEGIA.
//		-HAZ QUE RECIBA DOS ESTRATEGIAS EN EL CONSTRUCTOR Y QUE CAMBIE ENTRE ELLAS DESPUESDE CADA LLAMADA A VIVIR.
		
//		
 
		
		
		Main m = new Main();
		m.ejecutar();
	}
	private Zoo zoo = new Zoo();
	private void ejecutar() throws FileNotFoundException {
		this.leer();
		this.zoo.ejecutar();
		
	}
	private void leer() throws FileNotFoundException {
		Scanner lector = new Scanner (new File("animales.txt"));
		Scanner input= new Scanner(System.in);
		
		String line=lector.nextLine();
		System.out.println(line);
		
		AlimentacionStrategy strat= crearEstrategiaAlimentación(line);
		
		while(lector.hasNextLine()) {
			line=lector.nextLine();
			System.out.println(line);
			System.out.print("Que estrategias quieres aplicar a este animal ?"
					+ "\n1) Normal"
					+ "\n2) Reversa"
					+ "\n3) Pacifica"
					+ "\n4) Optima (%5 menos de masa)"
					+ "\n> ");
			String op= input.nextLine();
			if("1".equalsIgnoreCase(op.strip())) {
				strat= StrategiaFactory.getInstance().createStrategy("normal");
			}
			else if("2".equalsIgnoreCase(op.strip())) {
				strat= StrategiaFactory.getInstance().createStrategy("reversa");
				
			}
			else if("3".equalsIgnoreCase(op.strip())) {
				strat= StrategiaFactory.getInstance().createStrategy("pacifica");
			}
			else if("4".equalsIgnoreCase(op.strip())) {
				strat= StrategiaFactory.getInstance().createStrategy("optima");
			}
			
			System.out.println(line);
			System.out.print("Que Clase de Animal es ?"
					+ "\n1) Gato"
					+ "\n2) Perro"
					+ "\n3) Rata"
					+ "\n> ");
			 // creamos un animal puede ser un animal o un tipo de animal
			 ;
			String tipo= input.nextLine();
			if("1".equalsIgnoreCase(op.strip())) {
					tipo="gato";
				}
					
			else if("2".equalsIgnoreCase(op.strip())) {
					 tipo="perro";
					
				}
			else if("3".equalsIgnoreCase(op.strip())) {
					 tipo="rata";
				
			}
			else {
				tipo="normal";
			}
				
			crear(strat, line,tipo);
			
			 
			
			
			
			
				
			
		}
		lector.close();
		input.close();
	}
	private AlimentacionStrategy crearEstrategiaAlimentación(String estratLine) {
		
		if("ALIM_NORMAL".equals(estratLine)) {
			
			return new AlimentacionNormal();
		}
		else if("ALIM_REVERSA".equals(estratLine)){
			return new AlimentacionReversa();
		}
		else if("ALIM_PACIFICA".equals(estratLine)) {
			return new AlimentacionPacifica();
		}
		else if("ALIM_OPTIMA".equals(estratLine)) {
			return new AlimentacionOptima();
		}
		return null;
	}
	
	
	
	private void crear(AlimentacionStrategy strat, String line, String tipo) {
		
		String[] p =line.split(",");
		String nombre= p[0];
		double masa=Double.parseDouble(p[1]);
		int x =Integer.parseInt(p[2]);
		int y = Integer.parseInt(p[3]);
		if(strat instanceof AlimentacionOptima) {
			masa*=0.95f;
		}
		 
		if("perro".equalsIgnoreCase(tipo)) {
			zoo.agregarAnimal(new Perro (nombre,masa,x,y,strat));
		}
		else if("gato".equalsIgnoreCase(tipo)) {
			zoo.agregarAnimal(new Gato (nombre,masa,x,y,strat));
		}
		else if("rata".equalsIgnoreCase(tipo)) {
			zoo.agregarAnimal(new rata (nombre,masa,x,y,strat));
		}
		else {
			zoo.agregarAnimal(new Animal (nombre,masa,x,y,strat));
			
		}
	}

}
