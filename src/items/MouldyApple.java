package items;

import game.Game;

public class MouldyApple extends Item implements Consumable {

    public MouldyApple() {
        super("MouldyApple", "It's a very old apple, I don't know how old. Probably shouldn't eat or sell it.", -1000);
    }

    public void use(Game game) {
        // game.getPlayer().removeFromBag() it wants index add the name or something :(
        // 😭🍞🧀🍞
        System.out.println(game.getPlayer().name + ":   That was gross");
    }
}
