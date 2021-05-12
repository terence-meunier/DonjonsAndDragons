package exceptions;

/**
 * If the character out of position to the end game board
 *
 * @author Meunier Terence
 * @version 1.0
 *
 * @see Exception
 */
public class CharacterOutOfGameBoardException extends Exception {
    /**
     * Constructor exception with the exception message
     */
    public CharacterOutOfGameBoardException() {
        super("Le joueur à dépassé la case finale");
    }
}
