package game;

import java.util.ArrayList;

import items.Item;

public class PlayerCharacter {
    public String name;
    public String gender;
    public String hairColour;
    private ArrayList<Item> bag;

    public PlayerCharacter(String name, String gender, String hairColour) {
        this.name = name;
        this.gender = gender;
        this.hairColour = hairColour;
        this.bag = new ArrayList<Item>();

    }

    public void addToBag(Item toAdd) {
        bag.add(toAdd);
    }

    public void printBag() {
        String toPrint = "You are carrying - ";
        for (Item i : bag) {
            toPrint = toPrint + i.name + ", ";
        }
        System.out.println(toPrint);
    }

}
