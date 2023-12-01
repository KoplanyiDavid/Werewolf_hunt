package Event;

import Main.GameManager;

public class Event02 {
    GameManager gm;
    public Event02(GameManager gm) {
        this.gm = gm;
    }

    public void lookCave() {
        gm.ui.messageText.setText("Ez egy barlang.");
    }
    public void talkCave() {
        gm.ui.messageText.setText("A visszang válaszol.");
    }
    public void enterCave() {
        if (gm.player.hasLantern == 0) {
            gm.ui.messageText.setText("Túl sötét van, hogy bemenj.");
        }
        else {
            gm.sc.showScene3();
        }
    }
    public void lookWoods() {
        gm.ui.messageText.setText("Nagy erdő terül itt el...");
    }
    public void talkWoods() {
        gm.ui.messageText.setText("A beszéd segít a növények fejlődésében, de ezek a fák már jó magasra nőttek.");
    }
    public void searchWoods() {
        if (gm.player.hasLantern == 0) {
            gm.ui.messageText.setText("Találtál egy lámpást.");
            gm.player.hasLantern = 1;
            gm.playSE(gm.soundMap.get("itemGet"));
            gm.player.updatePlayerStatus();
        }
        else {
            gm.ui.messageText.setText("Nincs már itt semmi.");
        }
    }
}
