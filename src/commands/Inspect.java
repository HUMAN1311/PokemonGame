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

    public void execute(ArrayList<String> args) {
        NPC npcInpection = Game.getInstance().getCurrentLocation().findNpc(args.get(0));
        if (npcInpection != null) {
            npcInpection.inspect();
            return;
        }
        // bag
        int itemInspectionIndex = Game.getInstance().getPlayer().searchBag(args.get(0));
        Item gottenItem = Game.getInstance().getPlayer().getFromBag(itemInspectionIndex);
        if (gottenItem != null) {
            gottenItem.inspect();
            return;
        }
        // floor
        itemInspectionIndex = Game.getInstance().getCurrentLocation().searchFloor(args.get(0));
        gottenItem = Game.getInstance().getCurrentLocation().getFromFloor(itemInspectionIndex);
        if (gottenItem != null) {
            gottenItem.inspect();
            return;
        }
        System.out.println("Please enter a valid NPC/Item");
    }

    public void execute() {
        throw new Error("Please do not call this method or I will summon Mahoraga");
    }
} // 👍