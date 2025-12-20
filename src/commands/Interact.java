package commands;

import java.util.ArrayList;

import game.Game;
import npc.NPC;

public class Interact extends Command {

    public Interact() {
        this.name = "interact";
        this.argsAmount = 1;
    }

    public void execute(ArrayList<String> args) {
        NPC npcInteraction = Game.getInstance().getCurrentLocation().findNpc(args.get(0));
        if (npcInteraction != null) {
            npcInteraction.interact();
        } else {
            System.out.println("Please enter a valid NPC :) cheers");
        }

    }

    public void execute() {
        throw new Error("Please do not call this method or I will summon Mahoraga");

    }

}