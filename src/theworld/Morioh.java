package theworld;

import npc.*;
import items.*;

import java.util.ArrayList;

public class Morioh extends Location {
    public Morioh() {
        super("Morioh", "A small town, the sky looks rather yellow.", generateMoriohNpcs(), generateMoriohItems());
    }

    public static ArrayList<NPC> generateMoriohNpcs() {
        ArrayList<NPC> morioh_NPCs = new ArrayList<NPC>();
        morioh_NPCs.add(new Rohan());
        morioh_NPCs.add(new Skitty());

        return morioh_NPCs;
    }

    public static ArrayList<Item> generateMoriohItems() {
        ArrayList<Item> morioh_Items = new ArrayList<Item>();
        morioh_Items.add(new MouldyApple());

        return morioh_Items;
    }

}