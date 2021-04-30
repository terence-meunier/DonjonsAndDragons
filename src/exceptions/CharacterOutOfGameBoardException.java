package exceptions;

public class CharacterOutOfGameBoardException extends Exception {

    public CharacterOutOfGameBoardException() {
        super("Le joueur à dépassé la case finale");
    }
}
