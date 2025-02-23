import java.util.ArrayList;
import java.util.Scanner;

public class EntendiendoArrayListContraLinkedList {
	
}
class ejemplo{
	public static Scanner scan= new Scanner(System.in);
	ArrayList<A1> bolsa1;
	ArrayList<A2> bolsa2;
	ArrayList<A3> bolsa3;
	// intento de usar clases parecidas sin herencia.
    //ArrayList<A3> bolsa4=new ArrayList<A1>() ---> tiene que ser la misma y una sola clase dentro de <>;
	public ejemplo() {

		//¿ que queremos hacer al crear este conjunto de bolsas  ?
		bolsa1=new ArrayList<A1>();// ---> solo almacena instancias de clase A1
		bolsa2=new ArrayList<A2>();// ---> solo almacena instancias de clase A2
		bolsa3=new ArrayList<A3>();// ---> solo almacena instancias de clase A3
	}
	public void agregarA1() {
		System.out.println("Ingrese parametros de nuevo A1");
		String op=scan.nextLine();
		
		
	}
	public void agregarA2() {
		System.out.println("Ingrese parametros de nuevo A2");
		String op=scan.nextLine();
		
	}
	public void agregarA3() {
		System.out.println("Ingrese parametros de nuevo A3");
		String op=scan.nextLine();
		
	}
	
}
// Clases de ejemplo (posiciones)
class A1{
	int x,y;
	int z;
	public A1() {
		x=0;
		y=0;
		z=0;
	}
	public A1(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
class A2{
	int x,y;
	float w;
	
	public A2() {
		x=0;
		y=0;
		w=0;
	}
	public A2(int x, int y, float w) {
		this.x=x;
		this.y=y;
		this.w=w;
	}
}
class A3{
	int x,y;
	boolean g;
	public A3() {
		x=0;
		y=0;
		g=false;
	}
	public A3(int x, int y, boolean g) {
		this.x=x;
		this.y=y;
		this.g=g;
	}
}
