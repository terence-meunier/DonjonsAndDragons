package game;

// Character
import characters.Character;

public class Game {

    private Character character;
    private GameBoard gameBoard;
    private Dice dice;

    public Game() {
        this.character = null;
        this.gameBoard = new GameBoard();
        this.dice = new Dice();
    }

    public void launchRound() {
        character.move(dice.throwDice());
    }

    public Character getCharacter() {
        return character;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Dice getDice() {
        return dice;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
