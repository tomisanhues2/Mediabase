package parser;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import objects.Movie;
import org.json.JSONArray;
import org.json.JSONObject;
import resources.IMovie;

public class MovieParser extends Movie implements IMovie {

    private int movieID;


    public MovieParser(int movieID) {
        super(movieID);
        this.movieID = movieID;
        try {
            getDetailsFromWeb();
            getCreditsFromWeb();
            getImagesFromWebURL();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }


    private void getDetailsFromWeb() throws UnirestException {
        HttpResponse<String> detailsResponse = Unirest.get(IMovie.GET_DETAILS_URL_FROM_WEB(movieID)).asString();
        JSONObject detailsJSON = new JSONObject(detailsResponse.getBody());
        setID(getTotalMovieID());
        setTitle(detailsJSON.getString("title"));
        setYear(detailsJSON.getString("release_date"));
        setGenres(detailsJSON.getJSONArray("genres").getJSONObject(0).getString("name"));
        setScore(detailsJSON.getString("vote_average"));

    }

    private void getCreditsFromWeb() throws UnirestException {
        HttpResponse<String> creditsResponse = Unirest.get(IMovie.GET_CREDITS_URL_FROM_WEB(movieID)).asString();
        JSONObject creditsJSON = new JSONObject(creditsResponse.getBody());
        JSONArray actorsArray = creditsJSON.getJSONArray("cast");
        String actorsString = "";
        for (int i = 0; i < 3; i++) {
            actorsString += actorsArray.getJSONObject(i).getString("name") + ", ";
        }
        setActors(actorsString);
    }

    private void getImagesFromWebURL() throws UnirestException{
        HttpResponse<String> imagesResponse = Unirest.get(IMovie.GET_IMAGES_URL_FROM_WEB(movieID)).asString();
        JSONObject imagesJSON = new JSONObject(imagesResponse.getBody());
        JSONArray imagesArray = imagesJSON.getJSONArray("posters");
        setImageURL(imagesArray.getJSONObject(0).getString("file_path"));
    }
}