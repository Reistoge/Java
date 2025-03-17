package nivelacion;
public class GenericsExample<T1,T2,T3> {
	
	private T1 Body;
	private T2 Head;
	private T3 Legs;
	public GenericsExample(T1 body, T2 head,T3 legs) {
		Body=body;
		Head=head;
		Legs=legs;
		System.out.println("You just create a person !!");
		
	}
	
	public static void main(String[] args) {	
		
		GenericsExample <Bodies,Legs,Heads> Persona=new GenericsExample(new Bodies(3),new Legs(4),new Heads(5));	
		System.out.println();
		
	}
}
