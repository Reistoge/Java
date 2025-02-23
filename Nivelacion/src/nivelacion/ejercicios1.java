package nivelacion;

import java.util.Scanner;

public class ejercicios1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ejercicio 11
		float sum=0;
		float prom=0;
		int sup=0;
		Scanner scan=new Scanner(System.in);
		System.out.print("Ingrese la cantidad de notas: ");
		int n=scan.nextInt();
		float[] notas=new float[n];
		for(int i=0;i<n;i++) {
			System.out.println("Ingrese la nota "+(i+1)+":" );
			notas[i]=scan.nextFloat();
		}
		for (float f : notas) {
			sum+=f;
			
			
		}
		System.out.print("el Promedio de notas es "+prom);
		prom=sum/n;
		for (float f : notas) {
			if(f>prom) {
				sup++;
			}
		}
		System.out.println("Se ingresaron "+sup+" notas mayor que el promedio");
		
		
	}
	

}
