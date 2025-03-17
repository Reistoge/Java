import java.util.ArrayList;
import java.util.List;

public class ProductoFactory {
	List<Producto> productos;

	public ProductoFactory() {
		productos= new ArrayList<Producto>();
	}
	public void crearProducto(String[] datos) {
		String tipo=datos[0];
		String nombre=datos[1];
		String marca=datos[2];
		String precio=datos[3];
		Producto p = findProducto(datos);
		if(p==null) {
			if(tipo.equalsIgnoreCase("computer")) {
				Computador c = new Computador(tipo, nombre, marca, precio);
				c.setAlmacenamiento(datos[4]);
				p=(Producto) c;
			}
			else if(tipo.equalsIgnoreCase("clothing")) {
				Ropa r = new Ropa(tipo, nombre, marca, precio);
				 
				r.setTalla(datos[4]);
				p = (Producto) (r);
			}
			
		}
		productos.add(p);

	}
	public Producto findProducto(String[] datos) {
		String tipo=datos[0];
		String marca= datos[2];
		String nombre=datos[1];
		for(Producto temp : productos) {
			if(temp.getTipo().equals(tipo)) {
				if(tipo.equalsIgnoreCase("computer")) {
					 
					Computador c2= (Computador) temp;
					String almacenamiento=datos[4];
					if(almacenamiento.equalsIgnoreCase(c2.getAlmacenamiento() )&& nombre.equalsIgnoreCase(temp.getNombre())) {
						return temp;
					};
				}
				else if(tipo.equalsIgnoreCase("clothing")) {
					String talla = datos[4];
					Ropa r = (Ropa) temp;
					if(r.getTalla().equalsIgnoreCase(talla)&& r.getMarca().equalsIgnoreCase(marca)&&r.getNombre().equalsIgnoreCase(nombre)) {
						return temp;
					}
					
					
				}
			}
//			if(tipo.equalsIgnoreCase("computer") && nombre.equalsIgnoreCase(temp.getNombre())) {
//				
//			}
//			else if( ) {
//				Ropa r2= (Ropa) temp;
//				String talla=datos[4];
//				if(talla.equalsIgnoreCase(r2.getTalla())) {
//					return temp;
//				};
//			}
		} 
		return null;
		
	}
	
	
	
}
