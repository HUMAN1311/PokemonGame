package theworld;

import npc.*;
import items.*;

import java.util.ArrayList;

public class Shop extends Location {
    public Shop() {

        super("Shop", "It's a little shop", generateShopNpcs(), generateShopCollectables());
    }

    private static ArrayList<NPC> generateShopNpcs() {
        ArrayList<NPC> NPCs = new ArrayList<NPC>();
        NPCs.add(new Saitama());
        return NPCs; // and cube in our hearts 🫀
    }

    private static ArrayList<Item> generateShopCollectables() {
        ArrayList<Item> collectables = new ArrayList<Item>();
        collectables.add(new MouldyApple());
        collectables.add(new Sandwich());
        return collectables; // and cube in our hearts 🫀
    }
}
