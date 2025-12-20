package commands;

import java.util.ArrayList;

import game.Game;

public class LookAround extends Command {

    public LookAround() {
        this.name = "lookaround";
        this.argsAmount = 0;
    }

    public void execute() {
        System.out.println(Game.getInstance().getCurrentLocation().description);
        Game.getInstance().getCurrentLocation().printNpcList();
        Game.getInstance().getCurrentLocation().printItemList();

    }

    public void execute(ArrayList<String> args) {
        this.execute();
    }

}
