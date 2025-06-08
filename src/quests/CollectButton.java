package quests;

import game.PlayerCharacter;

public class CollectButton extends Quest {

    public CollectButton() {
        name = "CollectButton";
        description = "Find & Collect one of Kira's buttons";
    }

    public boolean isComplete(PlayerCharacter player) {
        if (player.searchBag("StrangeButton") != -1) {
            giveReward(player);
            return true;
        } else
            return false;

    }

    protected void giveReward(PlayerCharacter player) {
        System.out.println("Rohan:  Thanks, that's the button I need");
    }
}
