package commands;

import java.util.ArrayList;

import game.Game;

public class Inventory extends Command {

    public Inventory() {
        this.name = "inventory";
        this.argsAmount = 0;
    }

    public void execute(Game game) {
        game.getPlayer().printBag();
    }

    public void execute(Game game, ArrayList<String> args) {
        this.execute(game);
    }
}
