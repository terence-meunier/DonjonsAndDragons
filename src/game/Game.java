package game;

import characters.Character;

/**
 *
 * Game class for the control of the game
 *
 * @author Meunier Terence
 * @version 1.0
 */
public class Game {

    private Character character;
    private GameBoard gameBoard;
    private Dice dice;

    /**
     * Constructor includes a character, a gameboard and a dice
     */
    public Game() {
        this.character = null;
        this.gameBoard = new GameBoard();
        this.dice = new Dice();
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
