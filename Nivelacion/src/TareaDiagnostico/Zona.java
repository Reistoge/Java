package TareaDiagnostico;

public class Zona {
	int numeroZona;
	float Ingreso;
	int Quinchos[];
	int Disponibilidad;
	
	public Zona(int Zona,int quinchos[]) {
		numeroZona=Zona;
		Quinchos=quinchos;
		Disponibilidad=sumArr(quinchos);
		Ingreso=0;
		
	}
	public int getNumeroZona() {
		return numeroZona;
	}
	public int[] getQuinchos() {
		return Quinchos;
	}
	
	public float getIngreso() {
		return Ingreso;
	}
	public int getDisponibilidad() {
		return Disponibilidad;
	}
	
	
	public void setDisponibilidad(int disponibilidad) {
		Disponibilidad = disponibilidad;
	}
	public void setIngreso(float ingreso) {
		Ingreso = ingreso;
		
	}
	public void setQuinchos(int[] quinchos) {
		Quinchos = quinchos;
		
	}
	public int sumArr(int[] Quinchos) {
		int sum=0;
		for (int i : Quinchos) {
			sum+=i;
		}
		return sum;
	}
	int BinarySearch(int Q) {
		int i=0;
		int j=Quinchos.length-1;
		int k=0;
		while(i<=j) {
			k=(i+j)/2;
			if(Quinchos[k]>Q) {
				j=k-1;
			}
			else if(Quinchos[k]<Q) {
				i=k+1;
			}
			else {
				return Quinchos[k];
			}
		
			 
		}
		return 0;
	}
	
	 
}
