package parser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageParser {

    public static BufferedImage getImageFromUrl(URL url) throws IOException {
        BufferedImage image = ImageIO.read(url);
        System.out.println("success");
        return image;
    }

}
