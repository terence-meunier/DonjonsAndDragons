package game;

// Character
import characters.Character;

// Menu
import menu.Menu;

// Exceptions
import exceptions.CharacterOutOfGameBoardException;

import java.util.List;
import java.util.Scanner;

public class Game {

    private Character character;
    private GameBoard gameBoard;
    private Dice dice;
    private Menu menu;
    private Scanner input;

    public Game() {
        this.character = null;
        this.gameBoard = new GameBoard();
        this.dice = new Dice();
        this.menu = new Menu();
        this.input = new Scanner(System.in);
    }

    public void launch() {

        List<Object> board = gameBoard.getBoard();

        while (character.getPosition() < 64) {
            System.out.println("Position de " + character.getName() + " : " + character.getPosition());

            if (board.get(character.getPosition()) == null) {
                System.out.println("Case vide à cette position");
            } else if (board.get(character.getPosition()).getClass() == stuffs.Potion.class) {
                System.out.println("C'est du sutffs");
            } else if (board.get(character.getPosition()).getClass() == characters.Ennemy.class) {
                System.out.println("C'est un ennemie");
            } else if (board.get(character.getPosition()).getClass() == stuffs.Weapon.class) {
                System.out.println("C'est une arme");
            } else if (board.get(character.getPosition()).getClass() == stuffs.Spell.class) {
                System.out.println("C'est un sort");
            }

            System.out.println("Lancé le Dé en appuyant sur Entrée");
            input.nextLine();
            character.setPosition(character.getPosition() + dice.throwDice());
        }

        // Levée d'une exception si le joueur à dépassé la case finale du plateau de jeu
        try {
            if (character.getPosition() == 64) {
                System.out.println("Bravo !!! Vous avez gagné");
            } else {
                throw new CharacterOutOfGameBoardException();
            }
        } catch (CharacterOutOfGameBoardException e) {
            e.printStackTrace();
        }
    }

    public void runGame() {

        character = menu.mainMenu(character);

        int choice = 1;

        while (choice != 3) {
            switch (choice) {
                case 1: {
                    character.setPosition(0);
                    launch();
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
