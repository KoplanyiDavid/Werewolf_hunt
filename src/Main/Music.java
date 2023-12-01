package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Music {
    Clip clip;
    public void setFile(URL name) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {

        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
