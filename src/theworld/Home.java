package theworld;

import java.util.ArrayList;

import npc.Mum;
import npc.NPC;
import npc.Patrat;
import items.Item;
import items.Hat;

public class Home extends Location {
    public Home() {

        super("Home", "This is your house, you live here.", generateHouseNpcs(), generateHouseItems());

    }

    public static ArrayList<NPC> generateHouseNpcs() {
        ArrayList<NPC> house_NPCs = new ArrayList<NPC>();
        house_NPCs.add(new Mum());
        house_NPCs.add(new Patrat());
        return house_NPCs;
    }

    public static ArrayList<Item> generateHouseItems() {
        ArrayList<Item> house_items = new ArrayList<Item>();
        house_items.add(new Hat());
        return house_items;
    }

}
