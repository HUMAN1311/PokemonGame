package theworld;

import java.util.ArrayList;

import game.Game;
import items.Item;
import npc.NPC;

public class QuestLockedLocation extends Location {
    String questName;

    public QuestLockedLocation(String name, String description, ArrayList<NPC> NPCs, ArrayList<Item> collectables,
            String questname) {
        super(name, description, NPCs, collectables);
        this.questName = questname;
    }

    @Override
    public boolean travel() { // When trying to travel, check if quest needed is completed
        if (Game.getInstance().getPlayer().checkQuestCompletion(this.questName)) {
            Game.getInstance().setCurrentLocation(this);
            return true;
        }
        System.out.println("You cannot travel here yet.");
        return false;
    }
}
