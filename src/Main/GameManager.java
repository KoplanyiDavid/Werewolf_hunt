package Main;

import Event.Event01;
import Event.Event02;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public Player player = new Player(this);
    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    Music music = new Music();
    SE se = new SE();
    public HashMap<String, URL> soundMap = new HashMap<>();
    public URL currentMusic;
    public SceneChanger sc = new SceneChanger(this);

    public static void main(String[] args) {
        new GameManager();
    }

    public void readSoundNames(String filePath) {
        String[] keys = {"field", "cave", "knightDef", "knightDontGo", "knightDumbass", "knightLeave", "knightStupid", "death", "itemGet"};
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            int i = 0;
            for (String line : lines) {
                soundMap.put(keys[i], getClass().getClassLoader().getResource(line));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameManager() {
        readSoundNames("sounds.txt");
        currentMusic = soundMap.get("field");
        playMusic(currentMusic);
        player.setPlayerDefaultStatus();
        sc.showScene1();
    }

    public void playSE(URL url) {
        se.setFile(url);
        se.play(url);
    }
    public void playMusic(URL url) {
        music.setFile(url);
        music.play();
        music.loop();
    }
    public void stopMusic() {
        music.stop();
    }
}
