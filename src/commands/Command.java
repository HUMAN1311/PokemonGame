package commands;

import java.util.ArrayList;
import java.io.Serializable;

import game.Game;

public abstract class Command implements Serializable {

    public String name;
    public int argsAmount;

    public abstract void execute(Game game);

    public abstract void execute(Game game, ArrayList<String> args);

}
