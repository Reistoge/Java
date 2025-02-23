 

public class Pinta {
	Carta cartas[];
	int tamaño;
	String letra;
	public Pinta(int t,String[] textoPinta) {
		this.tamaño=t;
		this.cartas= new Carta[t-1];
		letra = textoPinta[0];
		for(int i =1; i <textoPinta.length; i++) {
			Carta c = new Carta(textoPinta[i]);
			this.cartas[i-1]=c;
		}
		
		
	};
	public void ordenarPinta(int pos){
		if(pos%2==0) {
			for(int i =0; i<cartas.length;i++) {
				for(int j =i+1; j<cartas.length;j++) {
					if(cartas[i].valor>cartas[j].valor) {
						Carta temp= cartas[i];
						cartas[i]=cartas[j];
						cartas[j]=temp;
						
					}
				}
			}
		}
		else {
			for(int i =0; i<cartas.length;i++) {
				for(int j =i+1; j<cartas.length;j++) {
					if(cartas[i].valor<cartas[j].valor) {
						Carta temp= cartas[i];
						cartas[i]=cartas[j];
						cartas[j]=temp;
						
					}
				}
			}
			
		}
		
	}
	public Carta[] getCartas() {
		return cartas;
	}
	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	
}
