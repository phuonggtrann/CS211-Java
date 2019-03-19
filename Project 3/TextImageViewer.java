// this is an ImageViewer
public class TextImageViewer {
    // default constructor
    public TextImageViewer() {}

    // retreive text character corresponding to given pixel value
    private final char[] vals = {' ', ',', 'o', 'O', '@'};
    public char getChar(int i) {
        return vals[(int)( i*(vals.length/1000.0) )];
    }

    // print out characters corresponding to its pixels data
    // use getChar method to get the character to print for each pixel in the image
    public void view(StillImage img) {}

}