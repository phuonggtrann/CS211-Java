import java.util.Scanner;
import java.io.IOException;
import java.io.File;

// this is both Player and Loadable
public class MultimediaPlayer {
    // default constructor
    public MultimediaPlayer() {}

    // add an additional media loader to aggregate
    public void add(Loadable i) {}

    // indicates whether the multimedia player can play the input Loadable
    // by checking whether any of its internal Players canPlay the media.
    public boolean canPlay(Loadable i) {}

    //  play back the input media
    // by searching the internal Players and finding one which supports the Loadable
    // If one is found, then use it to play the input media, otherwise do nothing.
    public void play(Loadable i) {}

    // read the text data contained and return results of int[]
    // if not in format, throw exception
    public int[] read(String filename) {
        Scanner s = new Scanner(new File(filename));
        int [] ans = {};
        return ans; 
    }

    // checking whether any og internal loaders regconize the format
    public boolean matches(int[] data) {return true;}

    // looking through all the internal loaders and find one that regconize the format
    // if none are found, throw LoadException
    public Loadable load(int[] data) throws LoadException {}

    // read the file into array
    // use array to load the media
    //play the resule Loadable
    public void play(String filename) throws LoadException, IOException {}

}