import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessing1
{
    public static void main(String[] args) throws IOException {
        BufferedImage img = null;
        File f = null;
        try
        {
            f = new File("/Users/***/Desktop/in.jpg");
            img = ImageIO.read(f);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        try
        {
            f = new File("/Users/***/Desktop/out.jpg");
            ImageIO.write(img, "jpg", f);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }



    }
}
