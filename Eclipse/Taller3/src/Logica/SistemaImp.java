package Logica;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javafx.stage.Stage;

public class SistemaImp implements ISistema {

	private static SistemaImp instance;
	private TxtManager txtManager;

	ArrayList<Soldado> soldados;
	ArrayList<Sede> cedes;
	Soldado loggedSoldado;
	Sede loggedSede;

	String[] colores = new String[3];

	private SistemaImp() {
		soldados = new ArrayList<Soldado>();
		 
		cedes = new ArrayList<Sede>();
		loggedSoldado = null;
		loggedSede = null;

		colores[0] = "Alta";
		colores[1] = "Media";
		colores[2] = "Baja";

	}

	public static SistemaImp getInstance() {

		if (instance == null) {
			instance = new SistemaImp();
		}
		return instance;
	}

	public static void setInstance(SistemaImp instance) {
		SistemaImp.instance = instance;
	}

	public boolean verifyUser(String user2, String pass2) {
			// leer archivo .
	//		try {
	//			leerArchivos();
	//
	//		} catch (FileNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
			System.out.println("intentando buscar usuario\nNombre: " + user2 + "\nContraseña: " + pass2);
			for (Soldado s : instance.soldados) {
				if (s.getNombre().equals(user2) && s.getContraseña().equals(pass2)) {
					// se verifica
					SistemaImp.instance.setLoggedSoldado(s);
					System.out.println("loggin con exito !");
					System.out.println(instance.getLoggedSoldado().toString());
					return true;
				}
			}
			System.out.println("contraseña o usuario incorrecto");
			return false;
	
		}

 

	public void leerArchivos() throws FileNotFoundException {
		// soldados= new ArrayList<Soldado>();
		// cedes = new ArrayList<Sede>();
		txtManager = new TxtManager();
		// leemos primero las brigadas.
		txtManager.leerBrigadas();
		// leemos despues los soldados.
		txtManager.leerSoldados();
		// txtManager.leerActividades();

	}

	public void guardarArchivos() {
		txtManager.notifySubscribers();
	}

	public ArrayList<Soldado> getSoldados() {
		return soldados;
	}

	public void setSoldados(ArrayList<Soldado> soldados) {
		this.soldados = soldados;
	}

	public List<Sede> getCedes() {
		return cedes;
	}

	public void setCedes(ArrayList<Sede> cedes) {
		this.cedes = cedes;
	}

	public Soldado getLoggedSoldado() {
		return loggedSoldado;
	}

	public void setLoggedSoldado(Soldado loggedSoldado) {
		this.loggedSoldado = loggedSoldado;
	}

	public String[] getActividadColores() {
		// TODO Auto-generated method stub
		return SistemaImp.instance.colores;
	}

	public void agregarActividad(ActividadComponent a) {
		loggedSoldado.actividades.add(a);	
	}

	public TxtManager getTxtManager() {
		return txtManager;
	}

	public void setTxtManager(TxtManager txtManager) {
		this.txtManager = txtManager;
	}

	public Sede getLoggedSede() {
		return loggedSede;
	}

	public void setLoggedSede(Sede loggedSede) {
		this.loggedSede = loggedSede;
	}

	public String[] getColores() {
		return colores;
	}

	public void setColores(String[] colores) {
		this.colores = colores;
	}

	public void agregarSoldado(Soldado s) {

		// añadir una funcion la cual redirija a la cede del soldado.
		Sede c = getCede(s.getCede());
		if (c != null) {
			// agregamos a la cede del soldado.
			c.soldados.add(s);

		}
		// agregamos a los datos.
		soldados.add(s);

	}

	public Sede getCede(String lugar) {
		for (Sede c : cedes) {
			if (c.getNombre().equalsIgnoreCase(lugar)) {
				return c;
			}
		}
		return null;
	}

	public String getMejorEntrenado() {
		Soldado mejorEntrenado = soldados.get(0);
		for(Soldado s : soldados) {
			if(s.getFactorEntrenamiento()>mejorEntrenado.getFactorEntrenamiento()) {
				mejorEntrenado=s;
			}
		}
		return mejorEntrenado.getNombre().toUpperCase() +" "+ mejorEntrenado.getRut()+" \n" + mejorEntrenado.getEntrenamiento().getDescripcion().strip() + "\n";

	}

	public String getMasCorrieron() {
		ArrayList<Soldado> masCorrieron =new ArrayList<Soldado>(soldados);
		String resp = "";
		for(int i =0; i<masCorrieron.size();i++) {
			for (int j = i+1; j < soldados.size(); j++) {
				if(masCorrieron.get(i).getFactorCorrer()<masCorrieron.get(j).getFactorCorrer()) {
					Soldado temps= masCorrieron.get(i);
					masCorrieron.set(i, masCorrieron.get(j));
					masCorrieron.set(j, temps);
				}
			}
		}
	 
		 
		
		for (int i = 0; i < 3; i++) {
			resp += masCorrieron.get(i).getNombre().toUpperCase() +" "+ masCorrieron.get(i).getRut()+ "\n" + masCorrieron.get(i).getEntrenamiento().getDescripcion() + "\n";
		}
		return resp;

	}
	 
 

	public void setMarinosDeEmbarcacion(Marino marino) {
		ArrayList<Soldado> soldados = getInstance().soldados;
		ArrayList<Marino> marinos = new ArrayList<Marino>();
		for (Soldado s : soldados) {
			if (s instanceof Marino) {
				Marino m = (Marino) s;
				if (marino.getEmbarcacion().equalsIgnoreCase(m.getEmbarcacion()) && !m.equals(marino)) {
					marino.getMarineros().add(m);

				}

			}
		}

	}

	public boolean promoverGrumete(String nombre, String rut, Marino user) {
		for (Marino m : user.getMarineros()) {
			if (m.getNombre().equalsIgnoreCase(nombre) && m.getRut().equalsIgnoreCase(rut)) {
				m.setPuestoEmbarcacion("Marinero");
				return true;
			}
		}
		return false;

	}

	public boolean descenderMarinero(String nombre, String rut, Marino user) {
		for (Marino m : user.getMarineros()) {
			if (m.getNombre().equalsIgnoreCase(nombre) && m.getRut().equalsIgnoreCase(rut)) {
				m.setPuestoEmbarcacion("Grumete");
				return true;
			}
		}
		return false;

	}

}
