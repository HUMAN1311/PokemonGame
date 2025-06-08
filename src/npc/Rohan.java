package npc;

import game.Game;
import quests.CollectButton;

public class Rohan extends DialogNPC {
    public Rohan() {
        super("Tell me if you see some button, it's yellow with brown stripes.", "Rohan",
                "the writer of 'Pink Dark Boy'");
    }

    @Override
    public void interact(Game game) {
        System.out.println(name + ":    " + dialog);
        game.getPlayer().addQuest(new CollectButton());
    }
}
