package application;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Juego {
	public static Mapa m;
	
	public Juego() throws FileNotFoundException {
		
		
		m = new Mapa();
		Jugador j0= new Jugador("jugador 0");
		Jugador j1= new Jugador("jugador 1");
		while(!j0.perdio && !j1.perdio) {
			// jugador 0
			Turno(j0,j1);
			if(j0.isPerdio() || j1.isPerdio()) {
				if(j0.isPerdio()) {
					// gana j1
					System.out.println("El "+j1.getNombre()+" ha ganado!" );
					j0.setPerdio(true);
					break;
				}
				else if(j1.isPerdio()){
					// gana j0
					System.out.println("El "+j0.getNombre()+" ha ganado!" );
					j1.setPerdio(true);
					break;
				}

			}
			// jugador 1
			Turno(j1,j0);
			if(j0.isPerdio() || j1.isPerdio()) {
				if(j0.isPerdio()) {
					// gana j1
					System.out.println("El "+j1.getNombre()+" ha ganado!" );
					j0.setPerdio(true);
					break;
				}
				else if(j1.isPerdio()){
					// gana j0
					System.out.println("El "+j0.getNombre()+" ha ganado!" );
					j1.setPerdio(true);
					break;
				}

			}
			
			
		}
		m.mostrarMapa();
		
		
	}
	public static void MostrarMenu(Jugador j) {
		System.out.println("Esta es la situacion actual: ");
		m.mostrarMapa();
		System.out.print(j.nombre+", ¿qué quieres hacer?\r\n"
				+ "0. Rendirte\r\n"
				+ "1. Mover un mapache\r\n"
				+ "2. Alimentar un mapache\r\n"
				+ "3. Ver información de un mapache\r\n"
				+ "> ");
	}
	public static void Turno(Jugador j0, Jugador j1) {
		Scanner scan=new Scanner(System.in);
		MostrarMenu(j0);
		int input=Integer.parseInt(scan.nextLine().strip());
		switch(input) {
			case 0:
				// se rinde gana jugador 1;
				j0.setPerdio(true);
				break;
				
			case 1:
				System.out.println("Qué mapache quieres mover? ");
				int rutMapacheMover=Integer.parseInt(scan.nextLine().strip()) ;
				System.out.println("Hacia dónde quieres moverlo? (N/S/E/O) ");
				String direccion= scan.nextLine().strip();
				m.moverMapache(rutMapacheMover,direccion);
				if(m.cantidadMapaches==1) {
					j1.setPerdio(true);
				}
				// jugador 0 mueve mapache introduce rut mapache y direccion;
				break;
			case 2:
				System.out.println("Qué mapache quieres alimentar? ");
				int rutMapacheAlimentar=scan.nextInt();
				m.alimentarMapache(rutMapacheAlimentar);
				
				break;
				
				// alimenta a mapache introduce rut de mapache;
			case 3: 
				System.out.println("Qué mapache quieres ver? ");
				int rutMapacheBuscar=scan.nextInt();
				m.verInformacionMapache(rutMapacheBuscar);
				break;
				// informacion del mapache se introduce rut;
		}
		
		
	}

}
