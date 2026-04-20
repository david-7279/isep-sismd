import java.io.IOException;
import java.awt.Color;

public class ApplyFilters {
 
    private static final int NFILES = 5;
    public static void main(String[] args) throws IOException {

        Filters filters = new Filters();
        for (int i = 1; i < NFILES+1; i++) {
            Color image1[][] = Utils.loadImage(String.valueOf(i)+".jpg");
            Color image2[][] = filters.GrayScaleFilter(image1);
            Color image3[][] = filters.BrighterFilter(image2,128);
            Utils.writeImage(image3, String.valueOf(i)+"_processed.jpg");
        } 
  
    }

}
