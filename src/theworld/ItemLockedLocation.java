package theworld;

import java.util.ArrayList;

import game.Game;
import items.Item;
import npc.NPC;

public class ItemLockedLocation extends Location {
    String itemName;

    public ItemLockedLocation(String name, String description, ArrayList<NPC> NPCs, ArrayList<Item> collectables,
            String itemname) {
        super(name, description, NPCs, collectables);
        this.itemName = itemname;
    }

    @Override
    public boolean travel() { // When trying to travel, check if item needed is completed
        if (Game.getInstance().getPlayer().searchBag(this.itemName) != -1) {
            Game.getInstance().setCurrentLocation(this);
            return true;
        }
        System.out.println("You cannot travel here yet.");
        return false;
    }
}
