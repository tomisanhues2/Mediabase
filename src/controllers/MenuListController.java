package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import resources.IConstant;

public class MenuListController implements IConstant {

    @FXML
    private TableColumn listTableID;
    @FXML
    private TableColumn listTableTile;
    @FXML
    private TableColumn listTableYear;
    @FXML
    private TableColumn listTableGenre;
    @FXML
    private TableColumn listTableActors;
    @FXML
    private TableColumn listTableRatings;
    @FXML
    private TableColumn listTablePoster;
    @FXML
    private Label listSearchTitle;
    @FXML
    private TextField listSearchBar;
    @FXML
    private Button listSearchButton;

    @FXML
    public void searchMovieButton(ActionEvent event) {

    }

}
