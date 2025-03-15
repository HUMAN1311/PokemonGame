package commands;

import java.util.ArrayList;

import game.Game;

public class Help extends Command {

    public Help() {
        this.name = "help";
        this.argsAmount = 0;

    }

    public void execute(Game game) {
        System.out.println("no");
    }

    public void execute(Game game, ArrayList<String> args) {
        this.execute(game);
    }
}
