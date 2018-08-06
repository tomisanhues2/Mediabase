package objects;

import javafx.scene.image.Image;

public class AddMovie {

    private String title;
    private String year;
    private String rating;
    private Image thumbnail;
    private String description;

    public AddMovie(String title, String year, Image thumbnail, String rating, String description) {
        this.title = title;
        this.year = year;
        this.thumbnail = thumbnail;
        this.rating = rating;
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.toCharArray().length > 290) {
            this.description = description.substring(0,290) + "...";
        } else {
            this.description = description;
        }
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

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
