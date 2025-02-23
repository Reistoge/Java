package casting;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal creature1=new Dog("Carlos",12);
		Animal creature2=new Cat("Pedro",22);
		Animal creature3=new Animal("Giuseppe",54);
		
		//System.out.println(creature1.toString());
		
		// creature1 is a Dog and we want to cast it to a Cat to do this
		// creature1 has to be instantiate as a animal but constructed as a Dog
		// as the example if we want to cast it to a Cat instance the right object
		// or the instance has to be the same class type.
		
		creature1 = (Cat) creature2;
		
		creature3 = (Animal) creature2;
		
		System.out.println(creature1.name);
		 

	}

}
