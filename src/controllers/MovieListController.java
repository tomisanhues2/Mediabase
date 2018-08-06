package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import objects.Movie;
import resources.IConstant;
import resources.IObservableLists;

import java.io.IOException;

public class MovieListController implements IConstant, IObservableLists {

    @FXML
    private TableColumn listTableID;
    @FXML
    private TableColumn listTableTitle;
    @FXML
    private TableColumn listTableYear;
    @FXML
    private TableColumn listTableScore;
    @FXML
    private TableView movieTable;
    @FXML
    private Label nameListString;
    @FXML
    private Label authorListString;


    @FXML
    public void searchMovieButton(ActionEvent event) {

    }

    @FXML
    public void initialize() throws IOException {
        listTableID.setCellFactory(TextFieldTableCell.<Movie, Integer>forTableColumn(new IntegerStringConverter()));
        listTableTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableYear.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableScore.setCellFactory(TextFieldTableCell.forTableColumn());
        movieTable.setItems(moviesObservableList);
//        listTablePoster.setCellFactory(TextFieldTableCell.forTableColumn());

        if (nameListString.getText().equalsIgnoreCase("new") || authorListString.getText().equalsIgnoreCase("new")) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent parent = fxmlLoader.load(getClass().getClassLoader().getResource("views/CreateList.fxml"), messages);
            stage.setScene(new Scene(parent));

            stage.showAndWait();
        }
    }

    public void addMoviesToTable() {

    }

    public void setAuthorListString(String string) {
        authorListString.setText(string);
    }

    public void setNameListString(String string) {
        nameListString.setText(string);
    }




}
