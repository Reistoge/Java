
public class DescuentoVisitor {

	public void visitar(Ropa r) {
		double precio=Double.parseDouble(r.getPrecio())*0.8f;
		System.out.println("Aplicando 20% de descuento en ropa: "+r.getNombre()+" "+r.getMarca()+" precio original: "+r.getPrecio());
		System.out.println("Precio con descuento: "+precio);
		r.setPrecio(String.valueOf(precio));
	}
	public void visitar(Computador c) {
		double precio=Double.parseDouble(c.getPrecio())*0.9f;
		System.out.println("Aplicando 10% de descuento en Computadores: "+c.getNombre()+" "+c.getMarca()+" precio original: "+c.getPrecio());
		System.out.println("Precio con descuento: "+precio);
		c.setPrecio(String.valueOf(precio));
	}
	 
}
