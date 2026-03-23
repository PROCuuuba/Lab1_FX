package com.example.lab1_fx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {

    @FXML
    private TextField valueField;

    @FXML
    private ComboBox<String> fromCombo;

    @FXML
    private ComboBox<String> toCombo;

    @FXML
    private Label resultLabel;

    private ConverterModel model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        model = new ConverterModel();

        fromCombo.getItems().addAll(model.getUnits().keySet());
        toCombo.getItems().addAll(model.getUnits().keySet());

        fromCombo.getSelectionModel().selectFirst();
        toCombo.getSelectionModel().selectLast();
    }

    @FXML
    private void handleConvert() {

        try {
            String input = valueField.getText();

            if (input.isEmpty()) {
                throw new NumberFormatException();
            }

            double value = Double.parseDouble(input);

            String from = fromCombo.getValue();
            String to = toCombo.getValue();

            double result = model.convert(value, from, to);

            resultLabel.setText(String.format("Результат: %.2f", result));

        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: введите корректное число");
        } catch (IllegalArgumentException e) {
            resultLabel.setText("Ошибка единиц измерения");
        }
    }
}
