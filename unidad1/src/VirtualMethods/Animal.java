package VirtualMethods;



public class Animal {
	String name;
	int age;
	
	public Animal(String n, int e) {
		name=n;
		age=e;
		
		
	}
	// llamamos a la clase principal con this osea a Animal ejecutando su metodo.
	// para esto solo cambiamos el argumento de los metodos 1 o 2 para que se diferencien de los de las clases hijas
	// aun asi no se podria escribir la misma función ( mismos argumentos ) ya que se ejecuta automaticamente la de la clase hija.
	
	public void Invoke2() {method2(this);};
	public void Invoke1() { method1(this); }
	
	
	// por defectos que todo animal puede hacer.
	
	public void method1(Animal A) {
		
		System.out.println("method 1");
		
	}
	public void method2(Animal A) {
		System.out.println("method 2");
	}
 
}
