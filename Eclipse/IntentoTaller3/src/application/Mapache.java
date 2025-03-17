package application;

public class Mapache {
	int rut;
	float gramos;
	String nombre;
	boolean vivo;
	int col;
	int fil;
	
	
	
	
	
	
	public Mapache(String rut, String nombre, String gramos) {
		 
		this.rut = Integer.parseInt(rut);
		this.gramos = Float.parseFloat(gramos);
		this.nombre = nombre;
		this.vivo = true;
		
	}
	public void alimentar() {
		this.setGramos(this.getGramos()*1.1f);
		System.out.println(this.getNombre()+" ahora tiene una masa de "+this.getGramos());
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public Float getGramos() {
		return gramos;
	}
	public void setGramos(float f) {
		this.gramos = f;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getFil() {
		return fil;
	}
	public void setFil(int fil) {
		this.fil = fil;
	}
	public String getInformacion() {
		return this.rut+"/"+this.nombre +" tiene una masa de "+this.gramos+"\r\n"
				+ "y vive en la celda "+this.getCol()+"x"+this.getFil();
	}
	
}
