package stuffs;

import game.Slot;

abstract public class Stuff extends Slot {
    private String name;

    public Stuff(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
