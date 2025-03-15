package commands;

import java.util.ArrayList;

import game.Game;

public class WhereAmI extends Command {

    public WhereAmI() {
        this.name = "whereami";
        this.argsAmount = 0;
    }

    public void execute(Game game) {
        System.out.println(game.getCurrentLocation().name);
    }

    public void execute(Game game, ArrayList<String> args) {
        this.execute(game);
    }
}