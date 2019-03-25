import java.util.Scanner;
import java.io.IOException;
import java.io.File;

// this is both Player and Loadable
public class MultimediaPlayer implements Player, Loadable {

    // internal instances
    private Loadable[] loaders;
    private Player[] players;

    // default constructor
    public MultimediaPlayer() {
        this.loaders = new Loadable[2];
        this.players = new Player[2];
        this.loaders[0] = new LoadableImage();
        this.loaders[1] = new LoadableAudio();
        this.players[0] = new TextAudioPlayer();
        this.players[1] = new TextImageViewer();
    }

    // add an additional media loader to aggregate
    public void add(Loadable l) {
        this.loaders = new Loadable[this.loaders.length + 1];
        this.loaders[this.loaders.length - 1] = l;
    }

    // indicates whether the multimedia player can play the input Loadable
    // by checking whether any of its internal Players canPlay the media.
    public boolean canPlay(Loadable l) {
        boolean result = false;
        if (this.players[0].canPlay(l)) {
            result = true;
        } else if (this.players[1].canPlay(l)) {
            result = true;
        }
        return result;
    }

    // play back the input media
    // by searching the internal Players and finding one which supports the Loadable
    // If one is found, then use it to play the input media, otherwise do nothing.
    public void play(Loadable l) {
        for (Player p : this.players) {
            if (p.canPlay(l)) {
                p.play(l);
            }
        }
    }

    // read the text data contained and return results of int[]
    // if not in format, throw exception
    public int[] read(String filename) throws LoadException, IOException {
        int count = 0;
        Scanner sCount = new Scanner(new File(filename));
        // while (sCount.hasNextLine()) {
        // // if (sCount.nextInt()) {
        // // count++;
        // // }
        // }
        int[] ans = new int[count];
        sCount.close();
        Scanner s = new Scanner(new File(filename));
        int i = 0;
        return ans;
    }

    // checking whether any of internal loaders regconize the format
    public boolean matches(int[] data) {
        boolean ans=false;
        for(Loadable i:this.loaders){
            if(i.matches(data)){
                ans=true;
            }
        }
        return ans;
    }

    // looking through all the internal loaders and find one that regconize the
    // format
    // if none are found, throw LoadException
    public Loadable load(int[] data) throws LoadException {
        Loadable l = null;
        if (this.matches(data)) {
            if (data[0] == 55) {
                l = new LoadableImage();
            }
            if (data[0] == 3 && data[1] == 2 && data[2] == 1) {
                l = new LoadableAudio();
            }
        } else {
            throw new LoadException("no format found");
        }
        return l;
    }

    // read the file into array
    // use array to load the media
    // play the resule Loadable
    public void play(String filename) throws LoadException, IOException {
    }

}