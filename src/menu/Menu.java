package menu;

import java.util.Scanner;

import characters.Character;
import characters.Guerrier;
import characters.Magicien;

import game.Dice;
import game.GameBoard;

public class Menu {
    private static Scanner input = new Scanner(System.in);

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

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Indiquer le nom du guerrier :");
                    String name = input.nextLine();
                    character = new Guerrier(name);
                    System.out.println(character.getName() + " a bien été créé");
                    break;
                }
                case 2: {
                    System.out.println("Indiquer le nom du guerrier :");
                    String name = input.nextLine();
                    character = new Magicien(name);
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

            choice = input.nextInt();
            input.nextLine();

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

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Donner le nouveau nom :");
                    character.setName(input.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Donner les nouveaux points de vie :");
                    character.setLifeLevel(input.nextInt());
                    input.nextLine();
                    break;
                }
                case 3: {
                    System.out.println("Donner les nouveaux points d'attaque :");
                    character.setStrongLevel(input.nextInt());
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

    public void runGame(Character character, GameBoard gameBoard, Dice dice) {
        while (character.getPosition() < 64 && character.getLifeLevel() > 0) {
            System.out.println("Position de " + character.getName() + " : " + character.getPosition());
            System.out.println("Lancé le Dé en appuyant sur Entrée");
            input.nextLine();
            int diceValue = dice.throwDice();
            int newCharacterPosition = character.getPosition() + diceValue;
            character.setPosition(newCharacterPosition);
        }

        if (character.getLifeLevel() < 0) {
            System.out.println("Perdu le joueur est mort");
        } else {
            System.out.println("Bravo !!! Vous avez gagné");
        }

        System.out.println("Fin de partie");
    }
}
