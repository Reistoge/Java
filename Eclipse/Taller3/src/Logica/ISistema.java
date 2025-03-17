package Logica;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface ISistema {
	public boolean verifyUser(String user2, String pass2);
	public void leerArchivos() throws FileNotFoundException;
	public void guardarArchivos();
	public ArrayList<Soldado> getSoldados();
	public void setSoldados(ArrayList<Soldado> soldados);
	public List<Sede> getCedes();
	public void setCedes(ArrayList<Sede> cedes);
	public Soldado getLoggedSoldado();
	public void setLoggedSoldado(Soldado loggedSoldado);
	public String[] getActividadColores();
	public void agregarActividad(ActividadComponent a);
	public TxtManager getTxtManager();
	public void setTxtManager(TxtManager txtManager);
	public Sede getLoggedSede();
	public void setLoggedSede(Sede loggedSede);
	public String[] getColores();
	public void setColores(String[] colores);
	public void agregarSoldado(Soldado s);
	public Sede getCede(String lugar);
	public String getMejorEntrenado();
	public String getMasCorrieron();
	public void setMarinosDeEmbarcacion(Marino marino);
	public boolean promoverGrumete(String nombre, String rut, Marino user);
	public boolean descenderMarinero(String nombre, String rut, Marino user);
	
	
}
	
