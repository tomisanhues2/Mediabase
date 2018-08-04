import objects.Movie;
import resources.MySQLManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class SQLTest {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie(181808));
        movies.add(new Movie(140607));
        movies.add(new Movie(181812));
        MySQLManager mySQLManager = new MySQLManager();
        try {
            mySQLManager.addMoviesFromList(movies);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
