package characters;

import game.Slot;
import stuffs.Potion;

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
    protected int life;
    protected int atk;
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
        this.life = lifeLevel;
        this.atk = strongLevel;
        this.position = 0;
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
     * @return int life
     *      Le niveau de vie du personnage dans un type int (primitif)
     */
    public int getLife() {
        return life;
    }

    /**
     *
     * Setter permettant de modifier le niveau de vie du personnage
     *
     * @param life int
     *      Le niveau de vie du personnage qui est de type int (primitif)
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     *
     * Getter permettant de récupèrer le niveau d'attaque du personnage
     *
     * @return int strongLevel
     *      Le niveau d'attaque du personnage dans un type int (primitif)
     */
    public int getAtk() {
        return atk;
    }

    /**
     *
     * Setter permettant de modifier le niveau d'attaque du personnage
     *
     * @param strongLevel int
     *                    Le niveau d'attaque du personnage qui est de de type int (primitif)
     */
    public void setAtk(int strongLevel) {
        this.atk = strongLevel;
    }

    /**
     * Method toString
     * @return
     */
    @Override
    public String toString() {
        String output = "";
        output += "Nom : " + name + "\n";
        output += "-----------------------\n";
        output += "\n";
        output += "niveau de vie : " + life + "\n";
        output += "niveau d'attaque : " + atk + "\n";
        output += "-----------------------------------------\n";
        return output;
    }

    /**
     * Method for move the player on the gameboard with throw dice
     * @param throwDice
     */
    public void move(int throwDice) {
        int out = throwDice - (63 - this.position);
        this.position += throwDice;
        if (this.position > 63) {
            this.position = 63 - out;
        }
    }

    /**
     * Method for drop an item on the gameboard location
     * @param slot
     */
    public void drop(Slot slot) {
        if (slot instanceof Potion) {
            // Si le slot contient une potion
            System.out.println("Santé actuel de " + name + " : " + life + " points de vie");
            if (life < 10) {
                life += ((Potion) slot).getLifePoints();
                System.out.println(((Potion) slot).getName());
                System.out.println("+ " + ((Potion) slot).getLifePoints() + " pts de vie");
                if (life > 10) {
                    System.out.println("Votre santé est pleine");
                    life = 10;
                }
            } else {
                System.out.println("Vous venez de trouver une potion, mais votre santé est déjà pleine");
            }
            System.out.println("Santé actuel de " + name + " : " + life + " points de vie");
        }
    }

    /**
     * Method for fight an ennemy
     * @param ennemy
     */
    public void fight(Character ennemy) {
        ennemy.takeDamages(atk);
    }

    /**
     * Method for take damages
     * @param damages
     */
    public void takeDamages(int damages) {
        life -= damages;
    }

    /**
     * Method for reset position of character to begin gameboard
     */
    public void reset() {
        position = 0;
    }

    /**
     * Method for test if the character is alive
     * @return
     */
    public boolean isAlive() {
        return life > 0;
    }
}
