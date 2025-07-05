package commands;

import java.util.ArrayList;

import game.Game;

public class Save extends Command {

    public Save() {
        name = "Save";
        argsAmount = 0;
    }

    public void execute(Game game) {
        game.save();
    }

    public void execute(Game game, ArrayList<String> args) {
        execute(game);
    }

}