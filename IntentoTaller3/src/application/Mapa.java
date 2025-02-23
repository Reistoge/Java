package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {
	Mapache[] mapaches;
	int[][] posiciones;
	int dimensionMapa;
	int cantidadMapaches;
	public Mapa() throws FileNotFoundException {
		File txtMapaches = new File("mapaches.txt");
		File txtMapa= new File("mapaches_posiciones.txt");
		Scanner scan= new Scanner(txtMapaches);
		// leemos los mapaches
		 
		String linea=scan.nextLine();
		cantidadMapaches=Integer.parseInt(linea); 
		mapaches= new Mapache[cantidadMapaches];
		for(int i =0; i<cantidadMapaches; i++) {
			linea=scan.nextLine();
			String[] partesLinea=linea.split(",");
			Mapache m= new Mapache(partesLinea[0],partesLinea[1],partesLinea[2]);
			mapaches[i]=m;
			
		}
		scan= new Scanner(txtMapa);
		dimensionMapa=Integer.parseInt(scan.nextLine()); 
		posiciones= new int[dimensionMapa][dimensionMapa];
		
		int n=0;
		while(scan.hasNextLine()) {
			String[] fila= scan.nextLine().split(",");
			for(int i =0; i <dimensionMapa;i ++) {
				int casilla=Integer.parseInt(fila[i]);
				 posiciones[n][i]=casilla; 
				 if(casilla>0) {
					 // hay mapache
					Mapache mapacheCasilla=buscarMapache(casilla);
					if(mapacheCasilla!=null) {
						mapacheCasilla.setFil(n);
						mapacheCasilla.setCol(i);
					}
					 
				 }
				 
			}
			n++;
			
		}
		
		
		 
			
		 
		
		
		
	}
	public Mapache[] getMapaches() {
		return mapaches;
	}
	public void setMapaches(Mapache[] mapaches) {
		this.mapaches = mapaches;
	}
	public int[][] getMapa() {
		return posiciones;
	}
	public void setMapa(int[][] mapa) {
		this.posiciones = mapa;
	}
	public int getCantidadMapaches() {
		return cantidadMapaches;
	}
	public void setCantidadMapaches(int cantidadMapaches) {
		this.cantidadMapaches = cantidadMapaches;
	}
	
	public void moverMapache(int rutMapacheMover, String direccion) {
		// TODO Auto-generated method stub
		Mapache m=buscarMapache(rutMapacheMover);
		if(m!=null) {
			int col= m.getCol();
			int fil= m.getFil();
			 
			if("N".equalsIgnoreCase(direccion)) {
				 if(fil-1<0) {
					 // no se mueve mapache
				 }
				 else if(posiciones[fil-1][col]!=0) {
					 // se encontro con mapache
					 Mapache m2=buscarMapache(posiciones[fil-1][col]);
					 
					 if(m2!=null) {
						 
						 // combate
						 if(m2.getGramos()>m.getGramos()) {
							 // m2 gana a m;
							 m.setVivo(false);
							 posiciones[m.getFil()][m.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m2.getNombre());
							 
						 }
						 else {
							 // m gana a m2
							 m2.setVivo(false);
							 posiciones[m2.getFil()][m2.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m.getNombre());
						 }
						 
						 
					
					 }
				 }
				 else if(posiciones[fil-1][col]==0) {
					 posiciones[fil][col]=0;
					 posiciones[fil-1][col]=m.rut;
					 m.setFil(fil-1);
				 }
				 
			}
			else if("S".equalsIgnoreCase(direccion)) {
				 if(fil+1==dimensionMapa) {
					 // no se mueve mapache
				 }
				 else if(posiciones[fil+1][col]!=0) {
					 // se encontro con mapache
					 Mapache m2=buscarMapache(posiciones[fil+1][col]);
					 
					 if(m2!=null) {
						 
						 // combate
						 if(m2.getGramos()>m.getGramos()) {
							 // m2 gana a m;
							 m.setVivo(false);
							 posiciones[m.getFil()][m.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m2.getNombre());
							 
						 }
						 else {
							 // m gana a m2
							 m2.setVivo(false);
							 posiciones[m2.getFil()][m2.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m.getNombre());
						 }
						 
						 
					
					 }
				 }
				 else if(posiciones[fil+1][col]==0) {
					 // old pos
					 posiciones[fil][col]=0;
					 // nueva pos
					 posiciones[fil+1][col]=m.rut;
					 m.setFil(fil+1);
				 }
				 
			}
			else if("O".equalsIgnoreCase(direccion)) {
				 if(col-1<0) {
					 // no se mueve mapache
				 }
				 else if(posiciones[fil][col-1]!=0) {
					 // se encontro con mapache
					 Mapache m2=buscarMapache(posiciones[fil][col-1]);
					 
					 if(m2!=null) {
						 
						 // combate
						 if(m2.getGramos()>m.getGramos()) {
							 // m2 gana a m;
							 m.setVivo(false);
							 posiciones[m.getFil()][m.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m2.getNombre());
							 
						 }
						 else {
							 // m gana a m2
							 m2.setVivo(false);
							 posiciones[m2.getFil()][m2.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m.getNombre());
						 }
						 
						 
					
					 }
				 }
				 else if(posiciones[fil][col-1]==0) {
					 posiciones[fil][col]=0;
					 posiciones[fil][col-1]=m.rut;
					 m.setCol(col-1);
				 }
				 
				
			}
			else if("E".equalsIgnoreCase(direccion)) {
				if(col+1==dimensionMapa) {
					 // no se mueve mapache
				 }
				 else if(posiciones[fil][col+1]!=0) {
					 // se encontro con mapache
					 Mapache m2=buscarMapache(posiciones[fil][col+1]);
					 
					 if(m2!=null) {
						 
						 // combate
						 if(m2.getGramos()>m.getGramos()) {
							 // m2 gana a m;
							 m.setVivo(false);
							 posiciones[m.getFil()][m.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m2.getNombre());
							 
						 }
						 else {
							 // m gana a m2
							 m2.setVivo(false);
							 posiciones[m2.getFil()][m2.getCol()]=0;
							 cantidadMapaches-=1;
							 System.out.println("Compiten "+m.getRut()+"/"+m.getNombre()+" con "+m2.getRut()+"/"+m2.getNombre()+": gana "+m.getNombre());
						 }
						 
						 
					
					 }
				 }
				 else if(posiciones[fil][col+1]==0) {
					 posiciones[fil][col]=0;
					 posiciones[fil][col+1]=m.rut;
					 m.setCol(col+1);
				 }
				 
			
			}
		}
		else {
			System.out.println("no se ha encontrado el mapache");
		}
		 
	}
	public void alimentarMapache(int rutMapacheAlimentar) {
		// TODO Auto-generated method stub
		Mapache m=buscarMapache(rutMapacheAlimentar);
		if(m!=null) {
			
			m.alimentar();;
		}
		else {
			System.out.println("no se ha encontrado el mapache");
		}
	}
	public Mapache buscarMapache(int rutMapacheBuscar) {
		// TODO Auto-generated method stub
		for(Mapache m : mapaches) {
			if(m.getRut()==rutMapacheBuscar) {
				return m;
				
			}
		}
		return null;
		
	}
	public void mostrarMapa() {
		for(int i =0;i<dimensionMapa;i++) {
			for(int j=0;j<dimensionMapa;j++) {
				if(posiciones[i][j]==0) {
					System.out.print(" ___ ");
				}
				else {
					System.out.print(" "+posiciones[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	public String mapaToString() {
		String texto="";
		for(int i =0;i<dimensionMapa;i++) {
			for(int j=0;j<dimensionMapa;j++) {
				if(posiciones[i][j]==0) {
					texto+=" ___ ";
				}
				else {
					texto+=posiciones[i][j]+" ";
				}
			}
			texto+="\n";
		}
		return texto;
	}
	public void verInformacionMapache(int rutMapacheBuscar) {
		// TODO Auto-generated method stub
		Mapache m=buscarMapache(rutMapacheBuscar);
		if(m!=null) {
			
			System.out.println(m.getInformacion());
		}else {
			System.out.println("no se ha encontrado el mapache");
		}
		
	}
	
		
	
}
