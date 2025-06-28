package commands;

import java.util.ArrayList;

import game.Game;
import npc.NPC;

public class Interact extends Command {

    public Interact() {
        this.name = "interact";
        this.argsAmount = 1;
    }

    public void execute(Game game, ArrayList<String> args) {
        NPC npcInteraction = game.getCurrentLocation().findNpc(args.get(0));
        if (npcInteraction != null) {
            npcInteraction.interact(game);
        } else {
            System.out.println("Please enter a valid NPC :) cheers");
        }

    }

    public void execute(Game game) {
        throw new Error("Please do not call this method or I will summon Mahoraga");

    }

}