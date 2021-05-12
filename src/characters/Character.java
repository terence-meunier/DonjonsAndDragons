package characters;

import game.Location;

/**
 *
 * Abstract class Character
 *
 * @see Character#Character(String, int, int)
 *
 * @author Térence MEUNIER
 * @version 1.0
 */
abstract public class Character implements Location {

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
     * @param throwDice the dice number return by throwDice method of the Dice
     */
    public void move(int throwDice) {
        int out = throwDice - (63 - this.position);
        this.position += throwDice;
        if (this.position > 63) {
            this.position = 63 - out;
        }
    }

    /**
     * Method for fight an ennemy
     * @param ennemy ennemy attack during the fight
     */
    public void fight(Character ennemy) {
        ennemy.takeDamages(atk);
    }

    /**
     * Method for take damages
     * @param damages damages inflige by the ennemy
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
     * @return return if the character is alive
     */
    public boolean isAlive() {
        return life > 0;
    }

    /**
     * Escape method for the escape a fight with an ennemy
     *
     * @param nbcases number of cases to return back
     */
    public void escape(int nbcases) {
        position -= nbcases;
        if (position < 0) {
            position = 0;
        }
    }
}
