import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Cfg {
	public static Cfg DatosFilamentos;
	int numberOfFiles;
	ArrayList<Filamento> filamentos=new ArrayList<Filamento>();
	
	public Cfg() throws FileNotFoundException {
		File txt= new File("Ayudantía 3/config.txt");
		Scanner scan= new Scanner(txt);
		numberOfFiles=Integer.parseInt(scan.nextLine());
		while(scan.hasNextLine()) {
			String linea=scan.nextLine();
			Filamento f= new Filamento(linea);
			filamentos.add(f);
			
		}
		scan.close();
	}
 
public float getPrecioFilamento(String n) {
	
	for(int i=0;i<filamentos.size();i++) {
		if(filamentos.get(i).material.toLowerCase().equals(n.toLowerCase())) {
			return filamentos.get(i).precio;
		}
		
		
	}
	return 0;
	//  binary search
	
	
}
class Filamento{
	String material;
	float precio;
	public Filamento(String linea) {
		 material=linea.strip().split(",")[0];
		 precio=Float.parseFloat(linea.strip().split(",")[1]);
	}
	

}
}

