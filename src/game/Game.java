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

public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    private Location currentLocation;
    private PlayerCharacter player;
    private transient Scanner scan = new Scanner(System.in);
    private transient ArrayList<Command> coolCommands = new ArrayList<Command>();
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

    // public static void makeFile() {
    // try {
    // File f = new File("File.txt");
    // boolean wasCreated = f.createNewFile();
    // if (wasCreated) {
    // System.out.println("File was created");
    // } else {
    // System.out.println("File already exists");
    // }
    // } catch (IOException e) {
    // System.out.println("IOException occured :<");
    // }
    // }

    // public static void writeFile() {

    // try {
    // FileWriter w = new FileWriter("File.txt", true);
    // w.write(" __\r\n" + //
    // " w c(..)o (\r\n" + //
    // " \\__(-) __)\r\n" + //
    // " /\\ (\r\n" + //
    // " /(_)___)\r\n" + //
    // " w /|\r\n" + //
    // " | \\\r\n" + //
    // " m m \r\n");
    // w.close();
    // System.out.println("my new favourite reaction image is the distinguished
    // monkey");
    // } catch (IOException e) {
    // System.out.println("An IOExecption occured");
    // }
    // }

    // public static void readFile() {

    // try {
    // File r = new File("File.txt");
    // Scanner scan = new Scanner(r);
    // while (scan.hasNextLine()) {
    // System.out.println(scan.nextLine());
    // }
    // scan.close();
    // } catch (FileNotFoundException e) {
    // System.out.println("File was not found" + e.getMessage());

    // }
    // }

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
        this.coolCommands.add(new Map());
        this.coolCommands.add(new Save());
        this.coolCommands.add(new Load());
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
// Make items in inv usable ⭐
// option to load a game at the start ⭐
// after you quest for the button theres another character who u talk to
// (hayato) watashiwadanokirayoshikage
// toruu for shop person. no WOU (BuyNPC)

// eigth handled sword divergent sila divine general <pokemon name> in shibuya
// zoro :D (lost)

// create and finish the use command