// enunciado: 
// Proceso de cobro de un supermercado; es decir, unos clientes van con un carro lleno de
// productos y una cajera les cobra los productos, pasándolos uno a uno por el escaner de la
// caja registradora. En este caso la cajera debe de procesar la compra cliente a cliente, es
// decir que primero le cobra al cliente 1, luego al cliente 2 y así sucesivamente.
// Para ello vamos a definir una clase "Cajera" y una clase "Cliente" el cual tendrá un "array de
// enteros" que representaran los productos que ha comprado y el tiempo que la cajera tardará
// en pasar el producto por el escaner; es decir, que si tenemos un array con [1,3,5] significará
// que el cliente ha comprado 3 productos y que la cajera tardara en procesar el producto 1 '1
// segundo', el producto 2 '3 segundos' y el producto 3 en '5 segundos', con lo cual tardara en
// cobrar al cliente toda su compra '9 segundos
 
public class Test1 {
	public static void main(String[] args) {
		// queremos procesar primero el cliente 1 y despues la compra del cliente 2
		// tardando en procesar ambas compras un tiempo de 26 segundos.
		
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");

		long initalTime = System.currentTimeMillis();
		cajera1.procesarCompra(cliente1, initalTime);
		cajera2.procesarCompra(cliente2, initalTime);

	}
}

class Cajera {
	private String nombre;

	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	public void procesarCompra(Cliente cliente, long timeStamp) {
		System.out.println("la cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
				+ cliente.getNombre() + " EN EL TIEMPO " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			// esperamos
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesando el producto " + (i + 1) + " -> tiempo: "
					+ (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
		}

		System.out.println("La cajera " + this.getNombre() + " HA TERMINADO DE PROCESAR " + cliente.getNombre()
				+ " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + " seg");
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

}

class Cliente {

	private String nombre;
	private int[] carroCompra;

	public Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}

}
