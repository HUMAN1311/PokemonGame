package npc;

import game.Game;
import items.Item;

public class SellNPC extends NPC {
    public SellNPC(String name, String design) {
        super(name, design);

    }

    public void interact() {
        this.speak("Welcome to 'Shop'");
        this.speak("What would you like to sell");
        String input = Game.getInstance().getScanner().nextLine();
        int index = Game.getInstance().getPlayer().searchBag(input);
        if (index != -1) {
            // they have the item :0
            Item itemRemoved = Game.getInstance().getPlayer().removeFromBag(index);
            Game.getInstance().getPlayer().addToBalance(itemRemoved.value);
        } else {
            this.speak("What do you want to sell? Please enter a valid item.");
        }

    }
}
