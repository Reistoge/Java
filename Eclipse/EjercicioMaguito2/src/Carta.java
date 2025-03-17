
public class Carta {
	String simbolo;
	int valor;
	public Carta(String simbolo) {
		this.simbolo=simbolo;
		if("A".equalsIgnoreCase(simbolo)) {
			this.valor=1;
			
		}
		else if("K".equalsIgnoreCase(simbolo)) {
			this.valor=13;
		}
		else if("J".equalsIgnoreCase(simbolo)) {
			this.valor=11;
		}
		else if("Q".equalsIgnoreCase(simbolo)) {
			this.valor=12;
		}
		else {
			this.valor= Integer.parseInt(simbolo.strip());
		}
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
