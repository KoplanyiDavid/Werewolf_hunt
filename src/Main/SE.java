package Main;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SE {
    Clip clip;
    public void setFile(URL name) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {

        }
    }

    public void play(URL name) {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(URL name) {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(URL name) {
        clip.stop();
    }
}
