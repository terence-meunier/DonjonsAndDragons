package game;

// Character

import characters.Character;

// Menu
import characters.Ennemy;
import menu.Menu;

// Exceptions
import exceptions.CharacterOutOfGameBoardException;
import stuffs.Potion;
import stuffs.Stuff;

import java.util.List;
import java.util.Scanner;

/**
 * Classe Game qui permet de créer un objet de type Game, pour pouvoir lancer une partie
 *
 * @author Térence MEUNIER
 * @version 1.0
 */
public class Game {

    private Character character;
    private GameBoard gameBoard;
    private Dice dice;
    private Menu menu;
    private Scanner input;

    /**
     * Constructer principal qui instancie les différents objets
     *
     * @see Character
     * @see GameBoard
     * @see Dice
     * @see Menu
     * @see Scanner
     */
    public Game() {
        this.character = null;
        this.gameBoard = new GameBoard();
        this.dice = new Dice();
        this.menu = new Menu();
        this.input = new Scanner(System.in);
    }

    /**
     * Lance le jeu avec le personnage Character sélectionne dans la classe Game
     *
     * @throws CharacterOutOfGameBoardException
     * @see GameBoard
     * @see Character
     */
    public void launch() throws CharacterOutOfGameBoardException {

        List<Slot> board = gameBoard.getBoard();

        while (character.getPosition() < 64) {
            System.out.println("Position de " + character.getName() + " : " + character.getPosition());
            if (board.get(character.getPosition()) == null) {
                // Case vide
                System.out.println("Case vide");
            } else if (board.get(character.getPosition()) instanceof Ennemy) {
                // Fight
                System.out.println("BASSSSSTTTTOOOOOOONNNNNN!!!!!!");
            } else {
                // Drop item
                character.drop(board.get(character.getPosition()));
            }
            System.out.println("Lancé le Dé en appuyant sur Entrée");
            input.nextLine();
            character.move(1);
        }

        // Levée d'une exception si le joueur à dépassé la case finale du plateau de jeu

        if (character.getPosition() == 64) {
            System.out.println("Bravo !!! Vous avez gagné");
        } else {
            throw new CharacterOutOfGameBoardException();
        }
    }

    /**
     * Lance le menu principal du jeu
     *
     * @see Menu
     */
    public void runGame() {

        character = menu.mainMenu(character);

        int choice = 1;

        while (choice != 3) {
            switch (choice) {
                case 1: {
                    character.setPosition(0);
                    try {
                        launch();
                    } catch (CharacterOutOfGameBoardException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: {
                    character = menu.mainMenu(character);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Choix non valide");
                }
            }
            choice = menu.endMenu(character);
        }

        System.out.println("Fin de partie");
    }
}
