package Logica;

public class Piloto extends Soldado {
	String lugarEspionaje, tipoNave, alturaVuelo;

	public Piloto(String nombre, String rut, String contraseña, String cede, String tipo) {
		super(nombre, rut, contraseña, cede, tipo);
		// TODO Auto-generated constructor stub
		lugarEspionaje = "";
		tipoNave = "";
		alturaVuelo = "";
	}

	public String getLugarEspionaje() {
		return lugarEspionaje;
	}

	public void setLugarEspionaje(String lugarEspionaje) {
		this.lugarEspionaje = lugarEspionaje;
	}

	public String getTipoNave() {
		return tipoNave;
	}

	public void setTipoNave(String tipoNave) {
		this.tipoNave = tipoNave;
	}

	public String getAlturaVuelo() {
		return alturaVuelo;
	}

	public void setAlturaVuelo(String alturaVuelo) {
		this.alturaVuelo = alturaVuelo;
	}

	@Override
	public String notification() {
		return this.nombre + "," + this.rut + "," + this.contraseña + "," + this.cede + "," + this.tipo + ","
				+ this.lugarEspionaje + "," + this.tipoNave + "," + this.alturaVuelo + "\n";
	}

	 

}
