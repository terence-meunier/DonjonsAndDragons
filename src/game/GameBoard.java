package game;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private int nbCases;
    private List<Integer> board = new ArrayList<Integer>();

    public GameBoard() {
        this.nbCases = 64;
        generateGameBoard();
    }

    private void generateGameBoard() {
        for (int i=0; i < this.nbCases; i++) {
            board.add(i);
        }
    }

    public boolean isEndGame() {
        return false;
    }

    public List<Integer> getBoard() {
        return board;
    }
}
