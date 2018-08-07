package resources;

import objects.List;
import objects.Movie;
import parser.MovieParser;

import java.sql.*;
import java.util.ArrayList;

public class MySQLManager implements IObservableLists {


    private final String URL = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9250882?serverTimezone=UTC";  // jdbc:subprotocol:subname
    private final String USER = "sql9250882";
    private final String PASSWORD = "az2htT8htN";
    private int totalListCount = 0;

    private static Connection connection;

    public MySQLManager() {
        try {
            startConnection();
        } catch (SQLException ignore) {
            ignore.printStackTrace();
        }
    }

    private void startConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connection successful");
    }

    public void closeConnection() {
        try {
            if (!connection.isClosed())
                connection.close();
        } catch (SQLException ignore) {

        }
    }

    private void getAllMovieLists() throws SQLException {

    }

    public void addMoviesFromList(ArrayList<Movie> movies) throws SQLException {
        String query = "INSERT INTO movie_list_1 (MovieDB_ID) VALUES(?)";

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement(query);
        connection.setAutoCommit(false);

        for (int i = 0; i < movies.size(); i++) {
            preparedStatement.setInt(1, movies.get(i).getDatabaseID());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.setAutoCommit(true);

    }

    public void createMoviesFromList(ArrayList<Movie> movies, String listName, String authorName) {
        try {
            String queryTable = "CREATE TABLE movie_list_" + totalListCount + " (MovieDB_ID INT);";
            String queryFields = "INSERT INTO movie_list_" + totalListCount + " (MovieDB_ID) VALUES(?);";

            PreparedStatement preparedStatement = connection.prepareStatement(queryTable);
            connection.setAutoCommit(false);
            for (int i = 0; i < movies.size(); i++) {
                preparedStatement.setInt(i, movies.get(i).getDatabaseID());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.setAutoCommit(true);

        } catch (SQLException ignored) {

        }
    }

    public static void getMoviesFromList(int listID) {
        Statement statement = null;
        String query = "SELECT * FROM movie_list_" + (listID + 1);

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int MOVIEDB_ID;
            while (resultSet.next()) {
                MOVIEDB_ID = resultSet.getInt("MOVIEDB_ID");
                new MovieParser(MOVIEDB_ID);
            }
        } catch (SQLException ignore) {
        }
    }

    public void getListsFromList() {
        Statement statement;
        String query = "SELECT * FROM movie_lists;";

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int listID;
            String listName;
            String listAuthor;
            while (resultSet.next()) {
                listID = resultSet.getInt("ID");
                listName = resultSet.getString("ListName");
                listAuthor = resultSet.getString("ListAuthor");
                IObservableLists.addListToObservableList(new List(listID, listName, listAuthor));
                totalListCount++;
            }
        } catch (SQLException ignore) {
            ignore.printStackTrace();

        }
    }

}
