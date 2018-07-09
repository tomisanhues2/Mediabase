package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import parser.MovieParser;

public class AddMovieController {

    @FXML
    Label movieName;

    @FXML
    ImageView movieImage;

    @FXML
    Label movieDesc;

    @FXML
    TextField movieSearchBox;

    @FXML
    public void searchMovieButton() {
        if (!movieSearchBox.getText().isEmpty() ) {
            String movieNameSearchFormat = movieSearchBox.getText().replace(' ', '+');
            MovieParser movieParser = new MovieParser(movieNameSearchFormat);
            movieName.setText(movieParser.getMovieName());
            movieImage.setImage(movieParser.getMovieThumbnail());
            movieDesc.setText(movieParser.getMoviePlot());
        }
    }
}
