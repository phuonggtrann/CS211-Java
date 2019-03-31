// this is an AudioPlayer
public class TextAudioPlayer extends AudioPlayer {
    // default constructor
    public TextAudioPlayer() {
        super();
    }

    // for each datapoint, print out a line "*" 
    // with the position of the asterisj depending on the amplitude of the data point
    // do until hasNext() is false
    public void playback(AudioStream aud) {
        while (aud.hasNext()) {
            int pos = (aud.next()+1000)*7/200;
            String s="";
            for (int a=0; a<pos; a++) {
                s +=" ";
            }
            s+="*";
            System.out.println(s); 
        }
    }
}