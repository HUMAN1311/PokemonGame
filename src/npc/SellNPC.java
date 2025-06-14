package npc;

import game.Game;
import items.Item;

public class SellNPC extends NPC {
    public SellNPC(String name, String design) {
        super(name, design);

    }

    @Override
    public void interact(Game game) {
        System.out.println(name + ":    Welcome to 'Shop'");
        System.out.println(name + ":    What would you like to sell");
        String input = game.getScanner().nextLine();
        int index = game.getPlayer().searchBag(input);
        if (index != -1) {
            // they have the item :0
            Item itemRemoved = game.getPlayer().removeFromBag(index);
            game.getPlayer().addToBalance(itemRemoved.value);
        } else {
            System.out.println(name + ":    What do you want to sell? Please enter a valid item.");
        }

    }
}
