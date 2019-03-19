import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Converter {
  public static void convert(String filename, String fileout) {
    BufferedImage bimg;
    try {
      bimg = ImageIO.read(new File(filename));
    }
    catch (Exception e) {
      System.err.println("Error opening file " + filename + ": " + e);
      return;
    }
    
    int idx = 3;
    int[] imgdata = new int[bimg.getHeight()*bimg.getWidth()+3];
    imgdata[0] = 55;
    imgdata[1] = bimg.getWidth();
    imgdata[2] = bimg.getHeight();
    for (int y = 0;  y < bimg.getHeight();  y++) {
      for (int x = 0;  x < bimg.getWidth();  x++) {
        int pix = bimg.getRGB(x,y);
        int val = (pix & 0xFF) + ((pix >> 8) & 0xFF) + ((pix >> 16) & 0xFF);
        val = val * 4 / 3;
        if (val > 999) val = 999;
        imgdata[idx++] = val;
      }
    }
 
    try {
        FileOutputStream fout = null;
        PrintWriter out = null;
        if (fileout != null) {
          fout = new FileOutputStream(fileout);
          out = new PrintWriter(fout);
        }
        else {
          out = new PrintWriter(System.out);
        }
    
        for (int i = 0;  i < imgdata.length; i++) {
           out.println(imgdata[i]);
        }
    
        out.flush();
        if (fileout != null) fout.close();
    }
    catch (Exception e) {
      System.err.println("Error writing to output file "+fileout+": "+e);
      return;
    }

  }
}