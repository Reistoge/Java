
public class Test2 {
//	¿Y si en vez de procesar primero un cliente y después otro, 
//	procesásemos los dos a la vez?
//	 ¿Cuanto tardaría el programa en ejecutarse?
//	 Pues bien si en vez de haber solo una Cajera (es decir un solo hilo), hubiese dos 
//	Cajeras (es decir dos hilos o threads) podríamos procesar los dos clientes a la vez y 
//	tardar menos tiempo en ejecutarse el programa. 
//	Para ello debemos de modificar la clase "Cajera.java" y hacer que esta clase herede 
//	de la clase Thread para heredar y sobre-escribir algunos de sus métodos. Primero 
//	vamos a ver como codificamos esta nueva clase "CajeraThread.java" y después 
//	explicamos sus caracteristicas
	
	
	
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		long initialTime = System.currentTimeMillis();
		CajeraThread cajera1 = new CajeraThread("Cajera 1",cliente1,initialTime);
		CajeraThread cajera2 = new CajeraThread("Cajera 2",cliente2,initialTime);

		cajera1.start();
		cajera2.start();
	}
}
class CajeraThread extends Thread {
	private String nombre;
	private Cliente cliente;
	private long initialTime;
	 
	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	@Override
	public void run( ) {
		System.out.println("la cajera " + this.nombre + " COMIENZA A PROCESAR PARALELAMENTE LA COMPRA DEL CLIENTE "
				+ cliente.getNombre() + " EN EL TIEMPO " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			// esperamos
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesando el producto " + (i + 1) + " -> tiempo: "
					+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}

		System.out.println("La cajera " + this.getNombre() + " HA TERMINADO DE PROCESAR " + cliente.getNombre()
				+ " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + " seg");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.currentThread().interrupt();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}
	

}
 
