package resources;


import javafx.collections.ObservableList;
import objects.Movie;

public interface IMovie {


    String DATABASE_API_KEY = "?api_key=9ea34de517a4414366db6520cafda608";
    String DATABASE_URL_STRING = "https://api.themoviedb.org/3/movie/";
    String DATABASE_OPTIONAL_LANGUAGE = "&language=en-US";

    String DATABASE_IMAGE_URL_STRING = "https://image.tmdb.org/t/p/";

    String TEST_MOVIE_ID_STRING = "348350"; //remove me
    int TEST_MOVIE_ID_INT = 348350; //remove me


    static String GET_DETAILS_URL_FROM_WEB(int movieID) {
        return DATABASE_URL_STRING + movieID + DATABASE_API_KEY + DATABASE_OPTIONAL_LANGUAGE;
    }

    static String GET_CREDITS_URL_FROM_WEB(int movieID) {
        return DATABASE_URL_STRING + movieID + "/credits"+ DATABASE_API_KEY;
    }

    static String GET_IMAGES_URL_FROM_WEB(int movieID) {
        return DATABASE_URL_STRING + movieID + "/images"+ DATABASE_API_KEY;
    }


}
