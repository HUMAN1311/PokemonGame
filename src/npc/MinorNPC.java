package npc;

public class MinorNPC extends NPC {
    public String dialog;

    public MinorNPC(String dialog, String name, String design) {
        super(name, design);
        this.dialog = dialog;
    }

    @Override
    public void interact() {
        System.out.println(name + ": " + dialog);
    }

}
