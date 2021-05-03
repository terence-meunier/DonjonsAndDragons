package characters;

import game.Slot;
import stuffs.Spell;
import stuffs.Stuff;
import stuffs.Weapon;

import java.util.Scanner;

/**
 * Classe Magicien qui permet de créer un objet de type Magicien, hérite de la classe abstraite Character
 *
 * @author Térence MEUNIER
 * @version 1.0
 * @see Character
 */
public class Magicien extends Character {
    private Spell spell;
    private String filter;

    /**
     * Constructeur vide
     */
    public Magicien() {
        this(null);
    }

    /**
     * Constructeur avec un paramètre
     *
     * @param name String
     *             Le nom du magicien
     */
    public Magicien(String name) {
        this(name, 3, 8);
    }

    /**
     * Constructeur avec 3 paramètres
     *
     * @param name        String
     *                    Le nom du magicien
     * @param lifeLevel   int
     *                    Les points de vie du magicien
     * @param strongLevel int
     *                    Le niveau d'attaque du magicien
     */
    public Magicien(String name, int lifeLevel, int strongLevel) {
        super(name, lifeLevel, strongLevel);
        this.spell = null;
        this.filter = "Soin";
    }

    /**
     * Getter Récupère le sort du magicien sous la forme d'un objet de type Spell
     *
     * @return Spell spell
     * @see Spell
     */
    public Spell getSpell() {
        return spell;
    }

    /**
     * Setter affecter un nouveau sort au magicien
     *
     * @param spell Le sort à affecté au magicien
     */
    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    /**
     * Getter permettant de récupèrer le filtre du magicien
     *
     * @return String filter
     * Le filtre du magicien sous la forme d'un objet String
     */
    public String getFilter() {
        return filter;
    }

    /**
     * Setter permettnat d'affecter un filtre au magicien
     *
     * @param filter Le filtre à affecté au magicien
     */
    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String toString() {
        return super.toString() + "\n---- EQUIPEMENTS -----\nArme : " + spell + "\nBouclier : " + filter;
    }

    public void move(int throwDice) {
        int out = throwDice - (64 - this.position);
        this.position += throwDice;
        if (this.position > 64) {
            this.position = 64 - out;
        }
    }

    public void drop(Slot slot) {
        super.drop(slot);

        if (slot instanceof Spell) {
            if (spell == null) {
                System.out.println("Vous avez trouvé un sort : " + slot);
                spell = (Spell) slot;
            } else {
                Scanner input = new Scanner(System.in);
                int choice = 0;
                while (choice != 1 && choice != 2) {
                    System.out.println("Sort trouvé : " + slot);
                    System.out.println("Sort actuel : " + spell);
                    System.out.println("Changer de sort (1: Oui / 2: Non) ?");
                    choice = input.nextInt();
                    input.nextLine();

                    switch (choice) {
                        case 1: {
                            System.out.println("Changement de sort");
                            spell = (Spell) slot;
                            break;
                        }
                        case 2: {
                            System.out.println("Sort actuel conservé");
                            break;
                        }
                        default: {
                            System.out.println("Choix non valide");
                        }
                    }
                }
            }
        } else if (slot instanceof Weapon) {
            System.out.println("Les armes ne sont pas faites pour les magiciens, passez votre chemin !");
        }

    }

    public void fight(Ennemy ennemy) {
        while (ennemy.getLifeLevel() > 0 && lifeLevel > 0) {
            lifeLevel -= ennemy.getStrongLevel();
            int forceWarrior;
            if (spell == null) {
                forceWarrior = strongLevel;
            } else {
                forceWarrior = strongLevel + spell.getAtqLevel();
            }
            ennemy.setLifeLevel(ennemy.getLifeLevel() - forceWarrior);
        }

        if (ennemy.getLifeLevel() <= 0 && lifeLevel > 0) {
            System.out.println("Vous avez gagné");
        } else if (lifeLevel <= 0) {
            System.out.println("Vous êtes mort");
            position = 64;
        }
    }
}
