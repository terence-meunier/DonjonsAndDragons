package characters;

import game.Location;

public class Elf extends Character {

    public Elf() { this(null); }

    public Elf(String name) {
        this(name, 4, 7);
    }

    /**
     * @param name        String
     *                    Le nom du personnage
     * @param lifeLevel   int
     *                    Les points de vie du personnage
     * @param strongLevel int
     */
    public Elf(String name, int lifeLevel, int strongLevel) {
        super(name, lifeLevel, strongLevel);
    }

}
