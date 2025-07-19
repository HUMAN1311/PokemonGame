package commands;

import java.util.ArrayList;

import game.Game;

public class Load extends Command {

    public Load() {
        this.name = "load";
        this.argsAmount = 1;
    }

    public void execute(Game game) {
        throw new Error("Please do not call this method or I will summon Mahoraga");
    }

    public void execute(Game game, ArrayList<String> args) {
        Game g = Game.load(args.get(0));
        if (g != null) {
            game.setGame(g);
        }
    }

}
