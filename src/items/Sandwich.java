package items;

import game.Game;

public class Sandwich extends Item implements Consumable {
    public Sandwich() {
        super("Sandwich", "It's a sandwich, it has mayonnaise on it.", 12);
    }

    public void use() {
        Game.getInstance().getPlayer().removeFromBag(this);
        System.out.println(Game.getInstance().getPlayer().name + ":   Mmm sandwich good");
    }
}
