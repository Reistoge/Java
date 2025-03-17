package ruteo1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ruteo{
	public static void main(String[] args) throws IOException{
		A [] arreglo = new A [5];
		int a1 = subprograma1(arreglo);
		
		System.out.println();
		subprograma7(arreglo,a1);
		 
		System.out.println();
		subprograma3(arreglo);
		
		int x = subprograma5(arreglo,a1);
		 
		
		System.out.println("x= "+ x);
		
	}
	public static void subprograma7(A[] arreglo,int c) {
		A [] arreglo2 = new A [c];
		
		for(int i = 0; i < c-1; i++) {
			arreglo2[i]=arreglo[i+1];
		}
		System.out.println();
		
		arreglo2[c-1]= arreglo2[0];
		for (A a : arreglo2) {
			System.out.println(a.toString());
		}
		for(int i = 0; i < c; i++) {
			arreglo[i]= arreglo2[i];
		}
	}
	public static int subprograma1(A[] arreglo) throws IOException{
		int b1 = 0;
		File file = new File("src/archivo.txt");
		Scanner scan = new Scanner (file);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String [] datos = linea.split(",");
			int dato1=0;
			int dato2= 0;
			for(int i =0; i < datos.length; i++) {
				dato1 = Integer.valueOf(datos[0]);
				dato2 = Integer.valueOf(datos[1]);
			}
			A a = new A(dato1, dato2);
			arreglo[b1]= a;
			b1++;
		}
		scan.close();
		return b1;
	}
	public static void subprograma3(A[] vector1) {
		
		int M = 9;
		double N = M/2;
		N = N - 0.5;
		int p = (int) N;
		for(int i = 0; i < p; i++) {
			vector1[i].setA1(vector1[i].getA1()*2);
		}
		 
	}
	public static int subprograma5(A[] vector2, int cont) {
		int r = 0;
		for (int i = 0; i < cont; i++) {
			r = r + vector2[i].getA1();
		}
		return r;
	}
	

		 
	
}

