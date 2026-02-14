package quests;

import game.Game;
import items.*;
import npc.NPC;

public class CollectHat extends Quest {
    public static final String NAME = "CollectHat";

    public CollectHat() {
        name = NAME;
        description = "Find & collect one Hat";
    }

    public boolean isComplete() {
        if (Game.getInstance().getPlayer().searchBag(Hat.NAME) != -1) {
            giveReward();
            return true;
        } else
            return false;

    }

    protected void giveReward() {
        Game.getInstance().getPlayer().addToBag(new Sandwich());
        NPC.speak("Well done for finding your hat, here's a sandwich! Make your way to Morioh.", "Mum");
    }

}
