package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import objects.AddMovie;
import resources.IConstant;

import java.io.IOException;

public class StartPageController implements IConstant {


    public Button menuNewListButton;
    public Button menuViewListButton;
    public Label menuTitleString;

    Stage stage;

    public void menuButtonPressed(ActionEvent event) {

        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent newRoot = null;
        try {
            stage = (Stage) menuTitleString.getScene().getWindow();

            String buttonPressed = ((Button) event.getSource()).getId();

            switch (buttonPressed) {
                case "menuNewListButton":
                    newRoot = fxmlLoader.load(
                            getClass().getClassLoader().getResource(
                                    "views/AddMovie.fxml"), messages);
                    break;
                case "menuViewListButton":
                    newRoot = fxmlLoader.load(
                            getClass().getClassLoader().getResource(
                                    "views/MovieList.fxml"), messages);
                    break;
            }
            stage.setScene(new Scene(newRoot));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
