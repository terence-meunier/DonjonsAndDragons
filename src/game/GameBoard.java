package game;

import characters.Ennemy;
import stuffs.Potion;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private int nbCases;
    private List<Object> board = new ArrayList<Object>();

    public GameBoard() {
        this.nbCases = 64;
        generateGameBoard();
    }

    private void generateGameBoard() {
        Ennemy gobelin = new Ennemy("Gobelin", 6, 1);
        Ennemy sorcier = new Ennemy("Sorcier", 9, 2);
        Ennemy dragon = new Ennemy("Dragon", 15, 4);
        Potion gdePotion = new Potion("Grande potion de vie", 5);
        Potion stdPotion = new Potion("Potion de vie standard", 2);

        // On popule le tableau
        for (int i=0; i < this.nbCases; i++) {
            if (i == 14 || i == 32 || i == 23 || i == 9) {
                board.add(gobelin);
            } else if (i == 45 || i == 6 || i == 34) {
                board.add(sorcier);
            } else if (i == 55 || i == 63) {
                board.add(dragon);
            } else if (i == 5 || i == 33 || i == 17 || i == 8) {
                board.add(gdePotion);
            } else if (i == 11 || i == 2 || i == 7) {
                board.add(stdPotion);
            } else {
                board.add(null);
            }
        }
    }

    public List<Object> getBoard() {
        return board;
    }
}
