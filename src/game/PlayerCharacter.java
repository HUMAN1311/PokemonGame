package game;

import java.util.ArrayList;

import items.Item;
import quests.Quest;

public class PlayerCharacter {
    public String name;
    public String gender;
    public String hairColour;
    private ArrayList<Item> bag;
    private ArrayList<Quest> questList;
    private ArrayList<Quest> completedQuestList;

    public PlayerCharacter(String name, String gender, String hairColour) {
        this.name = name;
        this.gender = gender;
        this.hairColour = hairColour;
        this.bag = new ArrayList<Item>();
        this.questList = new ArrayList<Quest>();
        this.completedQuestList = new ArrayList<Quest>();

    }

    public void addToBag(Item toAdd) {
        bag.add(toAdd);
    }

    public void printBag() {
        String toPrint = "You are carrying - ";
        for (Item i : bag) {
            toPrint = toPrint + i.name + ", ";
        }
        System.out.println(toPrint.substring(0, toPrint.length() - 2)); // this removes last character (\n)
    }

    public int searchBag(String itemName) {
        for (int i = 0; i < bag.size(); i++) {
            if (bag.get(i).name == itemName) {
                return i;
            }
        }
        return -1;
    }

    public void addQuest(Quest quest) {
        // this for loop prevents duplicate quests
        for (Quest q : questList) {
            if (q.name == quest.name) {
                return;
            }
        }
        // this for loop prevents completing the same quest multiple time
        for (Quest q : completedQuestList) {
            if (q.name == quest.name) {
                return;
            }
        }
        questList.add(quest);
    }

    public void checkQuests() {
        ArrayList<Quest> toRemove = new ArrayList<Quest>();
        for (Quest q : questList) {
            boolean questComplete = q.isComplete(this);
            if (questComplete) {
                completedQuestList.add(q);
                toRemove.add(q);
            }
        }
        for (Quest q : toRemove) {
            questList.remove(q);
        }
    }

    public void printQuests() {
        String toPrint = "Your quests are: \n";
        for (Quest q : questList) {
            toPrint = toPrint + "   " + q.name + ": " + q.description + "\n";
        }
        System.out.println(toPrint.substring(0, toPrint.length() - 1)); // this removes last character (\n)
    }

}
