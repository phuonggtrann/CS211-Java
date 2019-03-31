import java.util.Scanner;
import java.io.IOException;
import java.io.File;

// this is both Player and Loadable
public class MultimediaPlayer implements Player, Loadable {

    // internal array instances
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
            if (p.canPlay(l)) { // if the object is playable, call its method to play
                p.play(l);
            }
        }
    }

    // read the text data contained and return results of int[]
    // if not in format, throw exception
    public int[] read(String filename) throws LoadException, IOException {
        int[] ans = new int[0];
        int countToken = 0;
        int countInt = 0;
        try {
            Scanner token = new Scanner(new File(filename));
            // first scan for the amount of token (!=int is counted)
            while (token.hasNext()) {
                token.next();
                countToken++;
            }
            // create scanner for a second scan
            Scanner ints = new Scanner(new File(filename));
            while (ints.hasNextInt()) { // scan for int only
                int[] temp = ans;
                ans = new int[ans.length + 1];
                for (int i = 0; i < temp.length; i++) { // resize and load new int into array
                    ans[i] = temp[i];
                }
                ans[ans.length - 1] = ints.nextInt();
                countInt++;
            }
            if (countToken > countInt) {
                token.close();
                ints.close();
                throw new LoadException("Badly format file"); // if not in format
            }

            token.close(); // close if finish
            ints.close(); // close if finish

        } catch (IOException e) { // if file not found

        }

        return ans;
    }

    // checking whether any of internal loaders regconize the format
    public boolean matches(int[] data) {
        boolean ans = false;
        for (Loadable i : this.loaders) {
            if (i.matches(data)) { // call in matches to see weather it's the right format
                ans = true;
            }
        }
        return ans; // return boolean answer
    }

    // looking through all the internal loaders and find one that regconize the
    // format
    // if none are found, throw LoadException
    public Loadable load(int[] data) throws LoadException {
        Loadable l = null;
        boolean check = true;
        for (Loadable i : this.loaders) {
            if (i.matches(data)) { // if object is found
                l = i.load(data);
                check = false;
            }
        }
        if (check) {
            throw new LoadException("can't load format"); // if none are found
        }
        return l; // return the object
    }

    // read the file into array
    // use array to load the media
    // play the result Loadable
    public void play(String filename) throws LoadException, IOException {
        Loadable l = null;
        int[] data = read(filename); // reade and load file into array
        if (matches(data)) { 
            l = load(data);
        }
        if (canPlay(l)) { // play the object
            play(l); 
        }
    }

}