import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Juego {

	public static Mapa mapa;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan=new Scanner(System.in);
		mapa= new Mapa();
		Mapa mapa2=mapa;
		Jugador j1=new Jugador("jugador1",mapa);
		Jugador j2=new Jugador("jugador2",mapa);
		while((!j1.isRendido() && !j2.isRendido()) && mapa.mapachesVivos>1) {
			System.out.println("Esta es la situación actual: ");
			mapa.mostrarCoordenadas();
			System.out.println(j1.nombre+", ¿qué quieres hacer?");
			printMenu();
			int op =scan.nextInt();
			switch (op) {
			case 0:
				j1.setRendido(true);
				System.out.println(j2.nombre+" ha ganado !!");
				
				break;
				
			case 1:
				j1.moverMapache(mapa);
				if(mapa.mapachesVivos==1) {
					j2.setRendido(true);
					System.out.println(j1.nombre+" ha ganado !!");
				}
				break;
			
			case 2:
				j1.alimentarMapache(mapa);
				break;
			case 3:
				j1.infoMapache(mapa);
				break;
			}
			if(j1.isRendido() || j2.isRendido()) {
				continue;
			}
			System.out.println("Esta es la situación actual: ");
			mapa.mostrarCoordenadas();
			System.out.println(j2.nombre+", ¿qué quieres hacer?");
			printMenu();
			op =scan.nextInt();
			switch (op) {
			case 0:
				j2.setRendido(true);
				System.out.println(j1.nombre+" ha ganado !!");
				break;
			case 1:
				j2.moverMapache(mapa);
				if(mapa.mapachesVivos==1) {
					j1.setRendido(true);
					System.out.println(j2.nombre+" ha ganado !!");
				}
				break;
			
			case 2:
				j2.alimentarMapache(mapa);
				break;
			case 3:
				j2.infoMapache(mapa);
				break;
			}
			
			
			
		}
		 
	}
	 
	public static void printMenu() {
		System.out.print("0. Rendirte\r\n"
				+ "1. Mover un mapache\r\n"
				+ "2. Alimentar un mapache\r\n"
				+ "3. Ver información de un mapache\r\n"
				+ "> ");
	}

}

class Mapa {
	int[][] coordenadas;
	int dimensionMapa;
	Mapache[] mapaches;
	int numeroMapaches;
	int mapachesVivos;

	public Mapa() throws FileNotFoundException {

		File mapachesTxt = new File("mapaches.txt");
		Scanner scanMapaches = new Scanner(mapachesTxt);
		// leemos los mapaches y el mapa
		this.numeroMapaches = Integer.parseInt(scanMapaches.nextLine());
		mapachesVivos=this.numeroMapaches;
		this.mapaches = new Mapache[numeroMapaches];
		for (int i = 0; i < this.mapaches.length; i++) {
			String line = scanMapaches.nextLine();
			
			String[] partesLine = line.split(",");

			Mapache m = new Mapache(partesLine[0], partesLine[1], partesLine[2]);
			mapaches[i] = m;
			//System.out.println(line);
		}

		File posicionesTxt = new File("mapaches_posiciones.txt");
		Scanner scanMapa = new Scanner(posicionesTxt);
		dimensionMapa = Integer.parseInt(scanMapa.nextLine()) ;
		coordenadas = new int[dimensionMapa][dimensionMapa];
		for (int i = 0; i < dimensionMapa; i++) {
			
			String[] linePartes = scanMapa.nextLine().strip().split(",");
			for (int j = 0; j < dimensionMapa; j++) {
				int casilla = Integer.parseInt(linePartes[j]);
				this.coordenadas[i][j] = casilla;

				if (casilla != 0) {
					// encontro a un mapache
					if (buscarMapaches(casilla) != null) {
						buscarMapaches(casilla).setXY(i, j);
						;
					}

				}
			}

		}
	}
	public void mostrarCoordenadas() {
		for(int i=0;i<this.dimensionMapa;i++) {
			for(int j=0;j<this.dimensionMapa;j++) {
				if(coordenadas[i][j]!=0) {
					System.out.print(" "+coordenadas[i][j]);
				}
				else {
					System.out.print(" _");
				}
			}
			System.out.println();
		}
		
	}

