package npc;

import game.Game;
import quests.CollectTapedPaper;
import quests.CollectButton;

public class Hayato extends DialogNPC {

    public Hayato() {
        super("Have you seen Rohan? we need help finding kira, let me know if you find a piece of paper with tape on it.",
                "Hayato", "A young boy, assumed to be the son of Yoshikage Kira.");
    }

    @Override // check if button quest is complete
    public void interact() {
        System.out.println(name + ":    " + dialog);
        if (Game.getInstance().getPlayer().checkQuestCompletion(CollectButton.NAME))
            Game.getInstance().getPlayer().addQuest(new CollectTapedPaper());
    }
}
