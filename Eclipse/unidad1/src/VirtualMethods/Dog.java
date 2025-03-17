package VirtualMethods;

public class Dog extends Animal{

	public Dog(String n, int e) {
		super(n, e);
		 
	}
	// especial de perro
	public void method1() {
		System.out.println("Specific method 1");
	}
	
	
}
