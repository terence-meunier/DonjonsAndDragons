package stuffs;

public class Potion extends Stuff {
    private int lifePoints;

    public Potion(String name, int lifePoints) {
        super(name);
        this.lifePoints = lifePoints;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
