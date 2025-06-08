package theworld;

import npc.*;
import items.*;

import java.util.ArrayList;

public class Shibuya extends Location {
    public Shibuya() {
        super("Shibuya", "A city, its mostly destroyed", generateShibuyaNpcs(), generateShibuyaItems());
    }

    public static ArrayList<NPC> generateShibuyaNpcs() {
        ArrayList<NPC> Shibuya_NPCs = new ArrayList<NPC>();
        Shibuya_NPCs.add(new Geto());
        Shibuya_NPCs.add(new Cube());

        return Shibuya_NPCs;
    }

    public static ArrayList<Item> generateShibuyaItems() {
        ArrayList<Item> Shibuya_Items = new ArrayList<Item>();
        Shibuya_Items.add(new StrangeButton());

        return Shibuya_Items;
    }

}