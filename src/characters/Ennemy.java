package characters;

import game.Location;

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
     * @param life int
     *             Les points de vie de l'ennemie
     * @param atk int
     *              Les points d'attaque de l'ennemie
     */
    public Ennemy(String name, int life, int atk) {
        super(name, life, atk);
    }

}
