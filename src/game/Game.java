package game;

// Character
import characters.Character;

// Menu
import characters.Ennemy;
import menu.Menu;

// Exceptions
import exceptions.CharacterOutOfGameBoardException;

// Scanner
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
     * Tell a question for int between minRange and maxRange
     * @param question
     * @param minRange
     * @param maxRange
     * @return
     */
    public int tellAnyQuestionsInt(String question, int minRange, int maxRange) {
        System.out.println(question);
        int answer = input.nextInt();
        input.nextLine();
        if (answer >= minRange && answer <= maxRange) {
            return answer;
        }
        System.out.println("Le choix doit être entre compris entre " + minRange + " et " + maxRange);
        return tellAnyQuestionsInt(question, minRange, maxRange);
    }

    /**
     * throwDice just stop the program and wait user action
     */
    public void throwDice() {
        System.out.println("Lancé le Dé en appuyant sur Entrée");
        input.nextLine();
    }

    /**
     * method fight for fight action between character and ennemies
     */
    public void fight() {
        // ennemy info
        System.out.println("Vous attaquez : " + gameBoard.getBoard().get(character.getPosition()));

        // Player Fight ennemy
        character.fight((Ennemy) gameBoard.getBoard().get(character.getPosition()));

        // On regarde le résultat de la frappe du joueur sur l'ennemie
        if (((Ennemy) gameBoard.getBoard().get(character.getPosition())).getLifeLevel() <= 0) {
            // L'ennemie est vaincue
            System.out.println("L'ennemie est vaincue est disparé dans les abimes !!!");
            gameBoard.getBoard().set(character.getPosition(), null);
        } else {
            // L'ennemie à survécu
            // L'ennemie inflige des dégats au joueur
            System.out.println("L'ennemie à survécu a votre attaque.");
            System.out.println("Il vous s'inflige " + ((Ennemy) gameBoard.getBoard().get(character.getPosition())).getStrongLevel() + " pts de dégats");
            character.takeDamages(((Ennemy) gameBoard.getBoard().get(character.getPosition())).getStrongLevel());

            // On teste si le personnage est vaincue
            if (character.getLifeLevel() <= 0) {
                System.out.println("Vous êtes mort!!!");
                character.setPosition(63);
            } else {
                System.out.println("Vous resortez de ce combat avec " + character.getLifeLevel() + " pts de vie");
                int choice = tellAnyQuestionsInt("Voulez vous continuez (1: Oui / 2: Non) : ", 1, 2);
                switch (choice) {
                    case 1: {
                        fight();
                        break;
                    }
                    case 2: {
                        returnBack();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Return back position of between 1 to 6 cases
     */
    public void returnBack() {
        int nbCases = dice.throwDice();
        character.move(-nbCases);
        if (character.getPosition() < 0) {
            character.setPosition(0);
        }
        System.out.println(character.getName() + " retourne à la case : " + character.getPosition());
    }

    /**
     * Check the position of the character on the gameboard for understand the position element (ennemies, bonus or empty case)
     */
    public void checkPosition() {
        // Test ce qui se trouve dans la case
        if (gameBoard.getBoard().get(character.getPosition()) == null) {
            // Case vide, on ne fait rien
            System.out.println("Case vide");
        } else if (gameBoard.getBoard().get(character.getPosition()) instanceof Ennemy) {
            // Case ennemie, on lance un combat
            System.out.println("BASSSSSTTTTOOOOOOONNNNNN!!!!!!");
            fight();
        } else {
            // Case bonus, on récupère le bonus
            character.drop(gameBoard.getBoard().get(character.getPosition()));
        }
    }

    /**
     * Check if the character life points and position
     *
     * @throws CharacterOutOfGameBoardException
     */
    public void checkInLive() throws CharacterOutOfGameBoardException {
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
     * Lance le jeu avec le personnage Character sélectionne dans la classe Game
     *
     * @throws CharacterOutOfGameBoardException
     * @see GameBoard
     * @see Character
     */
    public void launch() throws CharacterOutOfGameBoardException {

        // Tantque l'on a pas passé la dernière position du plateau
        while (character.getPosition() < 63) {
            // On lance le Dé
            throwDice();
            // On déplace le personnage
            character.move(dice.throwDice());
            // On donne sa nouvelle position
            System.out.println("Position de " + character.getName() + " : " + character.getPosition());
            // On test se qui se trouve dans la case
            checkPosition();
        }

        // Verifie si le joueur est toujours en vie
        checkInLive();
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
