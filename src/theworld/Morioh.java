package theworld;

import npc.*;
import quests.CollectHat;
import items.*;

import java.util.ArrayList;

public class Morioh extends QuestLockedLocation {
    public Morioh() {
        super("Morioh", "A small town, the sky looks rather yellow.", generateMoriohNpcs(), generateMoriohItems(),
                CollectHat.NAME);
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
        morioh_Items.add(new BlueBall());

        return morioh_Items;
    }

}