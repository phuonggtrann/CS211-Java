// this is a Player
public abstract class AudioPlayer {
    // default constructor
    public AudioPlayer() {}

    // defined functionality for playing audio
    public abstract void playback(AudioStrem aud) {}

    // true if input 1 is an AudioStream, false if not
    public boolean canPlay(Loadable i) {return true;}

    // plays the input loadable i, call playback()
    public void play(Loadble i) {}
}