import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Ejercicio1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// palindromo
		// como puedo calcular todas las palabras palindromas ?
		//File Dic=new File("0_palabras_todas.txt");
		Scanner scan=new Scanner(new File("0_palabras_todas.txt"));
		String palabra;
		String palabraR;
		int N=0;
		while(scan.hasNextLine()) {
			N++;
			palabra=scan.nextLine();
			palabra=palabra.toLowerCase().replaceAll(" " ,"");
			if(Palindromo(palabra) && palabra.length()>1) {
				System.out.print(palabra+ " : ");
				System.out.println("Es palindromo.");
				
			}
			
			
		}
		System.out.println(N);
		
			
				
	 
		
		
	}
	public static boolean Palindromo(String p) {
 
		for(int i=0;i<p.length();i++) {
			int fixedI=(p.length()-1)-i;
			Character c=p.charAt(i);
			if(!c.equals(p.charAt(fixedI))){
				return false;
			};
		}
		return true;
//		
		
		
	}

}
