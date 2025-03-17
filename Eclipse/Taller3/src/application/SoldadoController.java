
package application;

import java.net.URL;
import java.util.ResourceBundle;

import Logica.ActividadComponent;
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;

public class SoldadoController extends MainController implements Initializable {
	// actividades

	public void agregarActividad(ActionEvent e) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}


}

class ActividadPaneFactory {

	public ActividadPaneFactory() {

	};

	public TitledPane crearActividad(String properties) {
		String[] datos = properties.split("\t");
		TitledPane tp = new TitledPane();
		Text tpText = new Text();
		String nombre = datos[0];
		String desc = datos[1];
		String color;
		try {
			color = datos[2];

		} catch (Exception e) {

			color = "blanco";

		}
		tp.setText(nombre);
		tpText.setText(desc);
		tp.setStyle("-fx: color" + colorFormatter(color.strip()));
		tp.setContent(tpText);

		return tp;

	}

	public String colorFormatter(String color) {
		if (color.equalsIgnoreCase("alta")) {
			return "#AA0000";
		} else if (color.equalsIgnoreCase("blanco")) {
			return "#ffffff";
		} else if (color.equalsIgnoreCase("media")) {
			return "#C4933E";
		} else if (color.equalsIgnoreCase("baja")) {
			return "#B7C95D";
		}
		return "#ffffff";

	}

}
