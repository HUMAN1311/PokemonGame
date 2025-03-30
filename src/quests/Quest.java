package quests;

import game.PlayerCharacter;

public abstract class Quest {

    public String name;

    public abstract boolean isComplete(PlayerCharacter player);

    protected abstract void giveReward(PlayerCharacter player);

}
