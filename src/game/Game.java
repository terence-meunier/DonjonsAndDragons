package game;

// Character

import characters.Character;

// Menu
import characters.Ennemy;
import characters.Guerrier;
import characters.Magicien;
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

    public void throwDice() {
        System.out.println("Lancé le Dé en appuyant sur Entrée");
        input.nextLine();
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

        while (character.getPosition() < 63) {
            // On lance le Dé
            throwDice();

            // On déplace le personnage
            character.move(dice.throwDice());

            // On donne sa nouvelle position
            System.out.println("Position de " + character.getName() + " : " + character.getPosition());

            // On teste la case sur laquelle est arrivée le personnage
            if (board.get(character.getPosition()) == null) {
                // Case vide
                System.out.println("Case vide");
            } else if (board.get(character.getPosition()) instanceof Ennemy) {
                // Case ennemie un combat se lance
                System.out.println("BASSSSSTTTTOOOOOOONNNNNN!!!!!!");

                // Donne le type d'ennemie
                System.out.println("Vous attaquez : " + board.get(character.getPosition()));

                // Le personnage frappe l'ennemie
                character.fight((Ennemy) board.get(character.getPosition()));

                // On regarde le résultat de la frappe du joueur sur l'ennemie
                if (((Ennemy) board.get(character.getPosition())).getLifeLevel() <= 0) {
                    // L'ennemie est vaincue
                    System.out.println("L'ennemie est vaincue est disparé dans les abimes !!!");
                    board.set(character.getPosition(), null);
                } else {
                    // L'ennemie à survécu
                    // L'ennemie inflige des dégats au joueur
                    System.out.println("L'ennemie à survécu a votre attaque.");
                    System.out.println("Il vous s'inflige " + ((Ennemy) board.get(character.getPosition())).getStrongLevel() + " pts de dégats");
                    character.takeDamages(((Ennemy) board.get(character.getPosition())).getStrongLevel());
                    // Et il s'enfuit
                    System.out.println("Et il s'enfuit !!!");
                }

                // On teste si le personnage est vaincue
                if (character.getLifeLevel() <= 0) {
                    System.out.println("Vous êtes mort!!!");
                    character.setPosition(63);
                } else {
                    System.out.println("Vous resortez de ce combat avec " + character.getLifeLevel() + " pts de vie");
                }
            } else {
                // C'est une case bonus, on récupére le bonus
                character.drop(board.get(character.getPosition()));
            }
        }

        // Levée d'une exception si le joueur à dépassé la case finale du plateau de jeu
        if (character.getPosition() == 63) {
            if (character.getLifeLevel() <= 0) {
                System.out.println("Vous avez perdu!");
            } else {
                System.out.println("Bravo !!! Vous avez gagné");
            }
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
                    character.reset();
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
