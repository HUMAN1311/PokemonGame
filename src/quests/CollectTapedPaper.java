package quests;

import game.Game;
import items.TapedPaper;

public class CollectTapedPaper extends Quest {

    public CollectTapedPaper() {
        name = "CollectTapedPaper";
        description = "Find & collect one TapedPaper";
    }

    public boolean isComplete() {
        if (Game.getInstance().getPlayer().searchBag(TapedPaper.NAME) != -1) {
            giveReward();
            return true;
        } else
            return false;

    }

    protected void giveReward() {
        Game.getInstance().getPlayer().removeFromBag(TapedPaper.NAME);
        System.out.println("Hayato:    Alright, let's open it so we can speak to Yoshihiro Kira!");
    }

}
