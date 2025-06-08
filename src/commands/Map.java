package commands;

import theworld.Location;
import java.util.ArrayList;

import game.Game;

public class Map extends Command {

    public Map() {
        name = "Map";
        argsAmount = 0;
    }

    public void execute(Game game) {
        // print a list of locations
        for (Location l : game.getLocations()) {
            System.out.println("    - " + l.name);
        }
    }

    public void execute(Game game, ArrayList<String> args) {
        execute(game);
    }
}
