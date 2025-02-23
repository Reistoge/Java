package Logica;

import java.util.ArrayList;
import java.util.List;

public class Marino extends Soldado {
	String embarcacion, puestoEmbarcacion;
	 ArrayList<Marino> marineros;
	public Marino(String nombre, String rut, String contraseña, String cede, String tipo) {
		super(nombre, rut, contraseña, cede, tipo);
		// TODO Auto-generated constructor stub
		marineros= new ArrayList<Marino>();
	}

	public String getEmbarcacion() {
		return embarcacion;
	}

	public void setEmbarcacion(String tipoEmbarcacion) {
		this.embarcacion = tipoEmbarcacion;
	}

	public String getPuestoEmbarcacion() {
		return puestoEmbarcacion;
	}

	public void setPuestoEmbarcacion(String puestoEmbarcacion) {
		this.puestoEmbarcacion = puestoEmbarcacion;
	}

	public ArrayList<Marino> getMarineros() {
		return marineros;
	}

	public void setMarineros(ArrayList<Marino> marineros) {
		this.marineros = marineros;
	}

	@Override
	public String notification() {
		return this.nombre + "," + this.rut + "," + this.contraseña + "," + this.cede + "," + this.tipo + ","
				+ this.embarcacion + "," + this.puestoEmbarcacion + "\n";
	}
	

}
 
