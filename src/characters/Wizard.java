package characters;

import game.Location;
import stuffs.Potion;
import stuffs.Spell;
import stuffs.Weapon;

import java.util.Scanner;

/**
 * Classe Magicien qui permet de créer un objet de type Magicien, hérite de la classe abstraite Character
 *
 * @author Térence MEUNIER
 * @version 1.0
 * @see Character
 */
public class Wizard extends Character {
    private Spell spell;
    private String filter;

    /**
     * Constructeur vide
     */
    public Wizard() {
        this(null);
    }

    /**
     * Constructeur avec un paramètre
     *
     * @param name String
     *             Le nom du magicien
     */
    public Wizard(String name) {
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
    public Wizard(String name, int lifeLevel, int strongLevel) {
        super(name, lifeLevel, strongLevel);
        this.spell = null;
        this.filter = "Soin";
    }

    /**
     * Fight with an ennemy
     * @param ennemy ennemy attack during the fight
     */
    @Override
    public void fight(Character ennemy) {
        super.fight(ennemy);
        if (spell != null) {
            if (spell.getName().equals("Invisibility") && ennemy.getName().equals("Bad spirit")) {
                ennemy.takeDamages(spell.getAtqLevel() + 3);
            } else {
                ennemy.takeDamages(spell.getAtqLevel());
            }
        }
    }

    /**
     * Reset the life and the weapon of the character
     */
    public void reset() {
        super.reset();
        life = 3;
        spell = null;
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
}
