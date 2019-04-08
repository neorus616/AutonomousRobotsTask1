import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Structure {
    private static byte[][] pixels;
    private int[] startingPoint = new int[2];

    public Structure(File file) {
        try {
            BufferedImage newImage = ImageIO.read(file);
            pixels = new byte[newImage.getWidth()][];
            for (int x = 0; x < newImage.getWidth(); x++) {
                pixels[x] = new byte[newImage.getHeight()];
                for (int y = 0; y < newImage.getHeight(); y++)
                    pixels[x][y] = ((byte)newImage.getRGB(x, y) == 0) ? 0 : (byte) 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return pixels.length;
    }

    public int getHeight() {
        return pixels[0].length;
    }

    private void setStartingPoint(int x, int y) {
        startingPoint[0] = x;
        startingPoint[1] = y;
    }

    public int[] getStartingPoint() {
        return startingPoint;
    }

    public static int readMap(int x, int y) {
        return pixels[x][y];
    }
}