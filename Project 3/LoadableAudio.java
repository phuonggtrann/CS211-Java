// both Loadable and AudioStream
public class LoadableAudio {
    // default constructor
    public LoadableAudio() {}

    // Over-loading constructor 
    public LoadableAudio(int frequency, int size) {
        this.frequency = frequency;
        this.size = size;
    }

    // true if first 3 elements are 3,2,1 
    // false otherwise or there's less than 3 elements
    public boolean matches(int[] data) {return true;}

    // throw exception if not enough data or out of bound (-999-999)
    // otherwise, create new LoadableAutdio and return
    public LoadableAudio load(int[] data) throws LoadException {}
    
    // return playback frequency of the loaded audio data
    public int freq() {return 0;}
    
    // return next element of audio data from current playback
    public int next() {return 0;} 
    
    // true if there's still left to play
    // ie: as long as next() call has not stepped throught all of the audio data yet
    public boolean hasNext() {return true;}
}