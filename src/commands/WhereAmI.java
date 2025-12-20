package commands;

import java.util.ArrayList;

import game.Game;

public class WhereAmI extends Command {

    public WhereAmI() {
        this.name = "whereami";
        this.argsAmount = 0;
    }

    public void execute() {
        System.out.println(Game.getInstance().getCurrentLocation().name);
    }

    public void execute(ArrayList<String> args) {
        this.execute();
    }
}