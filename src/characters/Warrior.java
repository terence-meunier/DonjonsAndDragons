package characters;

import game.Location;
import stuffs.Potion;
import stuffs.Spell;
import stuffs.Weapon;

import java.util.Scanner;

/**
 * Classe Guerrier qui permet de créer un objet de type Guerrier, hérite de la classe abstraite Character
 *
 * @author Térence MEUNIER
 * @version 1.0
 * @see Character
 */
public class Warrior extends Character {
    private Weapon weapon;
    private String shield;

    /**
     * Constructeur vide
     */
    public Warrior() {
        this(null);
    }

    /**
     * Constructeur prenant juste un paramètre
     *
     * @param name String
     *             Le nom du guerrier
     */
    public Warrior(String name) {
        this(name, 5, 5);
    }

    /**
     * Constructeur prenant 3 paramètres
     *
     * @param name        String
     *                    Le nom du guerrier de type String
     * @param lifeLevel   int
     *                    Le niveau de vie du guerrier de type int
     * @param strongLevel int
     *                    Le niveau d'attaque du guerrier de type int
     */
    public Warrior(String name, int lifeLevel, int strongLevel) {
        super(name, lifeLevel, strongLevel);
        this.weapon = null;
        this.shield = "Ecu";
    }

    /**
     * Fight with an ennemy
     * @param ennemy ennemy attack during the fight
     */
    @Override
    public void fight(Character ennemy) {
        super.fight(ennemy);
        if (weapon != null) {
            if (weapon.getName().equals("Arc") && ennemy.getName().equals("Dragon")) {
                ennemy.takeDamages(weapon.getAtqLevel() + 2);
            } else {
                ennemy.takeDamages(weapon.getAtqLevel());
            }
        }
    }

    /**
     * Reset the life and the weapon of the character
     */
    public void reset() {
        super.reset();
        life = 5;
        weapon = null;
    }

    /**
     * Getter permettant de récupèrer l'arme du guerrier
     *
     * @return Weapon weapon
     * L'arme du guerrier sous la forme d'un objet Weapon
     * @see Weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Setter permettnat d'affecter une arme au guerrier
     *
     * @param weapon L'arme à affecter de type Weapon
     * @see Weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Getter permettant de récupèrer le bouclier du guerrier
     *
     * @return String shield
     * Le bouclier du guerrier qui est de type String
     */
    public String getShield() {
        return shield;
    }

    /**
     * Setter permettnat d'affecter un bouclier au guerrier
     *
     * @param shield Le bouclie affecté au guerrier
     */
    public void setShield(String shield) {
        this.shield = shield;
    }

    public String toString() {
        return super.toString() + "\n---- EQUIPEMENTS -----\nArme : " + weapon + "\nBouclier : " + shield;
    }
}
