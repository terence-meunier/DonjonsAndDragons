package menu;

import java.util.Map;
import java.util.Scanner;

import characters.Character;
import characters.Ennemy;
import characters.Warrior;
import characters.Wizard;
import game.Game;
import stuffs.Stuff;

/**
 * Menu class control the interface with the user
 *
 * Implements ContractMenu interface
 *
 * @author Meunier Terence
 * @version 1.0
 * @see ContractMenu
 */
public class Menu implements ContractMenu {
    private Scanner input;
    private Game game;

    public Menu() {
        this.input = new Scanner(System.in);
        this.game = new Game();
    }

    /**
     * Tell a Question to the user
     * @param question
     * @return
     */
    private String tellAnyQuestion(String question) {
        System.out.println(question);
        return input.nextLine();
    }

    /**
     * Tell a Question to the user with number choices between minRange and maxRange
     * @param question
     * @param minRange
     * @param maxRange
     * @return
     */
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

    /**
     * Main menu for create, update and launch the game
     */
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
        System.out.println("1. Choisir un joueur");
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
                    System.out.println("Merci de choisir un personnage !");
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

    /**
     * Create Character Menu for create character and choice the type and name of character
     */
    public void createCharacterMenu() {

        // Affichage des personnages disponibles
        System.out.println("-------------------------------");
        System.out.println("--- Personnages disponibles ---");
        System.out.println("-------------------------------");

        // Appel à la base de données
        Map<Integer, Character> charactersList = game.getHeroes();
        for (Map.Entry<Integer, Character> entry :charactersList.entrySet()) {
            System.out.println("---------------------------");
            System.out.println("Choix n°" + entry.getKey());
            System.out.println(entry.getValue());
        }

        int choice = tellAnyQuestionInt("Donner votre choix :", 1, charactersList.size());
        game.setCharacter(charactersList.get(choice));
    }

    /**
     * Update character menu for set name, life points
     */
    public void updateCharacterMenu() {
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

    /**
     * Play menu for round by round
     */
    public void playMenu() {
        System.out.println();
        System.out.println("*************************************");
        System.out.println("************* Nouveau tour **********");
        System.out.println("*************************************");
        System.out.println();
        // On lance le dé
        tellAnyQuestion("Lancer le dé en appuyant sur Entrée");
        game.getCharacter().move(game.getDice().throwDice());
        System.out.println("Position de " + game.getCharacter().getName() + " : case " + game.getCharacter().getPosition());

        // On verifie ce qui est présent sur la case que l'on a atteint
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

    /**
     * Replay menu for continue the game or stop the game
     * @return
     */
    private boolean replay() {
        int choice = tellAnyQuestionInt("Voulez vous refaire une partie (1: Oui / 2: Non) ?", 1, 2);
        if (choice == 1) {
           game.getCharacter().reset();
           return true;
        }
        return false;
    }

    /**
     * Check the player position for interaction with the gameboard case.
     */
    private void checkPosition() {
        if (game.getGameBoard().getBoard().get(game.getCharacter().getPosition()) == null) {
            System.out.println("Case vide");
        }

        if (game.getGameBoard().getBoard().get(game.getCharacter().getPosition()) instanceof Stuff) {
            System.out.println("Vous récupérez : " + game.getGameBoard().getBoard().get(game.getCharacter().getPosition()));
            ((Stuff) game.getGameBoard().getBoard().get(game.getCharacter().getPosition())).action(game.getCharacter());
            System.out.println("Stats personnage : " + game.getCharacter());
        }

        if (game.getGameBoard().getBoard().get(game.getCharacter().getPosition()) instanceof Ennemy) {
            System.out.println("Vous rencontrez : " + game.getGameBoard().getBoard().get(game.getCharacter().getPosition()));
            if (((Ennemy) game.getGameBoard().getBoard().get(game.getCharacter().getPosition())).getName().equals("Orc")) {
                if (game.getCharacter() instanceof Warrior) {
                    fight();
                } else {
                    System.out.println("Les Orcs ne s'attaquent pas aux magiciens");
                }
            } else if (((Ennemy) game.getGameBoard().getBoard().get(game.getCharacter().getPosition())).getName().equals("Bad spirit")) {
                if (game.getCharacter() instanceof Wizard) {
                    fight();
                } else {
                    System.out.println("Les mauvais esprits n'ont pas d'effets sur les guerriers");
                }
            } else {
                fight();
            }
            System.out.println();
            System.out.println("*****************************************");
            System.out.println("*****************************************");
            System.out.println();
            System.out.println();
            System.out.println("Stats personnage : " + game.getCharacter());
            System.out.println();
            System.out.println();
            System.out.println("*****************************************");
            System.out.println("*****************************************");
        }
    }

    /**
     * Fight menu for the round by round fight with the ennemy
     */
    private void fight() {
        // On frappe l'ennemie
        System.out.println("Vous frappez l'ennemie");
        game.getCharacter().fight((Ennemy) game.getGameBoard().getBoard().get(game.getCharacter().getPosition()));

        // On teste si l'ennemie à survécu
        if (((Ennemy) game.getGameBoard().getBoard().get(game.getCharacter().getPosition())).isAlive()) {
            // Si l'ennemie survie il frappe le personnage puis s'enfuit
            System.out.println("L'ennemie à survécu");
            System.out.println("L'ennemie vous frappe");
            ((Ennemy) game.getGameBoard().getBoard().get(game.getCharacter().getPosition())).fight(game.getCharacter());

            // On teste si l'on a survécu au combat
            if (game.getCharacter().isAlive()) {
                System.out.println("Il vous reste : " + game.getCharacter().getLife() + " pts de vie");
                int choice = tellAnyQuestionInt("Voulez vous continuer le combat (1: Oui / 2: Non) ?", 1, 2);
                switch (choice) {
                    case 1: {
                        fight();
                        break;
                    }
                    case 2: {
                        System.out.println("Vous prenez la fuite...");
                        game.getCharacter().escape(game.getDice().throwDice());
                        System.out.println("Retour en case : " + game.getCharacter().getPosition());
                        checkPosition();
                        break;
                    }
                }
            } else {
                game.getCharacter().setPosition(63);
            }
        } else {
            // Sinon il disparait du plateau de jeu
            System.out.println("L'ennemie est mort");
            game.getGameBoard().getBoard().set(game.getCharacter().getPosition(), null);
        }
    }

    public Scanner getInput() {
        return input;
    }

    public Game getGame() {
        return game;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
