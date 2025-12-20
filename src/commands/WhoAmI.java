package commands;

import java.util.ArrayList;

import game.Game;

public class WhoAmI extends Command {

    public WhoAmI() {
        this.name = "whoami";
        this.argsAmount = 0;
    }

    public void execute() {
        System.out.println(Game.getInstance().getPlayer().name);
    }

    public void execute(ArrayList<String> args) {
        this.execute();
    }
}