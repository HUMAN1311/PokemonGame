package commands;

import java.util.ArrayList;

import game.Game;
import theworld.Location;

public class Travel extends Command {

    public Travel() {
        this.name = "Travel";
        this.argsAmount = 1;
    }

    public void execute(Game game) {

    }

    public void execute(Game game, ArrayList<String> args) {
        Location loc = game.findLocation(args.get(0));
        if (loc == null) {
            System.out.println("Where do you want to go?");
        } else {
            game.setCurrentLocation(loc);
        }
    }

}
