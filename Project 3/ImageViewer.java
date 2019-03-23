// is a Player
public abstract class ImageViewer implements Player {
    // Default constructor
    public ImageViewer()  {}

    // Define functionality for viewing images
    public abstract void view(StillImage img);

    // return true if input i is a StillImage and false if not
    public boolean canPlay(Loadable l) {
        if (i instanceof StillImage) {return true;} 
        else {return false;}   
    }

    // view input loadable i, using a call to view method
    public void play(Loadable i) {
        if (canPlay(i)) {
            view((StillImage)i);}
    }
}
