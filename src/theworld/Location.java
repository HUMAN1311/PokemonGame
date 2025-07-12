package theworld;

import java.io.Serializable;
import java.util.ArrayList;

import items.Item;
import npc.NPC;

public class Location implements Serializable {

    private static final long serialVersionUID = 5L;
    public String name;
    public String description;
    public ArrayList<NPC> NPCs;
    public ArrayList<Item> collectables;

    public Location(String name, String description, ArrayList<NPC> NPCs, ArrayList<Item> collectables) {
        this.name = name;
        this.description = description;
        this.NPCs = NPCs;
        this.collectables = collectables;
    }

    public void printNpcList() {
        if (NPCs.size() >= 1) {
            String toPrint = "People you see - ";
            for (NPC n : NPCs) {
                toPrint = toPrint + n.name + ", ";
            }
            System.out.println(toPrint.substring(0, toPrint.length() - 2)); // this removes last character (\n)

        }
    }

    public void printItemList() {
        if (collectables.size() >= 1) {
            String toPrint = "Items you see - ";
            for (Item i : collectables) {
                toPrint = toPrint + i.name + ", ";
            }
            System.out.println(toPrint.substring(0, toPrint.length() - 2)); // this removes last character (\n)
        }

    }

    public NPC findNpc(String npcName) {
        for (NPC n : NPCs) {
            if (npcName.compareToIgnoreCase(n.name) == 0) {
                return n;
            }
        }
        return null;

    }

    public Item removeItem(String name) {
        for (Item i : this.collectables) {
            if (name.compareToIgnoreCase(i.name) == 0) {
                collectables.remove(i);
                return i;
            }
        }
        return null;
    }

    /**
     * 
     * @param name The name of the thing we are searching for
     * @return Either the index we found or -1 if nothing was found
     */

    public int searchFloor(String name) {
        for (int i = 0; i < collectables.size(); i++) {
            if (collectables.get(i).name.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Item getFromFloor(int i) {
        if (i >= 0 && i <= collectables.size() - 1) {
            return collectables.get(i);
        } else {
            return null;
        }
    }

}