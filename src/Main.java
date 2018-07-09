import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Movie;
import resources.IConstant;

public class Main extends Application implements IConstant{

    public static void main(String[] args) {
        try {
//            Movie movie = new Movie("Star+trek"); //RUN ME <3
                launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mainMenu = new FXMLLoader();
        Parent root = mainMenu.load(
                getClass().getClassLoader().getResource("views/AddMovie.fxml"),
                messages);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Mediabase");
        stage.show();
    }
}
