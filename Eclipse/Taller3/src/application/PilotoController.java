package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Logica.Actividad;
import Logica.ActividadComponent;
import Logica.ColorDecorator;
import Logica.Marino;
import Logica.Piloto;
import Logica.SistemaImp;
import Logica.Soldado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

public class PilotoController extends SoldadoController{
	Soldado user;
	@FXML
	Label nombre;
	@FXML
	Label cede;
	@FXML
	Label rut;
	@FXML
	Label lugarDondeEspia;
	@FXML
	Label tipoNave;
	@FXML
	Label alturaVuelo;
	
	
	@FXML
	TextField nuevoLugarField;
	 
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
	public void cambiarLugarEspionaje() {
		Piloto p=(Piloto) user;
		String field=nuevoLugarField.getText().strip();
		if(field!="") {
			p.setLugarEspionaje(field);
			lugarDondeEspia.setText(field);
		}
	}

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
		
		user=SistemaImp.getInstance().getLoggedSoldado();
		cargarInfo();
		factoryActividad = new ActividadPaneFactory();
		priorityBox.getItems().addAll(SistemaImp.getInstance().getActividadColores());
		priorityBox.setValue("Ninguna");
		Soldado user = SistemaImp.getInstance().getLoggedSoldado();
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
	public void cargarInfo() {
		Piloto p = (Piloto) user;
		nombre.setText(p.getNombre());
		rut.setText(p.getRut());
		cede.setText(p.getCede());
		alturaVuelo.setText(p.getAlturaVuelo());
		lugarDondeEspia.setText(p.getLugarEspionaje());
	}
	public void agregarAccordion(TitledPane e) {

		actividadesAccordion.getPanes().add(e);
	}
	public void volverMenu(ActionEvent e) throws IOException {
		super.guardarArchivos();
		super.homeButton(e);
	}
	public void guardarCambios() {
		super.guardarArchivos();
	}
}
