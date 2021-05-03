package characters;

import game.Slot;
import stuffs.Stuff;

/**
 *
 * Classe Ennemy qui permet de créer un objet de type Ennemy, hérite de la classe abstraite Character
 *
 * @see Character
 *
 * @author Térence MEUNIER
 * @version 1.0
 */
public class Ennemy extends Character {
    /**
     * Constructeur avec 3 paramètres
     * @param name String
     *             Le nom de l'ennemie
     * @param lifeLevel int
     *             Les points de vie de l'ennemie
     * @param atqLevel int
     *              Les points d'attaque de l'ennemie
     */
    public Ennemy(String name, int lifeLevel, int atqLevel) {
        super(name, lifeLevel, atqLevel);
    }

    public void move(int throwDice) {

    }

    public void drop(Slot slot) {
        if (slot.getClass() == game.Slot.class) {
            System.out.println(slot);
        }
    }
}
