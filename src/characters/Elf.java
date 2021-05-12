package characters;

/**
 *
 * Elf class character inherit of Character class
 *
 * @see Character
 *
 * @author Térence MEUNIER
 * @version 1.0
 */
public class Elf extends Character {

    /**
     * Empty constructor
     */
    public Elf() { this(null); }

    /**
     * Constructor with one parameter
     * @param name name of the Elf
     */
    public Elf(String name) {
        this(name, 4, 7);
    }

    /**
     * Constructor with three parameters
     * @param name name of the Elf
     * @param lifeLevel life level for the Elf
     * @param strongLevel atq level for the Elf
     */
    public Elf(String name, int lifeLevel, int strongLevel) {
        super(name, lifeLevel, strongLevel);
    }

}
