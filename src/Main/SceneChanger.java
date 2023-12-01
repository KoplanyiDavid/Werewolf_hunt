package Main;

import java.awt.*;

public class SceneChanger {
    GameManager gm;
    public SceneChanger(GameManager gm) {
        this.gm = gm;
    }

    public void showScene1() {
        gm.ui.bgPanel[0].setVisible(true);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.messageText.setText("Találjuk meg a vérfarkast és mentsük meg a lányokat!");

        gm.stopMusic();
        gm.currentMusic = gm.soundMap.get("field");
        gm.playMusic(gm.currentMusic);
    }

    public void showScene2() {
        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.messageText.setText("");

        gm.stopMusic();
        gm.currentMusic = gm.soundMap.get("cave");
        gm.playMusic(gm.currentMusic);
    }

    public void showScene3() {
        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.messageText.setText("Beléptél a barlangba...Megvannak a lányok!\n***A játéknak itt vége, a második részből kiderül mi történt valójában...***");
    }

    public void showGameOver(int currentBgNum) {
        gm.ui.bgPanel[currentBgNum].setVisible(false);
        gm.ui.bgPanel[currentBgNum].setBackground(Color.black);
        gm.ui.titleLabel.setVisible(true);
        gm.ui.titleLabel.setText("YOU DIED");
        gm.ui.restartButton.setVisible(true);
        gm.ui.restartButton.setText("Click here to restart");

        gm.stopMusic();
        gm.playSE(gm.soundMap.get("death"));
    }

    public void exitGameOver() {
        gm.ui.titleLabel.setVisible(false);
        gm.ui.restartButton.setVisible(false);
        gm.player.setPlayerDefaultStatus();
    }
}
