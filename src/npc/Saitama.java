package npc;

import game.Game;
import items.Item;

public class Saitama extends NPC {
    public Saitama() {
        super("Saitama", "He is standing behind the counter menacingly. Maybe try selling something to him");
    }

    @Override
    public void interact(Game game) {
        System.out.println("Saitama:    Welcome to 'Shop'");
        System.out.println("Saitama:    What would you like to sell");
        String input = game.getScanner().nextLine();
        int index = game.getPlayer().searchBag(input);
        if (index != -1) {
            // they have the item :0
            Item itemRemoved = game.getPlayer().removeFromBag(index);
            game.getPlayer().addToBalance(itemRemoved.value);
        } else {
            System.out.println("Saitama:    What do you want to sell? Please enter a valid item.");
        }

    }
}
