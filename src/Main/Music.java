package Main;

import javax.sound.sampled.Clip;

public class Music extends SE {
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
