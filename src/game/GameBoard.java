package game;

import characters.Ennemy;
import stuffs.Potion;
import stuffs.Spell;
import stuffs.Weapon;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private int nbCases;
    // A changer
    private List<Slot> board;

    public GameBoard() {
        this.nbCases = 64;
        this.board = new ArrayList<Slot>();
        generateGameBoard();
    }

    private void generateGameBoard() {

        // Gobelin
        Ennemy gobelin = new Ennemy("Gobelin", 6, 1);

        // Sorcier
        Ennemy sorcier = new Ennemy("Sorcier", 9, 2);

        // Dragon
        Ennemy dragon = new Ennemy("Dragon", 15, 4);

        // Potion standard
        Potion stdPotion = new Potion("Grande potion de vie", 5);

        // Grande potion
        Potion bigPotion = new Potion("Potion de vie standard", 2);

        // Epee
        Weapon massue = new Weapon("Massue", 3);

        // Massue
        Weapon epee = new Weapon("Epée", 5);

        // Eclair
        Spell eclair = new Spell("Eclair", 2);

        // Boule de feu
        Spell bouleDeFeu = new Spell("Boule de feu", 7);

        // Case vide
        Slot caseVide = null;

        // Load in the List
        for (int i = 0; i < this.nbCases; i++) {
            if (i == 45 || i == 52 || i == 56 || i == 62) {
                board.add(dragon);
            } else if (i == 10 || i == 20 || i == 25 || i == 32 || i == 35 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47) {
                board.add(sorcier);
            } else if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30) {
                board.add(gobelin);
            } else if (i == 2 || i == 11 || i == 5 || i == 22 || i == 38) {
                board.add(massue);
            } else if (i == 19 || i == 26 || i == 42 || i == 53) {
                board.add(epee);
            } else if (i == 1 || i == 4 || i == 8 || i == 17 || i == 23) {
                board.add(eclair);
            } else if (i == 48 || i == 49) {
                board.add(bouleDeFeu);
            } else if (i == 7 || i == 13 || i == 31 || i == 33 || i == 39 || i == 43) {
                board.add(stdPotion);
            } else if (i == 28 || i == 41) {
                board.add(bigPotion);
            } else {
                board.add(caseVide);
            }
        }
    }

    public List<Slot> getBoard() {
        return board;
    }
}
