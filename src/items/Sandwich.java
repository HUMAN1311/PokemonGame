package items;

import game.Game;

public class Sandwich extends Item implements Consumable {
    public Sandwich() {
        super("Sandwich", "It's a sandwich, it has mayonnaise on it.", 12);
    }

    public void use(Game game) {
        game.getPlayer().removeFromBag(this);
        System.out.println(game.getPlayer().name + ":   Mmm sandwich good");
    }
}
