package commands;

import java.util.ArrayList;

import game.Game;

public class Quests extends Command {

    public Quests() {
        this.name = "Quests";
        this.argsAmount = 0;

    }

    public void execute() {
        Game.getInstance().getPlayer().printQuests();
    }

    public void execute(ArrayList<String> args) {
        this.execute();
    }
}
