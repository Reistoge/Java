package IntentoPrueba1;

import java.util.Arrays;

public class Persona {
	String nombre;
	Rol[] roles;
	String rut;
	public Persona(String r, String n) {
			roles=new Rol[0];
			nombre=n;
			rut=r;
	}
	public void agregarRol(Rol r) {
		for(Rol ROL : this.roles) {
			if(ROL.equals(r)) {
				
			}
		}
		
		
		Rol[] nuevaR= new Rol[this.roles.length+1];
		for(int i=0;i<this.roles.length;i++) {
			nuevaR[i]=this.roles[i];
			
		}
		nuevaR[this.roles.length]=r;
		this.roles=nuevaR;
	}
	
	public void eliminarRol(Rol r) {
		Rol[] nuevaR= new Rol[this.roles.length+1];
		for(int i=0;i<this.roles.length;i++) {
			nuevaR[i]=this.roles[i];
			
		}
		nuevaR[this.roles.length]=r;
		this.roles=nuevaR;
	}
	public boolean isRol(String r) {
		for (Rol ROL : this.roles) {
			if(ROL.nombre.toLowerCase().equals(r)) {
				return true;
			}
		}
		return false;
	}
	public void ordenarRoles() {
		
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Rol[] getRoles() {
		return roles;
	}
	public void setRoles(Rol[] roles) {
		this.roles = roles;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int cantRoles(){
		return roles.length;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", roles=" + Arrays.toString(roles) + ", rut=" + rut + "]";
	}
	
	
}
