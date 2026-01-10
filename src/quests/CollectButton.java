package quests;

import game.Game;
import items.StrangeButton;
import npc.NPC;

public class CollectButton extends Quest {
    public static final String NAME = "CollectButton";

    public CollectButton() {
        name = NAME;
        description = "Find & Collect one of Kira's buttons";
    }

    public boolean isComplete() {
        if (Game.getInstance().getPlayer().searchBag(StrangeButton.NAME) != -1) {
            giveReward();
            return true;
        } else
            return false;

    }

    protected void giveReward() {
        NPC.speak("Thanks, that's the button I need", "Rohan");
    }
}
