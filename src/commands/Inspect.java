package commands;

import java.util.ArrayList;

import game.Game;
import npc.NPC;

public class Inspect extends Command {

    public Inspect() {
        this.name = "inspect";
        this.argsAmount = 1;
    }

    public void execute(Game game, ArrayList<String> args) {
        NPC npcInpection = game.currentLocation.findNpc(args.get(0));
        if (npcInpection != null) {
            npcInpection.inspect();
        } else {
            System.out.println("Please enter a valid NPC :) cheers");
        }
    }

    public void execute(Game game) {

    }
} // 👍