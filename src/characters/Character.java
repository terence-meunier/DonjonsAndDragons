package characters;

import game.Slot;
import stuffs.Potion;
import stuffs.Stuff;

/**
 *
 * Classe abstraite Character qui permet de créer des classes
 * avec un nom, un niveau de vie et un niveau de points d'attaque.
 *
 * @see Character#Character(String, int, int)
 *
 * @author Térence MEUNIER
 * @version 1.0
 */
abstract public class Character extends Slot {

    protected String name;
    protected int lifeLevel;
    protected int strongLevel;
    protected int position;

    /**
     *
     * @param name String
     *      Le nom du personnage
     *
     * @param lifeLevel int
     *      Les points de vie du personnage
     *
     * @param strongLevel int
     *      Les points d'attaques du personnage
     *
     */
    public Character(String name, int lifeLevel, int strongLevel) {
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.strongLevel = strongLevel;
        this.position = 0;
    }

    public String toString() {
        String output = "";
        output += "Nom : " + name + "\n";
        output += "-----------------------\n";
        output += "\n";
        output += "niveau de vie : " + lifeLevel + "\n";
        output += "niveau d'attaque : " + strongLevel + "\n";
        output += "-----------------------------------------\n";
        return output;
    }

    /**
     *
     * Getter pour récupèrer la position du personnage
     *
     * @return int position
     *      La position du personnage
     */
    public int getPosition() { return position; }

    /**
     *
     * Setter permettant de changer la position du personnage
     *
     * @param position int
     *                 la position du joueur qui est un entier de type int (primitif)
     */
    public void setPosition(int position) { this.position = position; }

    /**
     *
     * Getter pour récupèrer le nom du personnage
     *
     * @return String name
     *       Le nom du personnage
     */
    public String getName() {
        return name;
    }

    /**
     *
     * Setter permettant de modifier le nom du personnage
     *
     * @param name String
     *             le nom du personnage qui est un objet de type String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * Getter permettant de récupèrer le niveau de vie du personnage
     *
     * @return int lifeLevel
     *      Le niveau de vie du personnage dans un type int (primitif)
     */
    public int getLifeLevel() {
        return lifeLevel;
    }

    /**
     *
     * Setter permettant de modifier le niveau de vie du personnage
     *
     * @param lifeLevel int
     *      Le niveau de vie du personnage qui est de type int (primitif)
     */
    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    /**
     *
     * Getter permettant de récupèrer le niveau d'attaque du personnage
     *
     * @return int strongLevel
     *      Le niveau d'attaque du personnage dans un type int (primitif)
     */
    public int getStrongLevel() {
        return strongLevel;
    }

    /**
     *
     * Setter permettant de modifier le niveau d'attaque du personnage
     *
     * @param strongLevel int
     *                    Le niveau d'attaque du personnage qui est de de type int (primitif)
     */
    public void setStrongLevel(int strongLevel) {
        this.strongLevel = strongLevel;
    }

    abstract public void move(int throwDice);

    public void drop(Slot slot) {
        if (slot instanceof Potion) {
            // Si le slot contient une potion
            System.out.println("Santé actuel de " + name + " : " + lifeLevel + " points de vie");
            if (lifeLevel < 10) {
                lifeLevel += ((Potion) slot).getLifePoints();
                System.out.println(((Potion) slot).getName());
                System.out.println("+ " + ((Potion) slot).getLifePoints() + " pts de vie");
                if (lifeLevel > 10) {
                    System.out.println("Votre santé est pleine");
                    lifeLevel = 10;
                }
            } else {
                System.out.println("Vous venez de trouver une potion, mais votre santé est déjà pleine");
            }
            System.out.println("Santé actuel de " + name + " : " + lifeLevel + " points de vie");
        }
    }

    abstract public void fight(Ennemy ennemy);
}
