package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import resources.IConstant;


public class CreateListController implements IConstant {

    @FXML
    TextField listNameField;
    @FXML
    TextField authorNameField;

    public void initialize() {

    }

    final String ERROR_STYLE = "-fx-background-color: red";
    final String VALID_STYLE = "-fx-background-color: green";
    public void saveButton(ActionEvent event) {
        if (listNameField.getText().isEmpty() || authorNameField.getText().isEmpty()) {
            listNameField.setStyle(ERROR_STYLE);
            authorNameField.setStyle(ERROR_STYLE);
        } else {

        }
    }

}