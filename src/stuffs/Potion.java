package stuffs;

import characters.Character;

public class Potion extends Stuff {
    private int life;

    public Potion(String name, int life) {
        super(name);
        this.life = life;
    }

    @Override
    public void action(Character character) {
        character.setLife(character.getLife() + this.life);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
