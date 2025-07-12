package quests;

import java.io.Serializable;

import game.PlayerCharacter;

public abstract class Quest implements Serializable {

    private static final long serialVersionUID = 4L;
    public String name;
    public String description;

    public abstract boolean isComplete(PlayerCharacter player);

    protected abstract void giveReward(PlayerCharacter player);

}
