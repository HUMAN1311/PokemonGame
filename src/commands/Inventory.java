package commands;

import java.util.ArrayList;

import game.Game;

public class Inventory extends Command {

    public Inventory() {
        this.name = "inventory";
        this.argsAmount = 0;
    }

    public void execute() {
        Game.getInstance().getPlayer().printBag();
        System.out.println("Your balance is:    £" + Game.getInstance().getPlayer().getMoneyAmount());
    }

    public void execute(ArrayList<String> args) {
        this.execute();
    }
}
