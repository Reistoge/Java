import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
//1. Por cada periodo, tiempo total de impresión, impresión más rápida e impresión más 
//extensa. Considere que para calcular los minutos que demorará la impresión, debe 
//multiplicar los metros de filamento utilizado por un factor. Este será de 30 para impresión sin 
//detalle y 46 para impresión a detalle. EI tiempo debe ser expresado en días hora y minutos 
//según corresponda. 
//2. Impresiones totales y porcentaje de impresiones según calidad (detalle). 
//3. Metros usados por cada filamento con su costo, y el costo total de todas las impresiones 

public class Main {
	public static void main(String[] args) throws IOException{
		int pedidosT=0;
		Cfg.DatosFilamentos=new Cfg();
		ArrayList<ArchivoP> compras=new ArrayList<ArchivoP>();
		for(int i=0;i<Cfg.DatosFilamentos.numberOfFiles;i++) {
			System.out.println("\n\nPERIODO "+(i+1)+"\n");
			String Ruta = "Ayudantía 3/P"+(i+1)+".txt";
			
			File txt= new File(Ruta);
			ArchivoP archP= new ArchivoP(txt);
			
			
			
			//System.out.println("Detalles Periodo "+(i+1));
			
			System.out.println("Pedido más caro: ");
			archP.pedidoCaro.displayPedido();
			
			System.out.println("Pedido que requiere más tiempo: ");
			archP.pedidoTiempo.displayPedido();
			
			System.out.println("Numero de pedidos totales: "+archP.pedidosTotalesArchivo());
			pedidosT+=archP.pedidosTotalesArchivo();
			
			compras.add(archP);
			
			
			
		}
		System.out.println("Suma total de todos los pedidos: "+pedidosT);
		 
		
			
		
		
	}
	
	 
}

