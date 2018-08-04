package controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import objects.AddMovie;
import org.json.JSONArray;
import org.json.JSONObject;
import resources.IMovie;
import resources.IObservableLists;


public class addMovieController implements IObservableLists, IMovie {

    @FXML
    private ImageView addMovieImage;
    @FXML
    private Label addMovieDescription;
    @FXML
    private TableView movieTable;
    @FXML
    private TableColumn listTableTitle;
    @FXML
    private TableColumn listTableYear;
    @FXML
    private TableColumn listTableRatings;
    @FXML
    private Button searchNewMovie;
    @FXML
    private TextField newMovieInput;

    @FXML
    public void searchNewMovie(ActionEvent event) {
        if (!newMovieInput.getText().isEmpty()) {
            String movieSearchName = newMovieInput.getText();
            getMoviesFromSearch(movieSearchName);
        } else {
            newMovieInput.setText("Invalid Input, try again");
        }
    }

    @FXML
    public void initialize() {
        listTableTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableYear.setCellFactory(TextFieldTableCell.forTableColumn());
        listTableRatings.setCellFactory(TextFieldTableCell.forTableColumn());
        movieTable.setItems(IObservableLists.searchMoviesObservableList);
        movieTable.setRowFactory(tr -> {
            TableRow<ObservableList> oRow = new TableRow<>();
            oRow.setOnMouseClicked(event -> {
                int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();
                selectedMovie(selectedIndex);
            });
            return oRow;
        });
    }

    private void selectedMovie(int selectedIndex) {
        addMovieImage.setImage(searchMoviesObservableList.get(selectedIndex).getThumbnail());
        addMovieDescription.setText(searchMoviesObservableList.get(selectedIndex).getDescription());
    }


    public void addNewMovie(ActionEvent actionEvent) {

    }

    private void getMoviesFromSearch(String movieName) {
        try {
            HttpResponse<String> moviesResponse = Unirest.get(IMovie.GET_MOVIES_URL_FROM_SEARCH(movieName)).asString();
            JSONObject moviesJSON = new JSONObject(moviesResponse.getBody());
            JSONArray moviesArray = moviesJSON.getJSONArray("results");
            JSONObject jsonObject;
            for (int i = 0; i < moviesArray.length(); i++) {
                jsonObject = moviesArray.getJSONObject(i);
                IObservableLists.addMovieSearchToObservableList(new AddMovie(jsonObject.getString("title"),
                        jsonObject.getString("release_date"),
                        IMovie.GET_IMAGE_URL_FROM_OBJECT(IMovie.GET_JSON_IMAGE_FROM_OBJECT_URL(jsonObject)),
                        jsonObject.getNumber("vote_average") + "",
                        jsonObject.getString("overview")));
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
