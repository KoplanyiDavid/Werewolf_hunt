package Main;

import Event.Event01;
import Event.Event02;

import java.net.URL;

public class GameManager {
    ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public Player player = new Player(this);
    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    Music music = new Music();
    SE se = new SE();

    //sound
    public URL fieldMusic = getClass().getClassLoader().getResource("bensound-acousticbreeze.wav");
    public URL caveMusic = getClass().getClassLoader().getResource("bensound-ofeliasdream.wav");
    public URL knightDef = getClass().getClassLoader().getResource("knight_defeat_sound.wav");
    public URL knightDontGo = getClass().getClassLoader().getResource("knight_dont_go_further.wav");
    public URL knightDumbass = getClass().getClassLoader().getResource("knight_dumbass_sound.wav");
    public URL knightLeave = getClass().getClassLoader().getResource("knight_leave_sound.wav");
    public URL knightStupid = getClass().getClassLoader().getResource("knight_stupid_sound.wav");
    public URL deathSound = getClass().getClassLoader().getResource("death.wav");
    public URL itemGet = getClass().getClassLoader().getResource("itemGet.wav");

    public URL currentMusic;
    public SceneChanger sc = new SceneChanger(this);

    public static void main(String[] args) {
        new GameManager();
    }

    public GameManager() {
        currentMusic = fieldMusic;
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
        music.play(url);
        music.loop(url);
    }
    public void stopMusic(URL url) {
        music.stop(url);
    }
}
