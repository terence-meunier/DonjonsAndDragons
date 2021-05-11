package stuffs;

import characters.Character;
import game.Location;

abstract public class Stuff implements Location {
    private String name;

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
