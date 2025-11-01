package commands;

import java.util.ArrayList;

import game.Game;
import items.Consumable;
import items.Item;

public class Use extends Command {

    public Use() {
        name = "Use";
        argsAmount = 1;
    }

    public void execute(Game game) {
        throw new Error("Please do not call this method or I will summon Mahoraga");
    }

    /**
     * This runs when user tries to use an item in their inventory
     * 
     * @param game the current instance of the game thats running
     * @param args the name of the item that they want to use
     */
    public void execute(Game game, ArrayList<String> args) {
        // got the string name in args 0
        // find the object from the inventory with the same name as the one in args
        // call the use method on that object
        // they might enter something that's not in their inventory
        int index = game.getPlayer().searchBag(args.get(0));
        if (index == -1) {
            System.out.println("This item is not in your inventory");
            return;
        }
        Item item = game.getPlayer().getFromBag(index);
        if (item instanceof Consumable) {
            ((Consumable) item).use(game);
        } else {
            System.out.println("This item can not be used");
        }

    }

}
