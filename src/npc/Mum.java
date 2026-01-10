package npc;

import game.Game;
import quests.CollectHat;

public class Mum extends DialogNPC {
    public Mum() {
        super("Do you have your hat?", "Mum", "Looks like Mum");
    }

    @Override
    public void interact() {
        this.speak(dialog);
        Game.getInstance().getPlayer().addQuest(new CollectHat());
    }

}