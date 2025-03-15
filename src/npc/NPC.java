package npc;

public class NPC {
    public String name;
    public String design;

    public NPC(String name, String design) {
        this.name = name;
        this.design = design;
    }

    public void interact() {
        System.out.println("This is " + name + ", " + design);

    }

    public void inspect() {
        System.out.println("This is " + name + ", " + design);

    }
}
