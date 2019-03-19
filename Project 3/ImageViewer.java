// is a Player
public abstract class ImageViewer {
    // Default constructor
    public ImageViewer()  {}

    // Define functionality for viewing images
    public abstract void view(StillImage img)  {}

    // return true if input i is a StillImage and false if not
    public boolean canPlay(Loadable i) {return false;}

    // view input loadable i, using a call to view method
    public void play(Loadable i) {this.view(1);}
}
