package Logica;

import java.util.ArrayList;
import java.util.List;

public class Sede {
	String nombre;
	int cantidadSoldados;
	String[] fuerzasArmadas;
	List<Soldado> soldados;

	public Sede(String nombre, int cantidadSoldados, String[] fuerzasArmadas) {
		this.nombre = nombre;
		this.cantidadSoldados = cantidadSoldados;
		this.fuerzasArmadas = fuerzasArmadas;
		soldados= new ArrayList<Soldado>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadSoldados() {
		return cantidadSoldados;
	}

	public List<Soldado> getSoldados() {
		return soldados;
	}

	public void setSoldados(List<Soldado> soldados) {
		this.soldados = soldados;
	}

	public void setCantidadSoldados(int cantidadSoldados) {
		this.cantidadSoldados = cantidadSoldados;
	}

	public String[] getFuerzasArmadas() {
		return fuerzasArmadas;
	}

	public void setFuerzasArmadas(String[] fuerzasArmadas) {
		this.fuerzasArmadas = fuerzasArmadas;
	}
	public String ordenarFusileros() {
		ArrayList<Fusilero> fusileros=new ArrayList<Fusilero>();
		String text="";
		for(Soldado f: soldados) {
			if(f instanceof Fusilero) {
				fusileros.add((Fusilero) f);
			}
		}
		if(!fusileros.isEmpty()) {
			for(int i =0; i<fusileros.size();i++) {
				for(int j=i+1;j<fusileros.size();j++) {
					if(Integer.parseInt(fusileros.get(i).getClase())<Integer.parseInt(fusileros.get(j).getClase())) {
						Fusilero tempF= fusileros.get(i);
						fusileros.set(i, fusileros.get(j));
						fusileros.set(j, tempF);
					}
				}
			}
			for(Fusilero f: fusileros) {
				text+="-"+f.getNombre()+","+f.getClase()+","+f.getRut()+"\n";
			}
			return text;
		}
		return "";

		
	}
	public String[] ordenarPilotos() {
		String[] resp= {"",""};
		String vuelaMasAlto="";
		ArrayList<Piloto> pilotos=new ArrayList<Piloto>();
		String text="";
		for(Soldado f: soldados) {
			if(f instanceof Piloto) {
				pilotos.add((Piloto) f);
			}
		}
		
		if(!pilotos.isEmpty()) {
			for(int i =0; i<pilotos.size();i++) {
				for(int j=i+1;j<pilotos.size();j++) {
					if(Integer.parseInt(pilotos.get(i).getAlturaVuelo())<Integer.parseInt(pilotos.get(j).getAlturaVuelo())) {
						Piloto tempF= pilotos.get(i);
						pilotos.set(i, pilotos.get(j));
						pilotos.set(j, tempF);
					}
				}
			}
			for(Piloto f: pilotos) {
				text+="-"+f.getNombre()+","+f.getLugarEspionaje()+","+f.getRut()+"\n";
			}
			Piloto masAlto=pilotos.get(0);
			vuelaMasAlto+=masAlto.getNombre()+","+masAlto.getLugarEspionaje()+","+masAlto.getRut()+","+masAlto.getAlturaVuelo();
			resp[0]=text;
			resp[1]=vuelaMasAlto;
			return resp;
		}
		return resp;
		
	}
	public String obtenerInfantes(){
		ArrayList<Infante> infantes=new ArrayList<Infante>();
		String text="";
		for(Soldado inf: soldados) {
			if(inf instanceof Infante) {
				infantes.add((Infante) inf);
			}
		}
		if(!infantes.isEmpty()) {
			for(Infante inf : infantes) {
				text+="-"+inf.getNombre()+","+inf.getLugarQueVigila()+","+inf.getRol()+"\n";
			}
			return text;
			
		}
		return "";
		
	}
	public String obtenerCuposCede() {
		return (this.cantidadSoldados-this.soldados.size())+"";
		
	}
	public String obtenerSoldados() {
		String text="";
		if(!soldados.isEmpty()) {
			for(Soldado s: soldados) {
				text+="-"+s.getNombre()+","+s.getRut()+","+s.getContraseña()+","+s.getTipo()+"\n";
			}
			
		}
		return text;
	}
	
	
	

}
