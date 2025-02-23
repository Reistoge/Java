
public class Test3 implements Runnable {
	// convertir un proceso sincronizado/secuencial 
	// a uno asyncrono paralelizado con threads.
	// ocupando clases que hacen codigo secuencial.
	// variables de cada subproceso independiente
	private Cliente cliente;
	private Cajera cajera;
	private long initalTime;
	
	public Test3(Cliente cliente,Cajera cajera,long initalTime) {
		this.cajera=cajera;
		this.cliente=cliente;
		this.initalTime=initalTime;
		
	}
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		Cajera  cajera1 = new Cajera ("Cajera 1" );
		Cajera  cajera2 = new Cajera ("Cajera 2" );
		
		long initialTime = System.currentTimeMillis();
		// se crea los distintos subprocesos.
		Runnable proceso1= new Test3(cliente1, cajera1, initialTime);
		Runnable proceso2= new Test3(cliente2, cajera2, initialTime);
		// comenzamos el proceso 1 que tomara x tiempo.
		new Thread(proceso1).start();
		// y tambien el  proceso 2 que tomara y tiempo (simultaneamente).
		new Thread(proceso2).start();
		
	}
	@Override
	public void run() {
		// al comenzar un proceso o un Test3 queremos que ejecute su procesar compra.
		this.cajera.procesarCompra(cliente, initalTime);
	}
	
}

