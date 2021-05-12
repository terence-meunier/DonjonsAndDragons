package game;

/**
 * Dice class for the throw dice
 */
public class Dice {
    private int face;

    /**
     * Constructor
     */
    public Dice() {
        this.face = 1;
    }

    /**
     * The throwDice method random a number between 1 and 6
     * @return the number between 1 and 6
     */
    public int throwDice() {
        Double randNumber = 1 + Math.random() * 5;
        this.face = randNumber.intValue();
        return this.face;
    }

    public int getFace() {
        return this.face;
    }
}
