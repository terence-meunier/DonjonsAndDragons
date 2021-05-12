package stuffs;

import characters.Character;

/**
 * Potion object give life to the character
 *
 * @author Meunier Terence
 * @version 1.0
 *
 * @see Stuff
 * @see Character
 */
public class Potion extends Stuff {
    private int life;

    /**
     * Constructor with two parameters name of the potion and life render
     * @param name name of the potion
     * @param life life render by the potion
     */
    public Potion(String name, int life) {
        super(name);
        this.life = life;
    }

    /**
     * Action of the potion to the character
     * @param character character who receives the potion
     */
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
