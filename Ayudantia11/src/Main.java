import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Producto> productos = new ArrayList<Producto>(); 
		leerArchivo(productos); 
		// Mostrar configuración 
		Configuracion config = Configuracion.getInstance(); 
		System.out.println(config.toString()); 
		
		
		// Aplicar descuento 
		DescuentoVisitor descuentoVisitor = new DescuentoVisitor(); 
		for (Producto producto : productos) { 
			producto.accept(descuentoVisitor); 
		} 
		
		
		// Obtener productos 
		Producto producto1 = productos.get(0); 
		Producto producto2 = productos.get(5); 
		
		
		// Crear pedido 
		Pedido pedido1 = new Pedido(producto1); 
		Pedido pedido2 = new Pedido(producto2); 
		Cliente cliente1 = new Cliente("Alice"); 
		Cliente cliente2 = new Cliente("Bob"); 
		
		
		// Procesar pedido 
		PedidoProcessor pedidoProcessor = new PedidoProcessor(); 
		pedidoProcessor.setStrategy(new PedidoEstandarProcessing()); 
		pedidoProcessor.procesar(pedido1); 
		pedidoProcessor.setStrategy(new PedidoExpressProcessing()); 
		pedidoProcessor.procesar(pedido2); 
		
		
		// Notificar a clientes del envío 
		pedido1.addObserver(cliente1); 
		pedido1.addObserver(cliente2); 
		pedido1.setEstado("En camino");
	}

	private static void leerArchivo(ArrayList<Producto> productos) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ProductoFactory pf = new ProductoFactory();
		Scanner scan = new Scanner(new File("productos.txt"));
		while(scan.hasNextLine()) {
			pf.crearProducto(scan.nextLine().split(","));
			
		}
		productos.addAll(pf.productos);
	}
}
