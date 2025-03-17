
public class Habitacion {
	String nombre;
	String norte;
	String sur;
	String este;
	String oeste;

	boolean entrada;

	boolean salida;
	boolean dragon;
	boolean oro;

	public Habitacion(String n) {
		nombre = n;
		norte = "wall";
		sur = "wall";
		oeste = "wall";
		este = "wall";

	}

	public boolean isEntrada() {
		return entrada;
	}

	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNorte() {
		return norte;
	}

	public void setNorte(String norte) {
		this.norte = norte;
	}

	public String getSur() {
		return sur;
	}

	public void setSur(String sur) {
		this.sur = sur;
	}

	public String getEste() {
		return este;
	}

	public void setEste(String este) {
		this.este = este;
	}

	public String getOeste() {
		return oeste;
	}

	public void setOeste(String oeste) {
		this.oeste = oeste;
	}

	public boolean isSalida() {
		return salida;
	}

	public void setSalida(boolean salida) {
		this.salida = salida;
	}

	public boolean isDragon() {
		return dragon;
	}

	public void setDragon(boolean dragon) {
		this.dragon = dragon;
	}

	public boolean isOro() {
		return oro;
	}

	public void setOro(boolean oro) {
		this.oro = oro;
	}

	public void setDireccion(String d, String h) {
		if (d.equals("n")) {
			// this.norte=h;
			setNorte(h);
		}
		if (d.equals("s")) {
			// this.sur=h;
			setSur(h);
		}
		if (d.equals("o")) {
			// this.oeste=h;
			setOeste(h);
		}
		if (d.equals("e")) {
			// this.este=h;
			setEste(h);
		}

	}

	public void setDireccionOpuesta(String d, String h) {
		if (d.equals("n")) {
			setSur(h);

		}
		if (d.equals("s")) {
			setNorte(h);
		}
		if (d.equals("o")) {
			setEste(h);
		}
		if (d.equals("e")) {
			setOeste(h);
		}

	}

	@Override
	public String toString() {
		return "Habitacion [nombre=" + nombre + ", norte=" + norte + ", sur=" + sur + ", este=" + este + ", oeste="
				+ oeste + ", entrada=" + entrada + ", salida=" + salida + ", dragon=" + dragon + ", oro=" + oro + "]";
	}

}
