package items;

import game.Game;

public class MouldyApple extends Item implements Consumable {

    public MouldyApple() {
        super("MouldyApple", "It's a very old apple, I don't know how old. Probably shouldn't eat or sell it.", -1000);
    }

    public void use() {
        Game.getInstance().getPlayer().removeFromBag(this);
        // 😭🍞🧀🍞
        System.out.println(Game.getInstance().getPlayer().name + ":   That was gross");
    }
}
