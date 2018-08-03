package resources;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.Movie;

public interface IObservableLists {

    ObservableList<Movie> moviesObservableList = FXCollections.observableArrayList();

    static void addMovieToObservableList(Movie movie) {
        moviesObservableList.add(movie);
    }
}
