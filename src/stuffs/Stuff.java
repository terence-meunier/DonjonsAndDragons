package stuffs;

import game.Location;

abstract public class Stuff implements Location {
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
