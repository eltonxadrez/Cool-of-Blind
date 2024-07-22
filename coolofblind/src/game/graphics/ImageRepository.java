package game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public final class ImageRepository {

    //teste
    public static final String IMG_ISO_GRASS_01 = "/images/iso_grass_01.png";
    public static final String IMG_RECT_GRASS_01 = "/images/rect_grass_01.png";
    public static final String IMG_RECT_GREEN_01 = "/images/rect_green_01.png";

    public BufferedImage getImageRepo (String imageLocation){
        try {
            InputStream file = getClass().getResourceAsStream(imageLocation);
            if(file != null){
                return ImageIO.read(file);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
