
import java.awt.Color;



public class Filters {
    
  

    // Constructor with filename for source image
    Filters() {
       
    }

    // Grayscale filter works bya averaging every pixel red, green and blue values.
    public Color[][] GrayScaleFilter(Color[][] tmp)  {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();
                // takes average of color values
                int grayNum = (r + g + b) / 3;
                // outputs average into picuture to make grayscale
                tmp[i][j] = new Color(grayNum, grayNum, grayNum);

            }
        }
        return tmp;
    }

   


    public Color[][] BrighterFilter( Color[][] tmp, int value)  {

        // Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {

                // fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

                // takes average of color values
                int bright = value;
                if (r + bright > 255)
                    r = 255;
                else
                    r = r + bright;
                if (g + bright > 255)
                    g = 255;
                else
                    g = g + bright;
                if (b + bright > 255)
                    b = 255;
                else
                    b = b + bright;
                tmp[i][j] = new Color(r, g, b);

            }
        }
        return tmp;
    }


}
