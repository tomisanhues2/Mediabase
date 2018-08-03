package objects;

import javafx.scene.image.Image;
import parser.MovieParser;
import resources.IDManager;
import resources.IObservableLists;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

public class Movie extends IDManager implements Serializable, IObservableLists {

    private int databaseID;
    private int ID;
    private String title;
    private String year;
    private String genres;
    private String actors;
    private Image thumbnail;
    private String imageURL;

    public Movie(int databaseID) {
        this.databaseID =  databaseID;
        IObservableLists.addMovieToObservableList(this);
    }

    public Movie(String title, String year, String genres, String actors) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.actors = actors;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getDatabaseID() {
        return databaseID;
    }
}