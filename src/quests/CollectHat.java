package quests;

import game.PlayerCharacter;
import items.Sandwich;

public class CollectHat extends Quest {
    public CollectHat() {
        name = "CollectHat";
    }

    public boolean isComplete(PlayerCharacter player) {
        if (player.searchBag("Hat") != -1) {
            giveReward(player);
            return true;
        } else
            return false;

    }

    protected void giveReward(PlayerCharacter player) {
        player.addToBag(new Sandwich());
    }

}
