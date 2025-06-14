package quests;

import game.PlayerCharacter;
import items.*;

public class CollectHat extends Quest {
    public CollectHat() {
        name = "CollectHat";
        description = "Find & Collect one Hat";
    }

    public boolean isComplete(PlayerCharacter player) {
        if (player.searchBag(Hat.NAME) != -1) {
            giveReward(player);
            return true;
        } else
            return false;

    }

    protected void giveReward(PlayerCharacter player) {
        player.addToBag(new Sandwich());
        System.out.println("Mum:    Well done for finding your hat, here's a sandwich!");
    }

}
