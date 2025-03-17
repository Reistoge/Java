import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {
	
		int[][] coordenadas;
		int dimensionMapa;

		public Mapa() throws FileNotFoundException {

			File mapachesTxt = new File("mapaches.txt");
			Scanner scanMapaches = new Scanner(mapachesTxt);


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

		
}

