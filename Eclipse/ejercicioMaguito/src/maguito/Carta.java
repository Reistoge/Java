package maguito;

public class Carta {
	String n;
	int valor;
	Pinta pintaDeCarta;
	 public Carta(String n,Pinta p) {
		 this.n=n;
		 switch (n) {
		 	case "A":
		 		valor=1;
		 		break;
		 	case "J":
		 		valor=11;
		 		break;
		 	case "Q":
		 		valor=12;
		 		break;
		 	case "K":
		 		valor=13;
		 		break;
		 	default:
		 		valor=Integer.parseInt(n);
		 }
		 pintaDeCarta=p;
	 }
	
	@Override
	public String toString() {
		return   n ;
	}

	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Pinta getPintaDeCarta() {
		return pintaDeCarta;
	}
	public void setPintaDeCarta(Pinta pintaDeCarta) {
		this.pintaDeCarta = pintaDeCarta;
	}
}
