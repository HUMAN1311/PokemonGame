package npc;

public class DialogNPC extends NPC {
    public String dialog;

    public DialogNPC(String dialog, String name, String design) {
        super(name, design);
        this.dialog = dialog;
    }

    @Override
    public void interact() {
        System.out.println(name + ":    " + dialog);
    }

}
