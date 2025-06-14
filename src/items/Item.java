package items;

public class Item {
    public String name;
    public String description;
    public int value;

    public Item(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public void inspect() {
        System.out.println(description);
    }
}
