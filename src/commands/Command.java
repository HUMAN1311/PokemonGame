package commands;

import java.util.ArrayList;

import game.Game;

public abstract class Command {

    public String name;
    public int argsAmount;

    public abstract void execute(Game game);

    public abstract void execute(Game game, ArrayList<String> args);

}
