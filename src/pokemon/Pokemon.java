package pokemon;

class Pokemon {
    private String name;
    private int level;
    private int HP;
    private String type;

    public Pokemon(String name, String type, int HP, int level) {
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.level = level;

    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public int getHP() {
        return HP;
    }
}
