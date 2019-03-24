// both Loadable and AudioStream
public class LoadableAudio implements Loadable, AudioStream {
    // default constructor
    public LoadableAudio() {}

    // Declare insistance
    private int size;
    private int frequency;
    // private instance
    private int[] audioData;
    private int nextIndex;

    // Over-loading constructor 
    public LoadableAudio(int frequency, int size) {
        this.nextIndex=0;
        this.audioData=new int[0];
        this.frequency = frequency;
        this.size = size;
    }

    // Set internal array
    private void setAudioData(int[] audioData) {
        this.audioData=audioData;
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
        LoadableAudio aud = null;
        try {
            if (!this.matches(data)) {
                throw new LoadException("This is not audio data type");
            }
            else {
                if (data.length<=3) {
                    throw new LoadException("There is no frequency");
                }
                for (int a : data) {
                    if (a<-999 || a>999) {
                        throw new LoadException("Amplitude data is outside of bounds");
                    }
                }
                aud = new LoadableAudio(data[3], data.length-4);
                aud.setAudioData(data);
                this.frequency=data[3];
                this.size=data.length-4;
            }
        } catch (LoadException e) {
            System.out.println(e);
        }
        return aud;
    }
    
    // return playback frequency of the loaded audio data
    public int freq() {return this.frequency;}
    
    // return next element of audio data from current playback
    public int next() {
        int value=0;
        try{
            value=this.audioData[this.nextIndex];
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }   
        return value; 
    }
    
    // true if there's still left to play
    // ie: as long as next() call has not stepped throught all of the audio data yet
    public boolean hasNext() {
        boolean isNext=false;
        if (this.nextIndex+1<this.size) {
            isNext=true;
        }
        else {
            isNext=false;
        }
        return isNext;
    }
}