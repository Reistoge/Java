import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class main {

	
//	• Las pintas y sus cartas deben ser ordenadas de forma descendente, considerando la cantidad de cartas que 
//	poseen las pintas. 
//	• Las filas pares deben ser ordenadas forma ascendente:  (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K). 
//	• Las filas impares deben ser ordenadas de forma descendente: (K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, A). 
	public static Pinta[] pintas;
	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO Auto-generated method stub
		File txt =new File("baraja.txt");
		Scanner scan = new Scanner(txt);
		pintas= new Pinta[4];
		int n=0;
		while(scan.hasNextLine()) {
			String[] partesLinea= scan.nextLine().split(",");
			
			Pinta p = new Pinta(partesLinea.length,partesLinea );
			pintas[n]=p;
			
			n++;
		}
		ordenarPintas();
		mostrarPintas();
		
		
		
	}
	public static void ordenarPintas() {
		for(int i =0; i<pintas.length;i++) {
			for(int j =i+1; j<pintas.length;j++) {
				if(pintas[i].tamaño<pintas[j].tamaño) {
					Pinta temp= pintas[i];
					pintas[i]=pintas[j];
					pintas[j]=temp;
					
				}
			}
		}
		
		for(int k =0; k<pintas.length;k++) {
				pintas[k].ordenarPinta(k);
				
			 
		}
	}
	public static void mostrarPintas() {
		for(Pinta p: pintas) {
			System.out.print(p.letra+" ");
			for(Carta c: p.getCartas()) {
				System.out.print(c.simbolo+" ");
			}
			System.out.println();
		}
	}
	 

}
