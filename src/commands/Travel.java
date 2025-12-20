package commands;

import java.util.ArrayList;

import game.Game;
import theworld.Location;

public class Travel extends Command {

    public Travel() {
        this.name = "Travel";
        this.argsAmount = 1;
    }

    public void execute() {
        throw new Error("Please do not call this method or I will summon Mahoraga");
    }

    public void execute(ArrayList<String> args) {
        Location loc = Game.getInstance().findLocation(args.get(0));
        if (loc == null) {
            System.out.println("Where do you want to go?");
        } else {
            Game.getInstance().setCurrentLocation(loc);
        }
    }

}
