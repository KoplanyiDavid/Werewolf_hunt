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
        gm.ui.messageText.setText("Pihensz.\nAz életed töltődik.");
    }

    public void lookKnight() {
        gm.ui.messageText.setText("Egy lovag áll előtted");
    }

    public void talkKnight() {
        gm.ui.messageText.setText("Lovag: Ne menj tovább fegyver nélkül!\nNézd meg a ládában, hátha van valami jó benne!");
    }

    public void attackKnight() {
        gm.ui.messageText.setText("Lovag: Hé, ne légy ostoba!");
    }

    public void lookChest() {
        gm.ui.messageText.setText("Ez egy láda");
    }

    public void talkChest() {
        gm.ui.messageText.setText("Kihez beszélsz?");
    }

    public void openChest() {
        gm.ui.messageText.setText("Kinyitod a ládát és találsz egy kardot!");
    }
}
