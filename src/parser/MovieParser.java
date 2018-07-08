package parser;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.junit.Test;
import resources.IMovie;
import org.json.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MovieParser implements IMovie {

    private URL url;
    JSONObject movieJSON;

    public MovieParser() {

    }

    public MovieParser(String movieName) throws IOException {

        URL movieSearch = new URL(DATABASE_URL_STRING + "t=" + movieName + DATABASE_API_KEY);
        InputStream urlConnection = movieSearch.openStream();
        System.out.println(movieSearch);
        try (Scanner scanner = new Scanner(urlConnection)) {
            scanner.useDelimiter("\\a");
            String result = scanner.hasNext() ? scanner.next() : "";
            movieJSON = new JSONObject(result);
        }
        displayMovieThumbnail();  //Uncomment to run without IMDb

    }

    //NOT USING IMDb
    private void displayMovieThumbnail() throws IOException{
        BufferedImage bufferedImage;
            URL key = new URL(movieJSON.getString("Poster"));
            bufferedImage = ImageParser.getImageFromUrl(key);

            //TEST IMAGE CODE START//
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(new JLabel(new ImageIcon(bufferedImage)));
        frame.pack();
        frame.setVisible(true);
            //TEST IMAGE CODE END//
    }


}
