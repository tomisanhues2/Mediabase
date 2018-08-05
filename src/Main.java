import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Movie;
import parser.MovieParser;
import resources.IConstant;
import resources.IMovie;
import resources.IObservableLists;
import resources.MySQLManager;

import java.sql.SQLException;

public class Main extends Application implements IConstant, IMovie, IObservableLists {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader test = new FXMLLoader();
        Parent parent = test.load(getClass().getClassLoader().getResource("views/StartPage.fxml"),messages);
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mediabase");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



/*    public static void main(String[] args) {
        try {
            MySQLManager mySQLManager = new MySQLManager();
            mySQLManager.getMoviesFromList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


/*
*         FXMLLoader test = new FXMLLoader();
        Parent parent = test.load(getClass().getClassLoader().getResource("views/MovieList.fxml"),messages);

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mediabase");
        primaryStage.show();
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));
        IObservableLists.addMovieToObservableList(new Movie("TestMovieTitle","1292/12/12","Action, XXXX","Bruce lee"));

*
*
*
*
* */