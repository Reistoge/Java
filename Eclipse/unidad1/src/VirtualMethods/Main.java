package VirtualMethods;

public class Main {

	// ¿estara bien hacerlo de esta manera?
	
	
	// Existe una clase Animal que es padre de Cat y Dog las 
	// clases hijas tienen un metodo en común con su clase padre.
	
	// problema: se requiere desde una instancia Cat o Dog ejecutar el metodo de la clase padre 
	// no de las clases hijas como si fuese ese metodo "por defecto de las clase animal" en relacion a las clases de herencia.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat C=new Cat("michi",3);
		
		Animal D= new Dog("firulais",23);
		
		// ver clase Animal
	 
		D.method1(D);
		C.Invoke2();
	}

}
