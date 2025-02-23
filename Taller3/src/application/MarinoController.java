package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Logica.Actividad;
import Logica.ActividadComponent;
import Logica.ColorDecorator;
import Logica.Fusilero;
import Logica.Marino;
import Logica.SistemaImp;
import Logica.Soldado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;

public class MarinoController extends SoldadoController{
	// info:
	@FXML
	Label nombre;
	@FXML
	Label rut;
	@FXML
	Label cede;
	@FXML
	Label embarcacion;
	@FXML
	Label puestoEmbarcacion;
	
	
	
	
	
	// capitan controller
	Soldado user;
	@FXML
	Tab menuCapitanTab;
	@FXML
	Label grumetesMarinerosLabel;
	@FXML
	TextField promoverPuestoNombreField;
	@FXML
	TextField promoverPuestoRutField;
	@FXML
	TextField descenderPuestoNombreField;
	@FXML
	TextField descenderPuestoRutField;
	
	// info
	 
	 
	
	// Actividades 
	ActividadPaneFactory factoryActividad;
	@FXML
	TextField nombreActividad;
	@FXML
	TextField descripcionActividad;
	@FXML
	ChoiceBox<String> priorityBox;
	@FXML
	Button agregarActivadadBoton;

	@FXML
	Accordion actividadesAccordion;
	// actividades 

	public void agregarActividad(ActionEvent e) {

		// obtenemos datos del usuario
		String nombre = nombreActividad.getText();
		;
		String descripcion = descripcionActividad.getText();
		;
		String color;

		try {

			color = priorityBox.getValue().split(":")[0];

		} catch (Exception e2) {
			// en caso de que ocurra un error el color sera blanco (por defecto)
			color = "blanco";
		}

		if (descripcion == null) {
			// si no tiene descripcion igualmente
			descripcion = "no hay descripcion";
		}

		if (!nombre.strip().equalsIgnoreCase("") ) {
			// creamos una nueva actividad
			ActividadComponent a = new Actividad(nombre, descripcion);
			// agregamos el componente de color (decorator)
			ActividadComponent aConColor = new ColorDecorator(a, color);

			// agregamos la actividad al usuario logeado.
			SistemaImp.getInstance().agregarActividad(aConColor);
			TitledPane actividadPaneUI = factoryActividad.crearActividad(aConColor.getDatos());
			// mostramos los datos a consola.
			System.out.println(aConColor.getDatos());
			actividadPaneUI.setStyle("-fx-color:" + factoryActividad.colorFormatter(color));
			agregarAccordion(actividadPaneUI);

		} else {

			System.out.println("actividad debe tener nombre !!!");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		user = SistemaImp.getInstance().getLoggedSoldado();
		
		cargarMenuCapitan();
		cargarInfo(); 
		 
		
		// cargamos las actividades
		factoryActividad = new ActividadPaneFactory();
		priorityBox.getItems().addAll(SistemaImp.getInstance().getActividadColores());
		priorityBox.setValue("Ninguna");
		String infoEntrenar = user.getEntrenamiento().getDatos();
		TitledPane entrenarPane = factoryActividad.crearActividad(infoEntrenar);
		agregarAccordion(entrenarPane);
 		 
	}

	public void eliminarActividad() {
		int index=SistemaImp.getInstance().getLoggedSoldado().getActividades().size();
		if(index!=1) {
			actividadesAccordion.getPanes().remove(index-1);
			SistemaImp.getInstance().getLoggedSoldado().getActividades().remove(index-1);
			
		}
 
 		 
	}

	public void agregarAccordion(TitledPane e) {

		actividadesAccordion.getPanes().add(e);
	}
	public void volverMenu(ActionEvent e) throws IOException {
		super.guardarArchivos();
		super.homeButton(e);
	}
	public void cargarMenuCapitan() {
		// esta funcion se encarga de mostrar al usuario el menu capitan.
		Marino marino = (Marino) user;
		if(marino.getPuestoEmbarcacion().equalsIgnoreCase("capitan")) {
			menuCapitanTab.setDisable(false);
			String txt = "";
			for(Marino mar : marino.getMarineros()) {
				txt+=mar.getNombre()+" "+mar.getRut()+" "+mar.getPuestoEmbarcacion()+"\n"; 
			}
			grumetesMarinerosLabel.setText(txt);
			
		}
	}
	public void ascenderGrumete() {
		Marino capitan = (Marino) user;
		String nombre= promoverPuestoNombreField.getText().strip();
		String rut= promoverPuestoRutField.getText().strip();
		if(SistemaImp.getInstance().promoverGrumete(nombre,rut,capitan)) {
			System.out.println("cambio con exito!!");
		}
		else {
			System.out.println("no se encontro al grumete");
		}
		cargarMenuCapitan();
		
	}
	public void descenderMarinero() {
		Marino capitan = (Marino) user;
		String nombre= descenderPuestoNombreField.getText().strip();
		String rut= descenderPuestoRutField.getText().strip();
		if(SistemaImp.getInstance().descenderMarinero(nombre,rut,capitan)) {
			System.out.println("cambio con exito!!");
		}
		else {
			System.out.println("no se encontro al marinero");
		}
		cargarMenuCapitan();
		
	}
	public void cargarInfo() {
		Marino m = (Marino) user;
		nombre.setText(m.getNombre());
		rut.setText(m.getRut());
		cede.setText(m.getCede());
		embarcacion.setText(m.getEmbarcacion());
		puestoEmbarcacion.setText(m.getPuestoEmbarcacion());
	}
	public void guardarCambios() {
		super.guardarArchivos();
	}
	 
	
	
	
	
}