	public Mapache buscarMapaches(int rut) {
		for (Mapache m : mapaches) {
			if (m.getRut() == (rut)) {
				return m;
			}
		}
		return null;
	}
	public void mapacheDerrotado(int rut) {
		
		int x=buscarMapaches(rut).getY();
		int y=buscarMapaches(rut).getX();
		
		this.coordenadas[x][y]=0;
		this.mapachesVivos--;
	}
	public int getMapachesVivos() {
		return mapachesVivos;
	}
	public void setMapachesVivos(int mapachesVivos) {
		this.mapachesVivos = mapachesVivos;
	}
	public void OrdenarMapaches() {

	}

	public int[][] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(int[][] coordenadas) {
		this.coordenadas = coordenadas;
	}

	public int getDimensionMapa() {
		return dimensionMapa;
	}

	public void setDimensionMapa(int dimensionMapa) {
		this.dimensionMapa = dimensionMapa;
	}

	public Mapache[] getMapaches() {
		return mapaches;
	}

	public void setMapaches(Mapache[] mapaches) {
		this.mapaches = mapaches;
	}

	public int getNumeroMapaches() {
		return numeroMapaches;
	}

	public void setNumeroMapaches(int numeroMapaches) {
		this.numeroMapaches = numeroMapaches;
	}
}

class Mapache {
	String nombre;
	int  rut;
	float peso;
	boolean vivo;
	int x, y;
	

	public Mapache(String r, String n, String p) {
		this.rut = Integer.parseInt(r);
		this.nombre = n;
		this.peso = Integer.parseInt(p);
		vivo = true;
		x = 0;
		y = 0;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getNorte(Mapa mapa) {
		int limiteY=0;
		if(this.y<=limiteY) {
			// no se puede mover al norte
			return -1;
		}
		else {
			return mapa.getCoordenadas()[this.x][this.y-1];
		}
		 
	}
	public void moverNorte(Mapa mapa) {
		mapa.getCoordenadas()[this.x][this.y]=0;
		mapa.getCoordenadas()[this.x][this.y-1]=this.rut;
		this.y--;
		
	}
	public void moverSur(Mapa mapa) {
		mapa.getCoordenadas()[this.x][this.y]=0;
		mapa.getCoordenadas()[this.x][this.y+1]=this.rut;
		this.y++;
		
	}
	public void moverEste(Mapa mapa) {
		mapa.getCoordenadas()[this.x][this.y]=0;
		mapa.getCoordenadas()[this.x+1][this.y]=this.rut;
		this.x++;
		
	}
	public void moverOeste(Mapa mapa) {
		mapa.getCoordenadas()[this.x][this.y]=0;
		mapa.getCoordenadas()[this.x-1][this.y]=this.rut;
		this.x--;
		
	}
	public int getSur(Mapa mapa){
		int limiteY=mapa.dimensionMapa-1;
		if(this.y>=limiteY) {
			// no se puede mover al sur
			return -1;
		}
		else {
			return mapa.getCoordenadas()[this.x][this.y+1];
		}
	}
	public int getOeste(Mapa mapa) {
		int limiteX=0;
		if(this.x<=limiteX) {
			// no se puede mover al norte
			return -1;
		}
		else {
			return mapa.getCoordenadas()[this.x-1][this.y];
		}
		 
	}
	public int getEste(Mapa mapa){
		int limiteX=mapa.dimensionMapa-1;
		if(this.x>=limiteX) {
			// no se puede mover al sur
			return -1;
		}
		else {
			return mapa.getCoordenadas()[this.x+1][this.y];
		}
	}
	
	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return this.getRut()+"/"+this.getNombre()+" tiene una masa de "+this.getPeso()+"\r\n"
				+ "y vive en la celda "+(this.getX()+1)+"x"+(this.getY()+1);
	}
	

}

class Jugador {
	String nombre;
	boolean rendido;
 

	public Jugador(String n,Mapa m) {
		this.nombre = n;
		rendido=false;
		 
		
	}

	public void infoMapache(Mapa mapa) {
		Scanner scan= new Scanner(System.in);
		System.out.print("Qué mapache quieres ver? ");
		int rut=scan.nextInt();
		Mapache mSeleccionado=mapa.buscarMapaches(rut);
		System.out.println(mSeleccionado.toString());
		
		
	}

