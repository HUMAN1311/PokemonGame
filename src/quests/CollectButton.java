package quests;

import items.StrangeButton;
import npc.NPC;
import game.Game;

public class CollectButton extends Quest {

    public CollectButton() {
        name = "CollectButton";
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
