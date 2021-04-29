package game;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private int nbCases;
    private List board = new ArrayList();

    public GameBoard() {
        this.nbCases = 64;
    }

    public ArrayList generateGameBoard() {
        return new ArrayList();
    }

    public boolean isEndGame() {
        return false;
    }
}
