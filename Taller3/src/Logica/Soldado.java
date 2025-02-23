package Logica;

import java.util.ArrayList;
import java.util.List;

public abstract class Soldado implements Subscriber{

	String nombre, rut, contraseña, cede, tipo;
	float factorCorrer,factorEntrenamiento;
	List<ActividadComponent> actividades;
	
	

	public Soldado(String nombre, String rut, String contraseña, String cede, String tipo) {
		this.nombre = nombre;
		this.rut = rut;
		this.contraseña = contraseña;
		this.cede = cede;
		this.tipo = tipo;
		actividades = new ArrayList<ActividadComponent>();
		

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCede() {
		return cede;
	}

	public void setCede(String cede) {
		this.cede = cede;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ActividadComponent> getActividades() {
		return actividades;
	}

	public ActividadComponent getEntrenamiento() {
		return this.actividades.get(0);
	}

	public void setActividades(List<ActividadComponent> actividades) {
		this.actividades = actividades;
	}
	 

	@Override
	public String toString() {
		return "Soldado [nombre=" + nombre + ", rut=" + rut + ", contraseña=" + contraseña + ", cede=" + cede
				+ ", tipo=" + tipo + "]";
	}

	public float getFactorCorrer() {
		return factorCorrer;
	}

	public void setFactorCorrer(float factorCorrer) {
		this.factorCorrer = factorCorrer;
	}

	public float getFactorEntrenamiento() {
		return factorEntrenamiento;
	}

	public void setFactorEntrenamiento(float factorEntrenamiento) {
		this.factorEntrenamiento = factorEntrenamiento;
	}

 

}
