package game;

import characters.Character;
import db.Database;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Game class for the control of the game
 *
 * @author Meunier Terence
 * @version 1.0
 */
public class Game {

    private Character character;
    private GameBoard gameBoard;
    private Dice dice;

    /**
     * Constructor includes a character, a gameboard and a dice
     */
    public Game() {
        this.character = null;
        this.gameBoard = new GameBoard();
        this.dice = new Dice();
    }

    public void getHeroes() {

        // On initialise un jeu de résultat vide
        ResultSet result;

        try {
            // Appel de la requête SQL
            result = Database.query("SELECT * FROM Hero");

            // On boucle sur le jeu de résultat reçu
            while (result.next()) {
                System.out.println("---------------------");
                System.out.println("Nom : " + result.getString("Nom"));
                System.out.println("Type : " + result.getString("Type"));
                System.out.println("Points de vie : " + result.getInt("NiveauVie") + " pts de vie");
                System.out.println("Points d'attaque : " + result.getInt("NiveauForce") + " pts de force");
                System.out.println("Arme : " + result.getString("Arme"));
                System.out.println("Bouclier : " + result.getString("Bouclier"));
            }
        } catch (SQLException e) {
            // On gère les exceptions possibles
            System.err.println(e);
        } finally {
            // On ferme les ressources
            Database.close();
        }
    }

    public Character getCharacter() {
        return character;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Dice getDice() {
        return dice;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
