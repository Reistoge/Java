package application;


import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    @FXML
    private Pane mainPane;
    @FXML
    private TextField inputTransformar;
    @FXML
    private TextField inputBaseInicial;
    @FXML
    private TextField inputBaseNueva;
    @FXML
    private TextField inputPrecision;
    @FXML
    private Button restablecerValoresButton;
    @FXML
    private TextField base2Field;
    @FXML
    private TextField base10Field;
    @FXML
    private TextField base8Field;
    @FXML
    private TextField base16Field;
    @FXML
    private TextField baseNField;

    private final ArrayList<TextField> inputs = new ArrayList<>();
    private final ArrayList<TextField> fieldsResult = new ArrayList<>();

    @FXML // this snippet basically enables the method tu being used in runtime
    public void initialize() {
        // we add the fields to the arrayList apply easy iteration.

        inputs.addAll(List.of(inputBaseInicial,inputBaseNueva,inputPrecision,inputTransformar));
        fieldsResult.addAll(List.of(base2Field,base10Field,base8Field,base16Field,baseNField));
        // we add the function that calculates and set the transformation results when a key is release on any field.
        for (TextField textField : inputs) {
            textField.setOnKeyReleased(event -> {calculateValues();});
        }
        //applyStartupAnimation(1.5f,1);
        applyStartupAnimation(2,2);


    }
    private void applyStartupAnimation(float fadeInDuration, float slideDuration) {
        // Fade-in effect
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(fadeInDuration), mainPane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Slide-in from the top effect
        TranslateTransition slideIn = new TranslateTransition(Duration.seconds(slideDuration), mainPane);
        slideIn.setFromY(-100); // Start from above
        slideIn.setToY(0);      // Move to original position

        // Play animations together
        fadeIn.play();
        slideIn.play();
    }

    @FXML
    public void calculateValues() {
        String valorTransformar = inputTransformar.getText();
        int valorBaseInicial = 0;
        int valorBaseNueva = 0;
        int valorPrecision = 0;

        try {
            if (!inputBaseInicial.getText().isEmpty()) {
                valorBaseInicial = Integer.parseInt(inputBaseInicial.getText());
            }
            if (!inputBaseNueva.getText().isEmpty()) {
                valorBaseNueva = Integer.parseInt(inputBaseNueva.getText());
            }
            if (!inputPrecision.getText().isEmpty()) {
                valorPrecision = Integer.parseInt(inputPrecision.getText());
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid or empty base input ");
            return; // Exit function to prevent invalid calculation
        }

        // Ensure values are valid before attempting conversion
        if (valorBaseInicial < 2 || valorBaseInicial > 35 || valorBaseNueva < 2 || valorBaseNueva > 35) {
            System.out.println("Error: Bases must be between 2 and 35");
            return;
        }
        // transformation
        base2Field.setText(BaseConversion.GeneralBaseConversion(valorTransformar, valorBaseInicial, 2, valorPrecision));
        base10Field.setText(BaseConversion.GeneralBaseConversion(valorTransformar, valorBaseInicial, 10, valorPrecision));
        base8Field.setText(BaseConversion.GeneralBaseConversion(valorTransformar, valorBaseInicial, 8, valorPrecision));
        base16Field.setText(BaseConversion.GeneralBaseConversion(valorTransformar, valorBaseInicial, 16, valorPrecision));
        baseNField.setText(BaseConversion.GeneralBaseConversion(valorTransformar, valorBaseInicial, valorBaseNueva, valorPrecision));
    }

    @FXML
    public void resetValues(ActionEvent actionEvent) {
        for (TextField textField : inputs) {
            textField.setText("");
        }
        for(TextField textField: fieldsResult) {
            textField.setText("");
        }
    }
}

