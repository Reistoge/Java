package application;

 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Logica.Sede;
import Logica.SistemaImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SedesController extends MainController implements Initializable {
	Sede s;
	@FXML
	TextArea rankingFusileros;
	@FXML
	TextArea pilotosLabel;
	@FXML
	TextArea mayorPilotoLabel;
	@FXML
	TextArea infantesLabel;
	@FXML
	Label cuposRestantesLabel;
	@FXML
	TextArea soldadosLabel;
	@FXML
	Text cedeText;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		s=SistemaImp.getInstance().getLoggedSede();
		cedeText.setText("Cede: "+s.getNombre());
		rankingFusileros.setText(s.ordenarFusileros());
		pilotosLabel.setText(s.ordenarPilotos()[0]);
		mayorPilotoLabel.setText(s.ordenarPilotos()[1]);
		infantesLabel.setText(s.obtenerInfantes());
		cuposRestantesLabel.setText(s.obtenerCuposCede());
		soldadosLabel.setText(s.obtenerSoldados());
		
	}
	public void volverMenu(ActionEvent e) throws IOException {
		super.guardarArchivos();
		super.homeButton(e);
	}
	 

}
