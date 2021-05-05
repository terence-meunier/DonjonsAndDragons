package menu;

import java.util.Scanner;

import characters.Character;
import characters.Warrior;
import characters.Wizard;

public class Menu {
    private Scanner input;

    public Menu() { this.input = new Scanner(System.in); }

    public String tellAnyQuestions(String question) {
        System.out.println(question);
        return input.nextLine();
    }

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

    public Character mainMenu(Character character) {
        int choice = 0;

        while (choice != 4) {
            // Afficher le menu principal
            System.out.println("----------------------");
            System.out.println("--- Menu principal ---");
            System.out.println("----------------------");
            if (character != null) {
                System.out.println("Personnage actuel : " + character.getName());
            } else {
                System.out.println("Personnage actuel : Aucun");
            }
            System.out.println("1. Créer un guerrier");
            System.out.println("2. Créer un magicien");
            System.out.println("3. Fiche personnage");
            System.out.println("4. Lancer le jeu");
            System.out.println("5. Quitter le jeu");

            choice = tellAnyQuestionsInt("Votre choix :", 1, 5);

            switch (choice) {
                case 1: {
                    String name = tellAnyQuestions("Indiquer le nom du guerrier :");
                    character = new Warrior(name);
                    System.out.println(character.getName() + " a bien été créé");
                    break;
                }
                case 2: {
                    String name = tellAnyQuestions("Indiquer le nom du magicien :");
                    character = new Wizard(name);
                    System.out.println(character.getName() + " a bien été créé");
                    break;
                }
                case 3: {
                    if (character == null) {
                        System.out.println("Vous n'avez pas encore créé de personnage");
                    } else {
                        this.subMenuCharacter(character);
                    }
                    break;
                }
                case 4: {
                    if (character != null) {
                        System.out.println("**********************************");
                        System.out.println("****** BIENVENUE DANS D&D ********");
                        System.out.println("**********************************");
                    } else {
                        choice = 0;
                        System.out.println("Merci de créer un personnage avant de lancer le jeu");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Fin du jeu");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Choix non valide");
                }
            }
        }
        return character;
    }

    public void subMenuCharacter(Character character) {
        int choice = 0;

        while (choice != 3) {
            // Afficher le menu principal
            System.out.println("-----------------------");
            System.out.println("--- Menu personnage ---");
            System.out.println("-----------------------");
            System.out.println("1. Voir les stats");
            System.out.println("2. Modifier les stats");
            System.out.println("3. Retour menu principal");
            System.out.println("4. Quitter le jeu");

            choice = tellAnyQuestionsInt("Votre choix :", 1, 4);

            switch (choice) {
                case 1: {
                    System.out.println(character);
                    break;
                }
                case 2: {
                    this.setStatsCharacter(character);
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    System.out.println("Fin du jeu");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Choix non valide");
                }
            }
        }
    }

    public void setStatsCharacter(Character character) {
        int choice = 0;

        while (choice != 4) {
            System.out.println("------------------------------");
            System.out.println("--- Modification des stats ---");
            System.out.println("------------------------------");
            System.out.println();
            System.out.println("1. Modifier le nom");
            System.out.println("2. Modifier les points de vie");
            System.out.println("3. Modifier le niveau d'attaque");
            System.out.println("4. Retour");
            System.out.println("5. Quitter le jeu");

            choice = tellAnyQuestionsInt("Votre choix :", 1, 5);

            switch (choice) {
                case 1: {
                    System.out.println("Donner le nouveau nom :");
                    character.setName(input.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Donner les nouveaux points de vie :");
                    character.setLife(input.nextInt());
                    input.nextLine();
                    break;
                }
                case 3: {
                    System.out.println("Donner les nouveaux points d'attaque :");
                    character.setAtk(input.nextInt());
                    input.nextLine();
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    System.out.println("Fin du jeu");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Choix non valide");
                }
            }
        }
    }

    public int endMenu(Character character) {
        System.out.println("1. Refaire un partie avec " + character.getName());
        System.out.println("2. Retour au menu principal");
        System.out.println("3. Quitter le jeu");
        int choice = tellAnyQuestionsInt("Votre choix :", 1, 3);
        return choice;
    }
}
