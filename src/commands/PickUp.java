package commands;

import java.util.ArrayList;

import game.Game;
import items.Item;

public class PickUp extends Command {

    public PickUp() {
        this.name = "pickup";
        this.argsAmount = 1;
    }

    public void execute(Game game) {

    }

    public void execute(Game game, ArrayList<String> args) {
        Item collectedItem = game.getCurrentLocation().removeItem(args.get(0));
        if (collectedItem != null) {
            game.getPlayer().addToBag(collectedItem);
        } else {
            System.out.println("Please enter a valid item");
        }
    }

}