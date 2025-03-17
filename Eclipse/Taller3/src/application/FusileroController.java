package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Logica.Actividad;
import Logica.ActividadComponent;
import Logica.Sede;
import Logica.ColorDecorator;
import Logica.Fusilero;
import Logica.SistemaImp;
import Logica.Soldado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;

public class FusileroController extends SoldadoController {
	// por alguna razon hay problemas con el UI pero esta funcionando todo bien
	Fusilero f;
	Sede cedeFusilero;
	@FXML
	Label nombre;
	@FXML
	Label rut;
	@FXML
	Label arma;
	@FXML
	Label pesoArma;
	@FXML
	Label cede;

	@FXML
	Label rangoSoldado;
	@FXML
	Label topRango;
	@FXML
	Spinner<Integer> rangoSpinner;

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

		if (!nombre.strip().equalsIgnoreCase("")) {
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
		// cargamos la info
		f = (Fusilero) SistemaImp.getInstance().getLoggedSoldado();
		cedeFusilero = SistemaImp.getInstance().getCede(f.getCede());
		nombre.setText(f.getNombre());
		rut.setText(f.getRut());
		arma.setText(f.getArma());
		pesoArma.setText(f.getPesoArma());
		cede.setText(f.getCede());
		rangoSoldado.setText(f.getClase());
		topRango.setText(mayorRangoFusilero() - Integer.parseInt(f.getClase()) + "");
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999);
		valueFactory.setValue(Integer.parseInt(f.getClase()));
		rangoSpinner.setValueFactory(valueFactory);

		// CARGAMOS LAS ACTIVIDADES
		factoryActividad = new ActividadPaneFactory();
		priorityBox.getItems().addAll(SistemaImp.getInstance().getActividadColores());
		priorityBox.setValue("Ninguna");
		Soldado user = SistemaImp.getInstance().getLoggedSoldado();
		String infoEntrenar = user.getEntrenamiento().getDatos();
		TitledPane entrenarPane = factoryActividad.crearActividad(infoEntrenar);
		agregarAccordion(entrenarPane);

	}

	public void eliminarActividad() {
		int index = SistemaImp.getInstance().getLoggedSoldado().getActividades().size();
		if (index != 1) {
			actividadesAccordion.getPanes().remove(index - 1);
			SistemaImp.getInstance().getLoggedSoldado().getActividades().remove(index - 1);

		}

	}

	public void agregarAccordion(TitledPane e) {

		actividadesAccordion.getPanes().add(e);
	}

	public void volverMenu(ActionEvent e) throws IOException {
		super.guardarArchivos();
		super.homeButton(e);
	}

	private int mayorRangoFusilero() {
		int mayor = 0;
		for (Soldado s : cedeFusilero.getSoldados()) {
			if (s instanceof Fusilero) {
				Fusilero f = (Fusilero) s;
				if (Integer.parseInt(f.getClase()) >= mayor) {
					mayor = Integer.parseInt(f.getClase());
				}

			}

		}
		return mayor;

	}

	public void actualizarRango() {
		// seteamos la clase a un nuevo valor
		f.setClase(rangoSpinner.getValue() + "");
		// UI
		rangoSoldado.setText(f.getClase());
		// calculamos de nuevo la diferencia.
		int diferencia = mayorRangoFusilero() - Integer.parseInt(f.getClase());
		topRango.setText(diferencia + "");
		if (diferencia == 0) {
			// aqui podria aplicarse observer.
			topRango.setText("Es el mayor.\nDiferencia 0");
			new Alert(AlertType.INFORMATION, "El fusilero " + f.getNombre() + " es ahora con el mayor rango")
					.showAndWait();
		}

	}
	
	public void guardarCambios() {
		
	}

}
