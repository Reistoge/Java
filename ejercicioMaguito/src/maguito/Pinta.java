package maguito;

import java.util.Arrays;

public class Pinta {
	String letraPinta;
	Carta[] cartasPinta;
	int cantidadCartas;
	public Pinta(String line) {
		String[] linePartes=line.split(",");
		letraPinta=linePartes[0];
		cantidadCartas=linePartes.length-1;
		cartasPinta= new Carta[cantidadCartas];
		for(int i=1; i<=cantidadCartas;i++) {
			Carta c=new Carta(linePartes[i].strip(),this);
			cartasPinta[i-1]=c;
		}
		
		
	}
	public void ordenarCartas(int n) {
		n+=1;
		if(n%2==0) {
			for(int i=0;i<this.cantidadCartas;i++) {
				for(int j=0;j<this.cantidadCartas;j++) {
					if(cartasPinta[i].getValor()>cartasPinta[j].getValor()) {
						// swap
						Carta tempC= cartasPinta[i];
						cartasPinta[i]=cartasPinta[j];
						cartasPinta[j]=tempC;
						
						
						
					}
				}
			}
			
		}
		else {
			for(int i=0;i<this.cantidadCartas;i++) {
				for(int j=0;j<this.cantidadCartas;j++) {
					if(cartasPinta[i].getValor()<cartasPinta[j].getValor()) {
						// swap
						Carta tempC= cartasPinta[i];
						cartasPinta[i]=cartasPinta[j];
						cartasPinta[j]=tempC;
						
						
						
					}
				}
			}
		}
		
	}
	 
	public void mostrarCartas() {
		for(Carta c : cartasPinta) {
			System.out.print( c.toString()+" ");
		}
	}
	public String getLetraPinta() {
		return letraPinta;
	}
	public void setLetraPinta(String letraPinta) {
		this.letraPinta = letraPinta;
	}
	public Carta[] getCartasPinta() {
		return cartasPinta;
	}
	public void setCartasPinta(Carta[] cartasPinta) {
		this.cartasPinta = cartasPinta;
	}
	public int getCantidadCartas() {
		return cantidadCartas;
	}
	public void setCantidadCartas(int cantidadCartas) {
		this.cantidadCartas = cantidadCartas;
	}
	
}
