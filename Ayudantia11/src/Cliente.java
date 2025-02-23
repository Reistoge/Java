
public class Cliente  implements subscriber{
	String nombre;
	public Cliente(String n) {

	
		this.nombre= n;
	}
	@Override
	public void update(String s) {
		// TODO Auto-generated method stub
		System.out.println("mira "+this.nombre+" hay nueva informacion sobre este pedido: "+s);
	}
	

	 
}
interface subscriber{
	void update(String s);
}
