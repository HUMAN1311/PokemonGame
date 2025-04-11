package npc;

import game.Game;

public class MinorNPC extends NPC {
    public String dialog;

    public MinorNPC(String dialog, String name, String design) {
        super(name, design);
        this.dialog = dialog;
    }

    @Override
    public void interact(Game game) {
        System.out.println(name + ": " + dialog);
    }

}
