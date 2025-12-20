package commands;

import theworld.Location;
import java.util.ArrayList;

import game.Game;

public class Map extends Command {

    public Map() {
        name = "Map";
        argsAmount = 0;
    }

    public void execute() {
        // print a list of locations
        for (Location l : Game.getInstance().getLocations()) {
            System.out.println("    - " + l.name);
        }
    }

    public void execute(ArrayList<String> args) {
        execute();
    }
}
