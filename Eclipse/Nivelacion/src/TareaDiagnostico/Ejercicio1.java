package TareaDiagnostico;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Ejercicio1 {
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Zona Zonas[]=new Zona[10];
		File textoOfertas= new File("src/TareaDiagnostico/Textos/oferta.txt");
		File textoReservas= new File("src/TareaDiagnostico/Textos/reservas.txt");
		Scanner scanOfertas=new Scanner(textoOfertas);
		Scanner scanReservas=new Scanner(textoReservas);
		int n=0;
		int noExitosa=0;
		float QuinchosTotales=0;
		float qUsados=0;
		
		while(scanOfertas.hasNextLine()) {
			//System.out.println(scanOfertas.nextLine());
			n++;
			int q=0;
			String Line=scanOfertas.nextLine();
			String[] Info = Line.split(",");
			 
			q=Info.length;
			int Quinchos[]=new int[q-1];
			for(int i=1;i<q;i++) {
				Quinchos[i-1]=Integer.parseInt(Info[i]);
			}
			Zona Z=new Zona(n,Quinchos);
			Zonas[n-1]=Z;
			
			
			
			
		}
		
		while(scanReservas.hasNextLine()) {
			//System.out.println(scanReservas.nextLine());
			String[] Line=scanReservas.nextLine().split(",");
			int[] Data=new int[3];
			Data[0]=Integer.parseInt(Line[0].strip());
			Data[1]=Integer.parseInt(Line[1].strip());
			Data[2]=Integer.parseInt(Line[2].strip());
			
			
			// 0: cantidad de personas
			// 1: quincho
			// 2: Numero de zona
			
			Reserva R=new Reserva(Data[0],Data[1],Data[2]);
			
			R.DetReserva(Zonas[Data[2]-1]);
			if(R.getExitosa()) {
				float ingreso=Zonas[R.getNumeroZona()].getIngreso();
				
				Zonas[R.getNumeroZona()].setIngreso(ingreso+R.DetIngreso());
				int num=Zonas[R.getNumeroZona()].getDisponibilidad();
				Zonas[R.getNumeroZona()].setDisponibilidad(num-Data[1]);
				qUsados++;
				 
				
				//System.out.println(R.CantidadPersonas);
			}
			else {
				noExitosa++;
				
				//System.err.println(R.CantidadPersonas);
			}
			
			
			
		}
		for (Zona zona : Zonas ) {
			float disponibilidad=zona.getDisponibilidad();
			float total=zona.getQuinchos().length;
			QuinchosTotales+=zona.getQuinchos().length;
			if(zona.getIngreso()>0) {
				
				System.out.println(zona.getNumeroZona());
				System.out.println(zona.getIngreso());
				System.out.println(total);
				System.out.println(disponibilidad);
				System.out.println();
				
				 
				
				 
				
			}
			 
		}
		 
		
		System.out.println(noExitosa);
		System.out.println(QuinchosTotales);
		System.out.println(qUsados);
		System.out.println(100*qUsados/QuinchosTotales);
		
		
	}

}
