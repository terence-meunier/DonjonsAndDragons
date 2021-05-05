package menu;

import java.util.Scanner;

import characters.Ennemy;
import characters.Warrior;
import characters.Wizard;
import game.Game;
import stuffs.Stuff;

public class Menu {
    private Scanner input;
    private Game game;

    public Menu() {
        this.input = new Scanner(System.in);
        this.game = new Game();
    }

    private String tellAnyQuestion(String question) {
        System.out.println(question);
        return input.nextLine();
    }

    private int tellAnyQuestionInt(String question, int minRange, int maxRange) {
        System.out.println(question);
        try {
            int answer = input.nextInt();
            input.nextLine();
            if (answer >= minRange && answer <= maxRange) {
                return answer;
            }
        } catch (Exception e) {
            input.nextLine();
            System.out.println("Le choix doit être un entier");
            return tellAnyQuestionInt(question, minRange, maxRange);
        }
        System.out.println("Le choix doit être entre compris entre " + minRange + " et " + maxRange);
        return tellAnyQuestionInt(question, minRange, maxRange);
    }

    public void mainMenu() {

        // Afficher le menu principal
        System.out.println("----------------------");
        System.out.println("--- Menu principal ---");
        System.out.println("----------------------");
        if (game.getCharacter() != null) {
            System.out.println("Personnage actuel : " + game.getCharacter().getName());
        } else {
            System.out.println("Personnage actuel : Aucun");
        }
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Modifier le personnage actuel");
        System.out.println("3. Lancer le jeu");
        System.out.println("4. Quitter le jeu");

        int choice = tellAnyQuestionInt("Votre choix :", 1, 4);

        switch (choice) {
            case 1: {
                createCharacterMenu();
                mainMenu();
                break;
            }
            case 2: {
                if (game.getCharacter() == null) {
                    System.out.println("Merci de créer un personnage !");
                    createCharacterMenu();
                } else {
                    updateCharacterMenu();
                }
                mainMenu();
                break;
            }
            case 3: {
                if (game.getCharacter() == null) {
                    System.out.println("Merci de créer un personnage pour jouer !!!");
                    createCharacterMenu();
                }
                playMenu();
                mainMenu();
                break;
            }
            case 4: {
                System.out.println("Fin du jeu");
                break;
            }
        }
    }

    private void createCharacterMenu() {
        // Afficher le menu principal
        System.out.println("-----------------------");
        System.out.println("--- Create personnage ---");
        System.out.println("-----------------------");
        System.out.println("1. Créer un guerrier");
        System.out.println("2. Créer un magicien");
        System.out.println("3. Retour vers le menu principal");

        int choice = tellAnyQuestionInt("Votre choix :", 1, 3);

        switch (choice) {
            case 1: {
                game.setCharacter(new Warrior(tellAnyQuestion("Quel est le nom du Guerrier ?")));
                break;
            }
            case 2: {
                game.setCharacter(new Wizard(tellAnyQuestion("Quel est le nom du Magicien ?")));
                break;
            }
            case 3: {
                break;
            }
        }
    }

    private void updateCharacterMenu() {
        System.out.println("------------------------------");
        System.out.println("--- Update personnage ---");
        System.out.println("------------------------------");
        System.out.println("Stats actuel :");
        System.out.println(game.getCharacter());
        System.out.println();
        System.out.println("1. Modifier le nom");
        System.out.println("2. Modifier les points de vie");
        System.out.println("3. Retour menu principal");

        int choice = tellAnyQuestionInt("Votre choix :", 1, 3);

        switch (choice) {
            case 1: {
                game.getCharacter().setName(tellAnyQuestion("Donner le nouveau nom : "));
                updateCharacterMenu();
                break;
            }
            case 2: {
                if (game.getCharacter() instanceof Warrior) {
                    game.getCharacter().setLife(tellAnyQuestionInt("Donner la vie souhaité (entre 5 et 10) : ", 5, 10));
                }

                if (game.getCharacter() instanceof Wizard) {
                    game.getCharacter().setLife(tellAnyQuestionInt("Donner la vie souhaité (entre 3 et 8) : ", 3, 8));
                }
                updateCharacterMenu();
                break;
            }
            case 3: {
                break;
            }
        }
    }

    public void playMenu() {
        tellAnyQuestion("Lancer le dé en appuyant sur Entrée");
        game.launchRound();
        System.out.println("Position de " + game.getCharacter().getName() + " : case " + game.getCharacter().getPosition());

        checkPosition();

        if (game.getCharacter().getPosition() == 63) {
            if (game.getCharacter().isAlive()) {
                System.out.println("Bravo, vous avez gagné !!!");
            } else {
                System.out.println("Vous êtes mort, vous avez perdu !!!");
            }
            if (replay()) {
                playMenu();
            }
        } else {
            playMenu();
        }
    }

    public boolean replay() {
        int choice = tellAnyQuestionInt("Voulez vous refaire une partie (1: Oui / 2: Non) ?", 1, 2);
        switch (choice) {
            case 1: {
                game.getCharacter().reset();
                return true;
            }
        }
        return false;
    }

    private void checkPosition() {
        if(game.getGameBoard().getBoard().get(game.getCharacter().getPosition()) == null) {
            System.out.println("Case vide");
        }

        if(game.getGameBoard().getBoard().get(game.getCharacter().getPosition()) instanceof Stuff) {
            game.getCharacter().dropItem(game.getGameBoard().getBoard().get(game.getCharacter().getPosition()));
        }

        if(game.getGameBoard().getBoard().get(game.getCharacter().getPosition()) instanceof Ennemy) {
            fight();
        }
    }

    private void fight() {

    }
}
