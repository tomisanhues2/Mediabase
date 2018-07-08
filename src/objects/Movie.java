package objects;

import parser.MovieParser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

public class Movie extends MovieParser implements Serializable {

    protected String movieURL;

    protected BufferedImage movieThumbnail;
    protected String movieName;
    protected int movieYear;
    protected String genre;

    //PRIVATE ACTOR LIST
    protected double rating;
    protected String MPAA;

    public Movie() {

    }

    public Movie(String movieName) throws IOException {
        super(movieName);
    }

    public String getMovieURL() {
        return movieURL;
    }

    public BufferedImage getMovieThumbnail() {
        return movieThumbnail;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getMPAA() {
        return MPAA;
    }
}