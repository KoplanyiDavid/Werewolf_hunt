package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    GameManager gm;
    public ActionHandler(GameManager gm) {
        this.gm = gm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        switch (yourChoice) {
            //Scene 1
            case "lookHouse": gm.ev1.lookHouse(); break;
            case "talkHouse": gm.ev1.talkHouse(); break;
            case "restHouse": gm.ev1.restHouse(); break;

            case "lookKnight": gm.ev1.lookKnight(); break;
            case "talkKnight": gm.ev1.talkKnight(); break;
            case "attackKnight": gm.ev1.attackKnight(); break;

            case "lookChest": gm.ev1.lookChest(); break;
            case "talkChest": gm.ev1.talkChest(); break;
            case "openChest": gm.ev1.openChest(); break;
            //Scene 2
            case "lookCave": gm.ev2.lookCave(); break;
            case "talkCave": gm.ev2.talkCave(); break;
            case "enterCave": gm.ev2.enterCave(); break;

            case "lookWoods": gm.ev2.lookWoods(); break;
            case "talkWoods": gm.ev2.talkWoods(); break;
            case "searchWoods": gm.ev2.searchWoods(); break;
            //Change scenes
            case "goScene1": gm.sc.showScene1(); break;
            case "goScene2": gm.sc.showScene2(); break;
            //others
            case "restart": gm.sc.exitGameOver(); gm.sc.showScene1(); break;
        }
    }
}
