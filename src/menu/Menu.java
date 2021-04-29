package menu;

import characters.Character;
import characters.Guerrier;
import characters.Magicien;
import game.Dice;
import game.GameBoard;
import java.util.Scanner;

public class Menu {
    private static Scanner input = new Scanner(System.in);
    private GameBoard gameBoard;
    private Dice de;
    private Character character;

    public Menu() {
        this.gameBoard = new GameBoard();
        this.de = new Dice();
        this.character = null;
    }

    private void mainMenu() {
        int choice = 0;

        while (choice != 4) {
            // Afficher le menu principal
            System.out.println("----------------------");
            System.out.println("--- Menu principal ---");
            System.out.println("----------------------");
            System.out.println();
            System.out.println("1. Créer un guerrier");
            System.out.println("2. Créer un magicien");
            System.out.println("3. Fiche personnage");
            System.out.println("4. Quitter le jeu");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    character = new Guerrier("Conan le barbare");
                    break;
                }
                case 2: {
                    character = new Magicien("Gandalf le blanc");
                    break;
                }
                case 3: {
                    if (character == null) {
                        System.out.println("Vous n'avez pas encore créé de personnage");
                    } else {
                        this.subMenuCharacter();
                    }
                    break;
                }
                case 4: {
                    System.out.println("Fin du jeu");
                    break;
                }
                default: {
                    System.out.println("Choix non valide");
                }
            }
        }
    }

    public void subMenuCharacter() {
        System.out.println(character);
    }

    public void runGame() {
        this.mainMenu();
    }
}