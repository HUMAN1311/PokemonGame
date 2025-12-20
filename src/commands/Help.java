package commands;

import java.util.ArrayList;

public class Help extends Command {

    public Help() {
        this.name = "help";
        this.argsAmount = 0;

    }

    public void execute() {
        System.out.println("    - Interact");
        System.out.println("    - Inspect");
        System.out.println("    - Inventory");
        System.out.println("    - LookAround");
        System.out.println("    - Map");
        System.out.println("    - PickUp");
        System.out.println("    - Quests");
        System.out.println("    - Travel");
        System.out.println("    - WhereAmI");
        System.out.println("    - WhoAmI");
        System.out.println("    - Save");
        System.out.println("    - Load");
    }

    public void execute(ArrayList<String> args) {
        this.execute();
    }
}
