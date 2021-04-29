package game;

public class Dice {
    private int face;

    public Dice() {
        this.face = 1;
    }

    public int throwDice() {
        Double randNumber = Math.random()*6;
        this.face = randNumber.intValue();
        return this.face;
    }

    public int getFace() {
        return this.face;
    }
}
