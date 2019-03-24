// both Loadable and AudioStream
public class LoadableAudio implements Loadable, AudioStream {
    // default constructor
    public LoadableAudio() {}

    // Declare insistance
    private int size;
    private int frequency;
    private LoadableAudio a;

    // Over-loading constructor 
    public LoadableAudio(int frequency, int size) {
        a = new LoadableAudio(frequency, size);
        this.frequency = frequency;
        this.size = size;
    }

    // true if first 3 elements are 3,2,1 
    // false otherwise or there's less than 3 elements
    public boolean matches(int[] data) {
        boolean isMatch=false;
        if (data.length>3) {
            if (data[0]==3 && data[1]==2 && data[2]==1) {isMatch = true;}
        }
        return isMatch;
    }

    // throw exception if not enough data or out of bound (-999-999)
    // otherwise, create new LoadableAutdio and return
    public LoadableAudio load(int[] data) throws LoadException {
        if (!isMatch) {
            throw new LoadException("This is not audio data type");
        }
        else {
            if (data.length<=3) {
                throw new LoadException("There is no frequency");
            }
            for (int a : data) {
                if (a<-999 || a>999) {
                    throw new LoadException("Amplitude dara is outside of bounds");
                }
            }
        }
    }
    
    // return playback frequency of the loaded audio data
    public int freq() {return 0;}
    
    // return next element of audio data from current playback
    public int next() {return 0;} 
    
    // true if there's still left to play
    // ie: as long as next() call has not stepped throught all of the audio data yet
    public boolean hasNext() {return true;}
}