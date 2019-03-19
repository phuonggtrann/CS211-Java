// both Loadable and StillImage
public class LoadableImage {
    // Default construct=or
    public LoadableImage() {}
    
    // Over-load constructor
    public LoadableImage(int w, int h) {}
    
    // return true if the first element is 55
    // false if it's not or there's no first element
    public boolean matches(int[] data) {
        return true;
    }

    // throw a LoadException if no width/height 
        //or there isn't enough pixel data
        // or pixel data out of bound (0-999)
    // if ok, construct new LoadableImage with dimenions
    public LoadableImage load(int[] data) throws LoadException {}

    // return width of the loaded image, in pixels
    // no specific behaviorr if this is called without loading an image first
    public int width() {return 0;}

    // same as width() but return height
    public int height() {return 0;}

    // return pixel at coordinate (x,y)
    // If ask for out of bounds, throw exception
    // no specific behavior if this is called without loading an image first
    public int getPixel(int x, int y) {return 0;}


}