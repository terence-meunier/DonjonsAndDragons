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
        Slot gobelin = new Slot();
        gobelin.setEnnemy(new Ennemy("Gobelin", 6, 1));

        // Sorcier
        Slot sorcier = new Slot();
        gobelin.setEnnemy(new Ennemy("Sorcier", 9, 2));

        // Dragon
        Slot dragon = new Slot();
        sorcier.setEnnemy(new Ennemy("Dragon", 15, 4));

        // Potion standard
        Slot stdPotion = new Slot();
        stdPotion.setPotion(new Potion("Grande potion de vie", 5));

        // Grande potion
        Slot bigPotion = new Slot();
        bigPotion.setPotion(new Potion("Potion de vie standard", 2));

        // Epee
        Slot massue = new Slot();
        massue.setWeapon(new Weapon("Massue", 3));

        // Massue
        Slot epee = new Slot();
        epee.setWeapon(new Weapon("Epée", 5));

        // Eclair
        Slot eclair = new Slot();
        eclair.setSpell(new Spell("Eclair", 2));

        // Boule de feu
        Slot bouleDeFeu = new Slot();
        bouleDeFeu.setSpell(new Spell("Boule de feu", 7));

        // Case vide
        Slot caseVide = new Slot();

        // Load in the List
        for (int i = 0; i < this.nbCases; i++) {
            if (i == 14 || i == 32 || i == 23 || i == 9) {
                board.add(stdPotion);
            } else if (i == 45 || i == 6 || i == 34) {
                board.add(bigPotion);
            } else if (i == 55 || i == 63) {
                board.add(epee);
            } else if (i == 5 || i == 33 || i == 17 || i == 8) {
                board.add(epee);
            } else if (i == 11 || i == 2 || i == 7) {
                board.add(epee);
            } else if (i == 10) {
                board.add(massue);
            } else if (i == 38) {
                board.add(eclair);
            } else if (i == 24) {
                board.add(bouleDeFeu);
            } else if (i == 60) {
                board.add(massue);
            } else {
                board.add(caseVide);
            }
        }
    }

    public List<Slot> getBoard() {
        return board;
    }
}
