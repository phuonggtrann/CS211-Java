// this is an ImageViewer
public class TextImageViewer implements ImageViewer {
    // default constructor
    public TextImageViewer() {}

    // retreive text character corresponding to given pixel value
    private final char[] vals = {' ', ',', 'o', 'O', '@'};
    public char getChar(int i) {
        return vals[(int)( i*(vals.length/1000.0) )];
    }

    // print out characters corresponding to its pixels data
    // use getChar method to get the character to print for each pixel in the image
    public void view(StillImage img) {
        // getPixel(), to find out the pixel data in your image
        // getChar(), to find out the text character corresponding to each pixel
        // System.out.println(), to print out lines of text
                
    }

}