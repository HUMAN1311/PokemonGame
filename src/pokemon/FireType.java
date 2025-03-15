package pokemon;
public class FireType extends Pokemon {
    public int burnChance;

    public FireType(int burnChance, String name, int HP, int level) {
        super(name, "fire", HP, level);
        this.burnChance = burnChance;

     }

}
