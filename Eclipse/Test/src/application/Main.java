package application;
 
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);

        stage.setTitle("Number base converter !");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }

    public static void main(String[] args) {
    	
  
        launch();
    }
}
