// this is a Player
public abstract class AudioPlayer implements Player{
    // default constructor
    public AudioPlayer() {}

    // defined functionality for playing audio
    public abstract void playback(AudioStream aud);

    // true if input 1 is an AudioStream, false if not
    public boolean canPlay(Loadable l) {
        if (l instanceof AudioStream) {
            return true;
        }
        else {return false;}
    }

    // plays the input loadable i, call playback()
    public void play(Loadable l) {
        if (this.canPlay(l)) {
            playback((AudioStream)l);
        }
    }
}