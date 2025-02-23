import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoP {
	public Pedido pedidoCaro=new Pedido();
	public Pedido pedidoTiempo=new Pedido();
	ArrayList<Pedido> pedidosArchivoP=new ArrayList<Pedido>();
	
	public ArchivoP(File txt) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		
		
		Scanner scan= new Scanner(txt);
		while(scan.hasNextLine()) {
			String lineaDePedido = scan.nextLine();
			Pedido p=new Pedido(lineaDePedido);
			pedidosArchivoP.add(p);
			//p.displayPedido();
			
			
		}
		// mostrar info
		for(int i=0;i<pedidosArchivoP.size();i++) {
			
			if(pedidosArchivoP.get(i).tiempo>pedidoTiempo.tiempo) {
				pedidoTiempo=pedidosArchivoP.get(i);
			}
			if(pedidosArchivoP.get(i).precioT>pedidoCaro.precioT) {
				pedidoCaro=pedidosArchivoP.get(i);
			}
			
			//System.out.println("------------------------");
			
			
			
			
			
		}
		 
		
		
		
	}
	public int pedidosTotalesArchivo() {
		return pedidosArchivoP.size();
	}
	
}

class Pedido {
	String id;
	float metros;
	boolean detalle;
	String material;
	float tiempo;
	float precioT;
	public Pedido() {
		material="";
		detalle=false;
		id="";
		tiempo=0;
		precioT=0;
		metros=0;
	}
	public Pedido(String linea) {
		// TODO Auto-generated constructor stub
		String datosDePedido[]=linea.split(",");
		id=datosDePedido[0];
		metros=Float.parseFloat(datosDePedido[1]);
		if(datosDePedido[2].toLowerCase().equals("verdadero")) {
			detalle=true;
			tiempo=metros*46;
		}
		else {
			detalle=false;
			tiempo=metros*30;
		}
		material=datosDePedido[3];
		precioT=metros*Cfg.DatosFilamentos.getPrecioFilamento(material);
		 
		
		
		
	}
	public void displayPedido() {
		 
		System.out.println("Id: "+id);
		System.out.println("Material: "+material);
		System.out.println("Precio total: "+precioT);
		System.out.println("Tiempo requerido: "+ tiempo+" min's");
		System.out.println("-------------------------------------");
		
	}
	
	
	
}

