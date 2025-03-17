package application;
// Ferran Rojas Andreu 21.642668-1
// Maximo Sarno 21853202-0
// Vicente Melendez 21.661.220-5
import java.io.FileNotFoundException;
import java.util.List;

import Logica.Actividad;
import Logica.ActividadComponent;
import Logica.ColorDecorator;
import Logica.Marino;
import Logica.SistemaImp;
import Logica.Soldado;
import Logica.TxtManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {

		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root, 900, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(900);
			primaryStage.setMinHeight(600);
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		
		SistemaImp.getInstance().leerArchivos();
		
		//lector.leerSoldados();     
		 
		launch(args);

	}
}
