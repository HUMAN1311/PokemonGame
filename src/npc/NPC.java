package npc;

import java.io.Serializable;

import game.Game;

public class NPC implements Serializable {
    public String name;
    public String design;

    public NPC(String name, String design) {
        this.name = name;
        this.design = design;
    }

    public void interact(Game game) {
        System.out.println("This is " + name + ", " + design);

    }

    public void inspect() {
        System.out.println("This is " + name + ", " + design);

    }
}
