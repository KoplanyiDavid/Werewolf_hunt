package Event;

import Main.GameManager;

public class Event01 {
    GameManager gm;
    public Event01(GameManager gm) {
        this.gm = gm;
    }

    public void lookHouse() {
        gm.ui.messageText.setText("Ez a te házad");
    }

    public void talkHouse() {
        gm.ui.messageText.setText("Kihez beszélsz?");
    }

    public void restHouse() {
        if (gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("Pihensz.\nAz életed töltődik.");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
        }
        else {
            gm.ui.messageText.setText("Tele van az életed.");
        }
    }

    public void lookKnight() {
        gm.ui.messageText.setText("Egy lovag áll előtted");
    }

    public void talkKnight() {
        gm.ui.messageText.setText("Lovag: Ne menj tovább fegyver nélkül!\nNézd meg a ládában, hátha van valami jó benne!");
    }

    public void attackKnight() {
        if (gm.player.hasShield == 0) {
            if (gm.player.hasSword == 0) {
                if (gm.player.playerLife != 1) {
                    gm.ui.messageText.setText("Lovag: Hé, ne légy ostoba!");
                    gm.player.playerLife--;
                    gm.player.updatePlayerStatus();
                }
                else if (gm.player.playerLife == 1) {
                    gm.ui.messageText.setText("Lovag: Idióta...");
                    gm.player.playerLife--;
                    gm.player.updatePlayerStatus();
                }
            }
            else if (gm.player.hasSword == 1) {
                gm.ui.messageText.setText("Lovag: Bassza meg! AHH...\n(Legyőzted a lovagot és megszerezted a pajzsát)");
                gm.player.hasShield = 1;
                gm.player.updatePlayerStatus();
            }
        }
        else {
            gm.ui.messageText.setText("Lovag: Hagyj békén...");
        }
    }

    public void lookChest() {
        gm.ui.messageText.setText("Ez egy láda");
    }

    public void talkChest() {
        gm.ui.messageText.setText("Kihez beszélsz?");
    }

    public void openChest() {
        if (gm.player.hasSword == 0) {
            gm.ui.messageText.setText("Kinyitod a ládát és találsz egy kardot!");
            gm.player.hasSword = 1;
            gm.player.updatePlayerStatus();
        }
        else {
            gm.ui.messageText.setText("A láda üres...");
        }
    }
}
