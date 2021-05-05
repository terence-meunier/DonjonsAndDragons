package game;

import characters.Ennemy;
import stuffs.Potion;
import stuffs.Spell;
import stuffs.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {
    private int nbCases;
    // A changer
    private List<Location> board;

    public GameBoard() {
        this.nbCases = 64;
        this.board = new ArrayList<Location>();
        generateGameBoard();
    }

    private void generateGameBoard() {

        // Hard Load
        for (int i = 0; i < this.nbCases; i++) {
            if (i == 45 || i == 52 || i == 56 || i == 62) {
                board.add(new Ennemy("Dragon", 15, 4));
            } else if (i == 10 || i == 20 || i == 25 || i == 32 || i == 35 || i == 36 || i == 37 || i == 40 || i == 44 || i == 47) {
                board.add(new Ennemy("Sorcier", 9, 2));
            } else if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18 || i == 21 || i == 24 || i == 27 || i == 30) {
                board.add(new Ennemy("Gobelin", 6, 1));
            } else if (i == 2 || i == 11 || i == 5 || i == 22 || i == 38) {
                board.add(new Weapon("Massue", 3));
            } else if (i == 19 || i == 26 || i == 42 || i == 53) {
                board.add(new Weapon("Epée", 5));
            } else if (i == 1 || i == 4 || i == 8 || i == 17 || i == 23) {
                board.add(new Spell("Eclair", 2));
            } else if (i == 48 || i == 49) {
                board.add(new Spell("Boule de feu", 7));
            } else if (i == 7 || i == 13 || i == 31 || i == 33 || i == 39 || i == 43) {
                board.add(new Potion("Potion de vie standard", 2));
            } else if (i == 28 || i == 41) {
                board.add(new Potion("Grande potion de vie", 5));
            } else if (i == 34 || i == 55 || i == 51 || i == 46) {
                board.add(new Ennemy("Orc", 10, 6));
            } else {
                board.add(null);
            }
        }

        // Random Load
        Collections.shuffle(board);
    }

    public List<Location> getBoard() {
        return board;
    }
}