	public void alimentarMapache(Mapa mapa) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		System.out.print("Qué mapache quieres alimentar? ");
		int rut=scan.nextInt();
		Mapache mSeleccionado=mapa.buscarMapaches(rut);
		mSeleccionado.setPeso(mSeleccionado.getPeso()*1.1f);
		System.out.println(mSeleccionado.getNombre()+" ahora tiene una masa de "+mSeleccionado.getPeso());
	}

	public void moverMapache(Mapa mapa) {
		Scanner scan= new Scanner(System.in);
		System.out.print("Qué mapache quieres mover? ");
		int rut=Integer.parseInt(scan.nextLine()) ;
		Mapache mSeleccionado=mapa.buscarMapaches(rut);
		if(mSeleccionado!=null) {
			System.out.print("Hacia dónde quieres moverlo? (N/S/E/O)");
			String direccion=scan.nextLine();
			if(direccion.toLowerCase().equals("n")) {
				int casillaNorte=mSeleccionado.getNorte(mapa);
				if(casillaNorte!=-1) {
					if(casillaNorte==0) {
						// se mueve al norte
						mSeleccionado.moverNorte(mapa);
						
					}
					else {
						// combate
						Mapache contrincante;
						contrincante = mapa.buscarMapaches(casillaNorte);	
						if(contrincante.getPeso()>mSeleccionado.getPeso()) {
							mapa.mapacheDerrotado(mSeleccionado.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+contrincante.getNombre());
							
						}
						else {
							mapa.mapacheDerrotado(contrincante.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+mSeleccionado.getNombre());
						}
					}
					
				}
				else {
					System.out.println("No se puede mover en esa dirección!");
				}
				 
			}
			else if(direccion.toLowerCase().equals("s")) {
				int casillaSur=mSeleccionado.getSur(mapa);
				if(casillaSur!=-1) {
					if(casillaSur==0) {
						// se mueve al Sur
						mSeleccionado.moverSur(mapa);
						
					}
					else {
						// combate
						Mapache contrincante;
						contrincante = mapa.buscarMapaches(casillaSur);	
						if(contrincante.getPeso()>mSeleccionado.getPeso()) {
							mapa.mapacheDerrotado(mSeleccionado.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+contrincante.getNombre());
							
						}
						else {
							mapa.mapacheDerrotado(contrincante.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+mSeleccionado.getNombre());
						}
					}
					
				}
				else {
					System.out.println("No se puede mover en esa dirección!");
				}
				 
			}
			else if(direccion.toLowerCase().equals("e")) {
				int casillaEste=mSeleccionado.getEste(mapa);
				if(casillaEste!=-1) {
					if(casillaEste==0) {
						// se mueve al Este
						mSeleccionado.moverEste(mapa);
						
					}
					else {
						// combate
						Mapache contrincante;
						contrincante = mapa.buscarMapaches(casillaEste);	
						if(contrincante.getPeso()>mSeleccionado.getPeso()) {
							mapa.mapacheDerrotado(mSeleccionado.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+contrincante.getNombre());
							
						}
						else {
							mapa.mapacheDerrotado(contrincante.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+mSeleccionado.getNombre());
						}
					}
					
				}
				else {
					System.out.println("No se puede mover en esa dirección!");
				}
				
			}
			else if(direccion.toLowerCase().equals("o")) {
				int casillaOeste=mSeleccionado.getOeste(mapa);
				if(casillaOeste!=-1) {
					if(casillaOeste==0) {
						// se mueve al Oeste
						mSeleccionado.moverOeste(mapa);
						
					}
					else {
						// combate
						Mapache contrincante;
						contrincante = mapa.buscarMapaches(casillaOeste);	
						if(contrincante.getPeso()>mSeleccionado.getPeso()) {
							mapa.mapacheDerrotado(mSeleccionado.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+contrincante.getNombre());
							
						}
						else {
							mapa.mapacheDerrotado(contrincante.getRut());
							System.out.println("Compiten "+mSeleccionado.getRut()+"/"+mSeleccionado.getNombre()+""
									+ " con "+contrincante.getRut()+"/"+contrincante.getNombre()+": gana "+mSeleccionado.getNombre());
						}
					}
					
				}
				else {
					System.out.println("No se puede mover en esa dirección!");
				}
			}
			
		}
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isRendido() {
		return rendido;
	}

	public void setRendido(boolean rendido) {
		this.rendido = rendido;
	}
	

}
