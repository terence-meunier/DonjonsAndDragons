package characters;

import game.Slot;
import stuffs.Potion;
import stuffs.Spell;
import stuffs.Stuff;
import stuffs.Weapon;

import java.util.Scanner;

/**
 * Classe Guerrier qui permet de créer un objet de type Guerrier, hérite de la classe abstraite Character
 *
 * @author Térence MEUNIER
 * @version 1.0
 * @see Character
 */
public class Guerrier extends Character {
    private Weapon weapon;
    private String shield;

    /**
     * Constructeur vide
     */
    public Guerrier() {
        this(null);
    }

    /**
     * Constructeur prenant juste un paramètre
     *
     * @param name String
     *             Le nom du guerrier
     */
    public Guerrier(String name) {
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
    public Guerrier(String name, int lifeLevel, int strongLevel) {
        super(name, lifeLevel, strongLevel);
        this.weapon = null;
        this.shield = "Ecu";
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

    public void move(int throwDice) {
        int out = throwDice - (64 - this.position);
        this.position += throwDice;
        if (this.position > 64) {
            this.position = 64 - out;
        }
    }

    public void drop(Slot slot) {
        super.drop(slot);

        if (slot instanceof Weapon) {
            System.out.println("Arme actuel de " + name + " : " + weapon);
            System.out.println("Récupération de : " + slot);
            weapon = (Weapon) slot;
            System.out.println("Nouvel arme actuel de " + name + " : " + weapon);
        } else if (slot instanceof Spell) {
            System.out.println("Les sorts ne sont pas faits pour les guerriers, passez votre chemin!");
        }
    }

}
