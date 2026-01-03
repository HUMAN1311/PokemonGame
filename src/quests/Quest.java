package quests;

import java.io.Serializable;

public abstract class Quest implements Serializable {

    private static final long serialVersionUID = 4L;
    public String name;
    public String description;

    public abstract boolean isComplete();

    protected abstract void giveReward();

}
