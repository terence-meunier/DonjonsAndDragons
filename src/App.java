import characters.Character;
import game.GameBoard;
import menu.Menu;

public class App {
    private static Character character;

    public static void main(String[] args) {
        Menu gameMenu = new Menu();
        character = gameMenu.mainMenu();
        GameBoard gameBoard = new GameBoard();
        System.out.println(gameBoard.getBoard());
        System.out.println("Personnage " + character.getName() + " sur la case " + character.getPosition());
        // Lancer le Dé
        // Modifier la position du perso
        // Verifier la case sur laquelle on est tombée
    }
}
