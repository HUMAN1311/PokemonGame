package npc;

import game.Game;
import items.BlueBall;

public class Skitty extends DialogNPC {
    public Skitty() {
        super("Skitty queen, daisan no bakudan, bite za dusto", "Skitty", "A pink cat, it has a metal, blue ball");
    }

    @Override
    public void interact() {
        if (Game.getInstance().getPlayer().searchBag(BlueBall.NAME) != -1) {
            this.speak("Shibobobobobobobobobobobo");
        } else {
            this.speak(dialog);
        }
    }

}