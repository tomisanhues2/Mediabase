package resources;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import objects.AddMovie;
import objects.Movie;

public interface IObservableLists {

    ObservableList<Movie> moviesObservableList = FXCollections.observableArrayList();
    ObservableList<AddMovie> searchMoviesObservableList = FXCollections.observableArrayList();

    static void addMovieToObservableList(Movie movie) {
        moviesObservableList.add(movie);
    }
    static void addMovieSearchToObservableList(AddMovie movie) {
        searchMoviesObservableList.add(movie);
    }
}
