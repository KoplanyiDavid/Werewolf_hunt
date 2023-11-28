package Main;

import java.awt.event.ActionListener;

public class SceneChanger {
    GameManager gm;
    public SceneChanger(GameManager gm) {
        this.gm = gm;
    }

    public void showScene1() {
        gm.ui.bgPanel[0].setVisible(true);
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.messageText.setText("Találjuk meg a vérfarkast és mentsük meg a lányokat!");
    }

    public void showScene2() {
        gm.ui.bgPanel[0].setVisible(false);
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.messageText.setText("");
    }
}
