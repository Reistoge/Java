import java.util.ArrayList;
import java.util.List;

public class Pedido {
	Producto producto;
	String estado;
	float diasRestantes;
	List<subscriber> clientes;
	public Pedido(Producto producto1) {
		this.producto=producto1;
		clientes= new ArrayList<subscriber>();
		
	}

	public void addObserver(subscriber cliente) {
		// TODO Auto-generated method stub
		clientes.add(cliente);
	}

	public void setEstado(String nuevoEstado) {
		// TODO Auto-generated method stub
		this.estado=nuevoEstado;
		for(subscriber s:clientes) {
			s.update(producto.getNombre()+" "+nuevoEstado);
		}
		
	}

}

