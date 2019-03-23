// is a Player
public abstract class ImageViewer implements Player {
    // Default constructor
    public ImageViewer()  {}

    // Define functionality for viewing images
    public abstract void view(StillImage img);

    // return true if input l is a StillImage and false if not
    public boolean canPlay(Loadable l) {
        if (l instanceof StillImage) {return true;} 
        else {return false;}   
    }

    // view input loadable i, using a call to view method
    public void play(Loadable l) {
        if (canPlay(l)) {
            view((StillImage)l);}
    }
}
