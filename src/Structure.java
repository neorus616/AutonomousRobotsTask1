import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Structure {
    private byte[][] pixels;

    public Structure(File file) {
        try {
            BufferedImage newImage = ImageIO.read(file);
            pixels = new byte[newImage.getWidth()][];
            for (int x = 0; x < newImage.getWidth(); x++) {
                pixels[x] = new byte[newImage.getHeight()];

                for (int y = 0; y < newImage.getHeight(); y++)
                    pixels[x][y] = (newImage.getRGB(x, y) == 0) ? (byte) 0 : 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int readMap(int x, int y){
        return pixels[x][y];
    }
}
