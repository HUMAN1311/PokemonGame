package commands;

import java.util.ArrayList;

import game.Game;

public class LookAround extends Command {

    public LookAround() {
        this.name = "lookaround";
        this.argsAmount = 0;
    }

    public void execute(Game game) {
        System.out.println(game.getCurrentLocation().description);
        game.getCurrentLocation().printNpcList();
        game.getCurrentLocation().printItemList();

    }

    public void execute(Game game, ArrayList<String> args) {
        this.execute(game);
    }

}
