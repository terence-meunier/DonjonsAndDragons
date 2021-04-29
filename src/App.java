import characters.Character;
import game.Dice;
import game.GameBoard;
import menu.Menu;

public class App {
    private static Character character;
    private static Dice dice = new Dice();
    private static GameBoard gameBoard = new GameBoard();

    public static void play() {
        // Lancer le Dé
        System.out.println("Lancement du Dé");
        int diceValue = dice.throwDice();
        System.out.println("Valeur du dé : " + diceValue);

        // Calcul de la nouvelle position
        int newPositionPlayer = character.getPosition() + diceValue;

        // On place le joueur à la nouvelle position
        character.setPosition(newPositionPlayer);

        // On affiche la nouvelle position du joueur
        System.out.println("Nouvel position du joueur : " + character.getPosition());
    }

    public static void main(String[] args) {
        Menu gameMenu = new Menu();
        character = gameMenu.mainMenu();
        gameMenu.runGame(character, gameBoard, dice);
    }
}
