package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Logica.Sede;
import Logica.SistemaImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class LoginController extends MainController implements Initializable {

	@FXML
	private Button loginButton;
	@FXML
	private Button inscribirseButton;
	@FXML
	private Button sedesButton;
	@FXML
	private TextField sedeField;
	@FXML
	private TextField userField;
	@FXML
	private PasswordField passField;
	@FXML
	private AnchorPane newSoldadoPane;
	@FXML
	private AnchorPane loginPane;
	
	@FXML
	private TextArea mejorEntrenado;
	@FXML 
	private TextArea masCorrieron;

	public void goToSedes(ActionEvent event) throws IOException {
		Sede s=SistemaImp.getInstance().getCede(sedeField.getText());
		if(s!=null) {
			System.out.println("se ha encontrado la sede");
			SistemaImp.getInstance().setLoggedSede(s);
			super.goToSedes(event);
		}
		System.out.println("no se ha encontrado sede");

	}

	public void goToUsuario(ActionEvent event) throws IOException {
		// se verifica si el usario existe
		if (SistemaImp.getInstance().verifyUser(userField.getText(), passField.getText())) {
			super.goToUser(event, SistemaImp.getInstance().getLoggedSoldado().getTipo());

		}

	}

	public void goToInscribirse(ActionEvent event) throws IOException {
		newSoldadoPane.setDisable(false);
		newSoldadoPane.setVisible(true);
		loginPane.setVisible(false);
		loginPane.setDisable(true);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mejorEntrenado.setText(SistemaImp.getInstance().getMejorEntrenado() );
		masCorrieron.setText(SistemaImp.getInstance().getMasCorrieron() );
	}

}
