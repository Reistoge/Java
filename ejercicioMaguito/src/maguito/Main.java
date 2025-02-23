package maguito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Pinta[] Pintas=new Pinta[4];
		// TODO Auto-generated method stub
		File txt= new File("file.txt");
		Scanner scan =new Scanner(txt);
		int n=0;
		while(scan.hasNextLine()) {
			String line=scan.nextLine();
			
			Pinta p=new Pinta(line);
			Pintas[n]=p;
			n++;
			
			
		}
		Pintas=ordenarPintas(Pintas);
		for(int i =0 ;i<Pintas.length;i++) {
			Pintas[i].ordenarCartas(i);
		}
		for(Pinta p: Pintas) {
			System.out.print(p.getLetraPinta()+" ");
			p.mostrarCartas();
			System.out.println();
		}
		
		
		
	}
	public static Pinta[] ordenarPintas(Pinta[] Pintas) {
		for(int i=0;i<Pintas.length;i++) {
			for(int j=0;j<Pintas.length;j++) {
				if(Pintas[i].getCantidadCartas()>Pintas[j].getCantidadCartas()) {
					// swap
					Pinta tempP= Pintas[i];
					Pintas[i]=Pintas[j];
					Pintas[j]=tempP;
					
					
					
				}
			}
		}
		return Pintas;
	}

}
