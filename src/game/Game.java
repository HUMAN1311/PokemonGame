package game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import theworld.*;
import commands.*;

/**
 * Game is a singleton class that stores and controls the state of the game.
 * Since it is a singleton class, this means that there will only be one unique
 * object,
 * and it is easy to access because it's static (no object required).
 * 
 * For something to be a singleton you need to program three things:
 * Point 1 - Needs a private, static attribute that will store the single
 * instance of this class, initially null
 * Point 2 - Needs a private constructor so noone can make multiple different
 * instances
 * Point 3 - Needs a public, static method to make it easy to access, if
 * attribute is null it will make a new object, otherwise will use the old one
 */
public class Game implements Serializable {

    private static Game instance = null;

    private static final long serialVersionUID = 1L;
    private Location currentLocation;
    private PlayerCharacter player;
    private transient Scanner scan = new Scanner(System.in);
    private transient ArrayList<Command> coolCommands;
    private ArrayList<Location> coolLocations = new ArrayList<Location>();

    private Game() {
        System.out.println("welcome to game");
        this.createCharacter();
        this.createWorld();
        this.instantiateCmds();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        System.out.print("Please enter a save name, if you wish to start a new game press [ENTER]   ");
        Scanner scan = new Scanner(System.in);
        String saveName = scan.nextLine();
        if (saveName == "") {
            Game newGame = Game.getInstance();
            newGame.start();
        } else {
            Game.load(saveName).start();
        }
        scan.close();
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
        coolLocations.add(new Shibuya());
        coolLocations.add(new Shop());
        coolLocations.add(new FriendWorld());
        currentLocation = coolLocations.get(0);
    }

    public void start() {
        boolean isFinished = false;
        while (!isFinished) {
            // This These lines get the input from the user VVV
            System.out.print(">");
            String input = this.scan.nextLine().toLowerCase();
            ArrayList<String> commandArguments = new ArrayList<String>(Arrays.asList(input.split(" "))); // Splits words
                                                                                                         // appart with
            if (commandArguments.size() >= 1) { // This makes sure that something has been entered
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
            commandMatch.execute();
        } else { // command reqiures arguments
            if (args.size() >= commandMatch.argsAmount) { // check if there is enough arguments given
                commandMatch.execute(args);
            } else { // this runs where there are not enough args given
                System.out.println("You must enter " + commandMatch.argsAmount + " total arguments");
            }
        }

    }

    private void instantiateCmds() {
        this.coolCommands = new ArrayList<Command>();
        this.coolCommands.add(new WhoAmI());
        this.coolCommands.add(new WhereAmI());
        this.coolCommands.add(new LookAround());
        this.coolCommands.add(new Interact()); // this is ths fish command 🐟
        this.coolCommands.add(new Inspect());
        this.coolCommands.add(new Help());
        this.coolCommands.add(new PickUp());
        this.coolCommands.add(new Inventory());
        this.coolCommands.add(new Travel());
        this.coolCommands.add(new Quests());
        this.coolCommands.add(new Map());
        this.coolCommands.add(new Save());
        this.coolCommands.add(new Load());
        this.coolCommands.add(new Use());
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

    public void setCurrentLocation(Location newLocation) {
        currentLocation = newLocation;
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    public ArrayList<Location> getLocations() {
        return coolLocations;
    }

    public Scanner getScanner() {
        if (scan == null) {
            scan = new Scanner(System.in);
        }
        return scan;
    }

    public boolean save() {
        File f = new File(this.player.name);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("There was an error when saving the game");
            return false;
        }
        try {
            FileOutputStream fOut = new FileOutputStream(f);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(this);
            System.out.println("Game saved!");
            oOut.close();
        } catch (Exception e) {
            System.out.println("There was an error when saving the game" + e.getMessage());
            return false;
        }
        return true;
    }

    public static Game load(String saveName) {
        Game game = null;
        try {
            FileInputStream fIn = new FileInputStream(saveName);
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            game = (Game) oIn.readObject();
            oIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Please enter a valid file name");
        } catch (IOException e) {
            System.out.println("There was an error when loading the game" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("There was an error when loading the game" + e.getMessage());
        }
        game.getScanner(); // just to set the scan attribute
        game.instantiateCmds(); // just to set the command attribute
        instance = game;
        return game;
    }

    /**
     * Sets the attributes for the new loaded game.
     * 
     * @param newGame The game object that is being loaded.
     */

    public void setGame(Game newGame) {
        this.currentLocation = newGame.getCurrentLocation();
        this.player = newGame.getPlayer();
        this.coolLocations = newGame.getLocations();

    }

}
// add new quest after hayato ⭐
// toruu for shop person. no WOU (BuyNPC)
// pokemon
// certain locations locked behind quests
// update quest names to the blue NAME
// make npc text correctly spaced aka make a talking method

// eigth handled sword divergent sila divine general <pokemon name> in shibuya
// zoro :D (lost)
// tomodachi land or world
// the wired from lain
// yoshitsune and song lyrics ⭐

// atom heart father ⭐
// to kira
// stand arrow reward