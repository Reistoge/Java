package Game;

import java.util.Scanner;

public class Equipo {
	Personaje[] personajes= new Personaje[3];
	boolean estado;
	public Equipo() {
		
		
		
	}
	public void MostrarEquipo() {
		Scanner control=new Scanner(System.in);
		for(Personaje p:personajes) {
			
			System.out.println(p.MostrarAtributos());
			System.out.println();
			System.out.println();
			control.nextLine();
			}
		 
	}
	public Personaje[] getEquipo() {
		return personajes;
	}
	public void setEquipo(Personaje[] equipo) {
		this.personajes = equipo;
		
	}
	public boolean isEstado() {
		for(Personaje p:personajes) {
			if(p.isVivo()) {
				return true;
			}
			 
		}
		return false;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setPersonaje(Personaje p,int pos) {
		personajes[pos]=p;
	}
	public void ganarExp() {
		for(Personaje p:personajes) {
			if(p.isVivo()) {
				p.setExp(p.getExp()+100);
			}
			 
		}
	}
	
	
	
}
