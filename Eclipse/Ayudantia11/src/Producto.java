public abstract class Producto {
	String tipo,nombre,marca,precio;
	 
	
	public Producto(String tipo, String nombre, String marca, String precio) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public abstract void accept(DescuentoVisitor v);
 
}
class Computador extends Producto{
	String almacenamiento;
	public Computador(String tipo, String nombre, String marca, String precio) {
		super(tipo, nombre, marca, precio);
		// TODO Auto-generated constructor stub
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	@Override
	public void accept(DescuentoVisitor v) {
		// TODO Auto-generated method stub
		v.visitar(this);
	}
	

	
}
class Ropa extends Producto{
	String talla;
	public Ropa(String tipo, String nombre, String marca, String precio) {
		super(tipo, nombre, marca, precio);
		// TODO Auto-generated constructor stub
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public void accept(DescuentoVisitor v) {
		// TODO Auto-generated method stub
		v.visitar(this);
	}
	
	

}
