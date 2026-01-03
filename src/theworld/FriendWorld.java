package theworld;

import java.util.ArrayList;

import items.TapedPaper;
import items.Item;
import npc.Hayato;
import npc.NPC;

public class FriendWorld extends Location {

    public FriendWorld() {
        super("FriendWorld", "There's a lot of strange buildings and rides, they all seem to have a strange eye",
                generateFriendWorldNpcs(), generateFriendWorldItems());
    }

    private static ArrayList<NPC> generateFriendWorldNpcs() {
        ArrayList<NPC> friendWorld_NPCs = new ArrayList<NPC>();
        friendWorld_NPCs.add(new Hayato());
        // friendWorld_NPCs.add(new Yoshitsune());
        // friendWorld_NPCs.add(new Takasu());
        return friendWorld_NPCs;
    }

    private static ArrayList<Item> generateFriendWorldItems() {
        ArrayList<Item> friendWorld_items = new ArrayList<Item>();
        friendWorld_items.add(new TapedPaper());
        // friendWorld_items.add(new SongLyrics());
        return friendWorld_items;
    }

}
