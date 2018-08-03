import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Movie;
import resources.IConstant;
import resources.IMovie;

public class Main implements IConstant, IMovie {

    public static void main(String[] args) {
        Movie movie = new Movie(TEST_MOVIE_ID_INT);
    }

}
