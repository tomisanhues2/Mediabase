package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import resources.IConstant;
import resources.IObservableLists;

public class MovieListController implements IConstant, IObservableLists {

    @FXML
    private TableColumn listTableID;
    @FXML
    private TableColumn listTableTitle;
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
    private TableView movieTable;

    @FXML
    public void searchMovieButton(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        listTableID.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableYear.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableGenre.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableActors.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableRatings.setCellFactory(TextFieldTableCell.forTableColumn());
        movieTable.setItems(moviesObservableList);
//        listTablePoster.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void addMoviesToTable() {

    }



}
