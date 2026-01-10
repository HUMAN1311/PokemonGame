package npc;

import java.io.Serializable;

public abstract class NPC implements Serializable {
    private static final long serialVersionUID = 4L;
    public String name;
    public String design;

    protected NPC(String name, String design) {
        this.name = name;
        this.design = design;
    }

    public abstract void interact();

    public void inspect() {
        System.out.println("This is " + name + ", " + design);

    }

    public void speak(String dialog) {
        System.out.println(this.name + ":   " + dialog);
    }

    /**
     * use this when you don't have the NPC object but you know the name and the
     * dialog
     * 
     * @param dialog
     * @param name
     */
    public static void speak(String dialog, String name) {
        System.out.println(name + ":   " + dialog);
    }

}
