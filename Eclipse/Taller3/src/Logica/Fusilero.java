package Logica;

public class Fusilero extends Soldado {
	String arma, clase, pesoArma;

	public Fusilero(String nombre, String rut, String contraseña, String cede, String tipo) {

		super(nombre, rut, contraseña, cede, tipo);
		// TODO Auto-generated constructor stub
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getPesoArma() {
		return pesoArma;
	}

	public void setPesoArma(String pesoArma) {
		this.pesoArma = pesoArma;
	}

	@Override
	public String notification() {
		return this.nombre + "," + this.rut + "," + this.contraseña + "," + this.cede + "," + this.tipo + ","
				+ this.arma + "," + this.clase + "," + this.pesoArma + "\n";

	}

}
