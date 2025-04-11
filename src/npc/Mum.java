package npc;

import game.Game;
import quests.CollectHat;

public class Mum extends MinorNPC {
    public Mum() {
        super("Do you have your hat?", "Mum", "Looks like Mum");
    }

    @Override
    public void interact(Game game) {
        System.out.println(name + ": " + dialog);
        game.getPlayer().addQuest(new CollectHat());
    }

    // ;

}