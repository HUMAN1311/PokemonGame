package game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

import theworld.Location;
import theworld.Morioh;
import theworld.Home;
import commands.*;

public class Game {

    private Location currentLocation;
    private PlayerCharacter player;
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Command> coolCommands = new ArrayList<Command>();
    private ArrayList<Location> coolLocations = new ArrayList<Location>();

    public Game() {
        System.out.println("welcome to game");
        this.createCharacter();
        this.createWorld();
        this.instantiateCmds();

    }

    public static void main(String[] args) throws Exception {
        Game newGame = new Game();
        newGame.start();

    }

    private void createCharacter() {
        System.out.print("What is your name?    ");
        String playerName = this.scan.nextLine();
        System.out.print("What is your gender?    ");
        String playerGender = this.scan.nextLine();
        System.out.print("What is your hair colour?    ");
        String playerHair = this.scan.nextLine();
        this.player = new PlayerCharacter(playerName, playerGender, playerHair);
    }

    private void createWorld() {
        coolLocations.add(new Home());
        coolLocations.add(new Morioh());
        currentLocation = coolLocations.get(0);
    }

    public void start() {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.print(">");
            String input = this.scan.nextLine().toLowerCase();
            ArrayList<String> commandArguments = new ArrayList<String>(Arrays.asList(input.split(" "))); // Splits words
                                                                                                         // appart with
            if (commandArguments.size() >= 1) { // " "
                String command = commandArguments.get(0);
                commandArguments.remove(0); // commandArguments now only contains arguments
                if (input.equalsIgnoreCase("exit")) {
                    isFinished = true;
                } else {
                    executioner(command, commandArguments);
                }
            }
            player.checkQuests();
            System.out.println("");
        }
        this.scan.close();
    }

    private void executioner(String cmd, ArrayList<String> args) {
        // first find the command object
        Command commandMatch = null;
        for (Command c : coolCommands) {
            if (cmd.equalsIgnoreCase(c.name)) {
                commandMatch = c;
            }
        }
        // checking if the command is valid
        if (commandMatch == null) {
            System.out.println("Enter a valid command \"C");
            return;
        }
        // if there are no reqiured args then execute
        if (commandMatch.argsAmount == 0) {
            commandMatch.execute(this);
        } else { // command reqiures arguments
            if (args.size() >= commandMatch.argsAmount) { // check if there is enough arguments given
                commandMatch.execute(this, args);
            } else { // this runs where there are not enough args given
                System.out.println("You must enter " + commandMatch.argsAmount + " total arguments");
            }
        }

    }

    private void instantiateCmds() {
        this.coolCommands.add(new WhoAmI());
        this.coolCommands.add(new WhereAmI());
        this.coolCommands.add(new LookAround());
        this.coolCommands.add(new Interact());
        this.coolCommands.add(new Inspect());
        this.coolCommands.add(new Help());
        this.coolCommands.add(new PickUp());
        this.coolCommands.add(new Inventory());
        this.coolCommands.add(new Travel());
        this.coolCommands.add(new Quests());
    }

    public Location findLocation(String name) {
        for (Location l : this.coolLocations) {
            if (l.name.equalsIgnoreCase(name)) {
                return l;
            }
        }
        return null;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    public void setCurrentLocation(Location newLocation) {
        currentLocation = newLocation;
    }
}

// ">help" for more commands
// ">Map" for list of locations
// major npcs/quests
// steal Skitty Queens blue metal ball
// pickup with 2 words, like mouldy apple
// interactable things