package game;

public class Dice {
    private int face;

    public Dice() {
        this.face = 1;
    }

    public int throwDice() {
        Double randNumber = 1 + Math.random() * 5;
        this.face = randNumber.intValue();
        return this.face;
    }

    public int getFace() {
        return this.face;
    }
}
