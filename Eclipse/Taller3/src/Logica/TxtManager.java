package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TxtManager implements IObserver{
	// esta clase se encarga de leer linea por linea los archivos.
	ArrayList<Subscriber> soldadosLine;
	
	public TxtManager() {
		soldadosLine= new ArrayList<Subscriber>();
	}
	 
	public void leerSoldados() throws FileNotFoundException {
		SoldadoFactory soldadoFactory = new SoldadoFactory();
		int n = 0;
		Scanner scan = new Scanner(new File("Soldados.txt"));
		while (scan.hasNextLine()) {
			String[] partes = scan.nextLine().split(",");
			
			
			Soldado s=soldadoFactory.crearSoldado(partes);
			addSubscriber(s);
			SistemaImp.getInstance().agregarSoldado(s);
			n++;
		}
		
		for(Soldado s: SistemaImp.getInstance().getSoldados()) {
			if(s instanceof Marino) {
				
				SistemaImp.getInstance().setMarinosDeEmbarcacion((Marino) s);
				
			}
			
		}
		
		
		if (n == SistemaImp.getInstance().getSoldados().size()) {

			System.out.println("se han cargado todos los soldados.");
		} else {
			System.out.println("no se han cargado todos los soldados");
		}

	}

	public String leerBrigadas() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("brigadas.txt"));
		while (scan.hasNextLine()) {
				String[] lineaPartes= scan.nextLine().split(",");
				Sede c= new Sede(lineaPartes[0], Integer.parseInt(lineaPartes[1]), Arrays.copyOfRange(lineaPartes, 2, lineaPartes.length-1));
				SistemaImp.getInstance().getCedes().add(c);
		}
		System.out.println("Cedes leidas correctamente.");
		return null;
	}

 
 
	public void guardarArchivos() throws IOException {
		FileWriter escritor= new FileWriter("Soldados.txt");
		String txt="";
		 
		//arturo,21.333.222-1,qJtR49LsP,coquimbo,Fusilero,AK-47,1,36
		for(Subscriber s: soldadosLine) {
			 txt+=s.notification();
		}
		escritor.write(txt);
		escritor.close();
	}

	@Override
	public void addSubscriber(Subscriber s) {
		// TODO Auto-generated method stub
		soldadosLine.add(s);
	}

	@Override
	public void removeSubscriber(Subscriber s) {
		// TODO Auto-generated method stub
		soldadosLine.remove(s);
	}

	@Override
	public void notifySubscribers() {
		 // guardar texto y modificar texto.
		try {
			guardarArchivos();
			System.out.println("se han guardado los archivos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error guardando archivos !!");
			e.printStackTrace();
		}
		
		
		
	}

	 

 
	
	
}
