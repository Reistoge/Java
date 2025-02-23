package application;



import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Controller {

//	@FXML
//	private Circle myCircle;
	
	Mapa m;
	
	@FXML
	private Label textMap;
	@FXML
	private Button botonMapa;
	@FXML
	private Button moverMapacheBoton;
	@FXML
	private TextField moverMapacheField;
	@FXML
	private Button alimentarMapacheBoton;
	@FXML
	private TextField alimentarMapacheField;
	@FXML
	private Button infoMapacheBoton;
	@FXML
	private TextField infoMapacheField;
	@FXML
	private Button rendirseBoton;
	


	@FXML
	public void initialize() {
		
		 botonMapa.setStyle("-fx-background-color: F1E5D1;");
		
	}
//	@FXML
//	private double x;
//	private double y;

//	// class for the controllers
//	public void up( ActionEvent e) {
//		System.out.println("up");
//		
//		myCircle.setCenterY(y-=10);
//		
//	}
//	public void down(ActionEvent e) {
//		System.out.println("down");
//		myCircle.setCenterY(y+=10);
//			
//	}
//	public void left( ActionEvent e) {
//		System.out.println("left");
//		myCircle.setCenterX(x-=10);
//		
//	}
//	public void right(ActionEvent e) {
//		System.out.println("right");
//		myCircle.setCenterX(x+=10);
//		
//			
//	}
	public void close(ActionEvent e) {
		Platform.exit();
	}

//	public void move(MouseEvent e) {
//		
//			myCircle.setLayoutX(e.getSceneX());
//			myCircle.setLayoutY(e.getSceneY());
//				
// 
//		
//	}
//	public void resetPos(MouseEvent e) {
//		myCircle.setCenterX(0);
//		myCircle.setCenterY(0);
//		
//	}
	public void showMapa(ActionEvent e) {

		try {
			Button[] botones= { moverMapacheBoton,alimentarMapacheBoton,infoMapacheBoton,rendirseBoton};
			TextField[] fields= {moverMapacheField,alimentarMapacheField,infoMapacheField};
			 for(Button b: botones) {
				 b.setVisible(true);
				 b.setDisable(false);
				 b.setStyle("-fx-background-color: F1E5D1;");
			 }
			 for(TextField t: fields) {
				 
				 t.setStyle("-fx-background-color: #BB9981;");
				 
				 // code for just accept numbers
				 t.textProperty().addListener(new ChangeListener<String>() {
					    @Override
					    public void changed(ObservableValue<? extends String> observable, String oldValue, 
					        String newValue) {
					        if (!newValue.matches("\\d*")) {
					            t.setText(newValue.replaceAll("[^\\d]", ""));
					        }
					    }
					});
			 }
			m = new Mapa();
			textMap.setText(m.mapaToString());
			botonMapa.setText("re-Start");
			

		} catch (Exception exception) {
			// TODO: handle exception
			System.out.println("no se ha encontrado el archivo del mapa");
		}

	}
	public void moverMapache(ActionEvent e) {
		
		moverMapacheField.setDisable(false);
		moverMapacheField.setVisible(true);
		
		
		
		
	}
	
	public void alimentarMapache(ActionEvent e) {
		alimentarMapacheField.setDisable(false);
		alimentarMapacheField.setVisible(true);
	}
	public void infoMapache(ActionEvent e) {
		infoMapacheField.setDisable(false);
		infoMapacheField.setVisible(true);
	}
	public void rendirse(ActionEvent e) {
		
	}
	public void presionoEnterMover(KeyEvent e) {
		if(e.getCode() == KeyCode.ENTER) {
				
		}
	}
	public void presionoEnterInfo(KeyEvent e) {
		if(e.getCode() == KeyCode.ENTER) {
			
		}
	}
	public void presionoEnterAlimentar(KeyEvent e) {
		if(e.getCode() == KeyCode.ENTER) {
				
		}
	}
	 
	

}
