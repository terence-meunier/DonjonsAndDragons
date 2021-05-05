package stuffs;

public class Potion extends Stuff {
    private int life;

    public Potion(String name, int life) {
        super(name);
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
