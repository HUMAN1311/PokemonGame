package quests;

import game.PlayerCharacter;

public abstract class Quest {

    public String name;
    public String description;

    public abstract boolean isComplete(PlayerCharacter player);

    protected abstract void giveReward(PlayerCharacter player);

}
