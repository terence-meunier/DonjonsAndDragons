package stuffs;

import characters.Character;
import game.Location;

/**
 * Abstract class Stuff for the stuffs objects (Weapons, Spells, Potions, etc...)
 *
 * @author Meunier Terence
 * @version 1.0
 *
 * @see Weapon
 * @see Spell
 * @see Potion
 */
abstract public class Stuff implements Location {
    private String name;

    /**
     * Constructor with the name of the stuff
     * @param name name of the potion
     */
    public Stuff(String name) {
        this.name = name;
    }

    public abstract void action(Character character);

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
