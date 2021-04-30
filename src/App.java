import characters.Character;
import game.Dice;
import game.GameBoard;
import menu.Menu;

public class App {
    private static Character character = null;
    private static Dice dice = new Dice();
    private static GameBoard gameBoard = new GameBoard();

    public static void main(String[] args) {
        Menu gameMenu = new Menu();
        character = gameMenu.mainMenu(character);
        gameMenu.runGame(character, gameBoard, dice);
    }
}
