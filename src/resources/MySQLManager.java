package resources;

import java.sql.*;
import java.util.Properties;

public class MySQLManager {


    private final String URL = "jdbc:mysql://10.16.8.187:3306/mediabase";  // jdbc:subprotocol:subname
    private final String USER = "mediabase";
    private final String PASSWORD = "mediabase";

    private Connection connection;

    public MySQLManager() {
        try {
            setConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setConnection() throws SQLException {
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
        System.out.println("Connection successful");
    }

    private void getAllMovieLists() throws SQLException {
         }

    public void getMoviesFromList() throws SQLException {
        Statement statement = null;
        String query = "SELECT * FROM movie_list_1;";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int MOVIEDB_ID = resultSet.getInt("MOVIEDB_ID");
                System.out.println(MOVIEDB_ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
