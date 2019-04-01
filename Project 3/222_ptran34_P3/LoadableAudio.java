// both Loadable and AudioStream
public class LoadableAudio implements Loadable, AudioStream {
    // default constructor
    public LoadableAudio() {
    }

    // Declare insistance
    private int size;
    private int frequency;

    // private instance
    private int[] audioData;
    private int amplitude;

    // Over-loading constructor
    public LoadableAudio(int frequency, int size) {
        this.amplitude = 0;
        this.frequency = frequency;
        this.size = size;
    }

    // Set internal array
    private void setAudioData(int[] data) {
        int count=0;
        this.audioData = new int[data.length-4];
        for (int x=4; x<data.length; x++) {
            this.audioData[count]=data[x];
            count++;
        }
    }

    // true if first 3 elements are 3,2,1
    // false otherwise or there's less than 3 elements
    public boolean matches(int[] data) {
        boolean isMatch = false;
        if (data.length >= 3) {
            if (data[0] == 3 && data[1] == 2 && data[2] == 1) {
                isMatch = true;
            }
        }
        return isMatch;
    }

    // throw exception if not enough data or out of bound (-999-999)
    // otherwise, create new LoadableAutdio and return
    public LoadableAudio load(int[] data) throws LoadException {
        if (!this.matches(data)) {
            throw new LoadException("This is not audio data type");
        } else {
            if (data.length < 4) {
                throw new LoadException("There is no frequency");
            }
            for (int a=4; a<data.length; a++) {
                if (data[a] < -999 || data[a] > 999) {
                    throw new LoadException("Amplitude data is outside of bounds");
                }
            }
            LoadableAudio aud = new LoadableAudio(data[3], data.length - 4);
            aud.setAudioData(data);
            return aud;
        }
    }

    // return playback frequency of the loaded audio data
    public int freq() {
        return this.frequency;
    }

    // return next element of audio data from current playback
    public int next() {
        int value = 0;
        try { // using try-catch block
            value = this.audioData[this.amplitude]; 
            this.amplitude++; // if return the next element, plus 1 for index
        } catch (IndexOutOfBoundsException e) { // catch out of index 
        }
        return value;
    }

    // true if there's still left to play
    // ie: as long as next() call has not stepped throught all of the audio data yet
    public boolean hasNext() {
        boolean isNext = false;
        if (this.amplitude < this.audioData.length) {
            isNext = true; // if the index isn't out of bound, return true
        }
        return isNext;
    }
}