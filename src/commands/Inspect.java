package commands;

import java.util.ArrayList;

import game.Game;
import npc.NPC;
import items.Item;

public class Inspect extends Command {

    public Inspect() {
        this.name = "inspect";
        this.argsAmount = 1;
    }

    public void execute(Game game, ArrayList<String> args) {
        NPC npcInpection = game.getCurrentLocation().findNpc(args.get(0));
        if (npcInpection != null) {
            npcInpection.inspect();
            return;
        }
        // bag
        int itemInspectionIndex = game.getPlayer().searchBag(args.get(0));
        Item gottenItem = game.getPlayer().getFromBag(itemInspectionIndex);
        if (gottenItem != null) {
            gottenItem.inspect();
            return;
        }
        // floor
        itemInspectionIndex = game.getCurrentLocation().searchFloor(args.get(0));
        gottenItem = game.getCurrentLocation().getFromFloor(itemInspectionIndex);
        if (gottenItem != null) {
            gottenItem.inspect();
            return;
        }
        System.out.println("Please enter a valid NPC/Item");
    }

    public void execute(Game game) {

    }
} // 👍