package commands;

import java.util.ArrayList;

import game.Game;
import items.Item;

public class PickUp extends Command {

    public PickUp() {
        this.name = "pickup";
        this.argsAmount = 1;
    }

    public void execute() {
        throw new Error("Please do not call this method or I will summon Mahoraga");
    }

    public void execute(ArrayList<String> args) {
        Item collectedItem = Game.getInstance().getCurrentLocation().removeItem(args.get(0));
        if (collectedItem != null) {
            Game.getInstance().getPlayer().addToBag(collectedItem);
        } else {
            System.out.println("Please enter a valid item");
        }
    }

}