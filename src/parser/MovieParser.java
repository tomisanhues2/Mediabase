package parser;

import javafx.scene.image.Image;
import org.json.JSONObject;
import resources.IMovie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class MovieParser implements IMovie {

    private URL url;
    JSONObject movieJSON;

    public MovieParser() {

    }

    public MovieParser(String movieName) {

        try {
            URL movieSearch = new URL(DATABASE_URL_STRING + "t=" + movieName + DATABASE_API_KEY);
            InputStream urlConnection = movieSearch.openStream();
            System.out.println(movieSearch);
            try (Scanner scanner = new Scanner(urlConnection)) {
                scanner.useDelimiter("\\a");
                String result = scanner.hasNext() ? scanner.next() : "";
                setMovieJSON(new JSONObject(result));
            }
            //displayMovieThumbnail();  //Uncomment to run without IMDb
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public JSONObject getMovieJSON() {
        return movieJSON;
    }

    public void setMovieJSON(JSONObject movieJSON) {
        if (movieJSON.getString("Response").equalsIgnoreCase("True")) {
            this.movieJSON = movieJSON;
        } else {
            System.exit(1);
        }
    }

    //NOT USING IMDb
    public Image getMovieThumbnail() {
        try {
            Image image;
            URL key = new URL(movieJSON.getString("Poster"));
            image = ImageParser.getImageFromUrl(key);
            return image;
            //TEST IMAGE CODE START//
/*        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(new JLabel(new ImageIcon(bufferedImage)));
        frame.pack();
        frame.setVisible(true);*/
            //TEST IMAGE CODE END//
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMoviePlot() {
        return movieJSON.getString("Plot");
    }

    public String getMovieName() {
        return movieJSON.getString("Title");
    }


}
