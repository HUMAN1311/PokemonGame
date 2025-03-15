package commands;

import java.util.ArrayList;

import game.Game;

public class WhoAmI extends Command {

    public WhoAmI() {
        this.name = "whoami";
        this.argsAmount = 0;
    }

    public void execute(Game game) {
        System.out.println(game.player.name);
    }

    public void execute(Game game, ArrayList<String> args) {
        this.execute(game);
    }
}