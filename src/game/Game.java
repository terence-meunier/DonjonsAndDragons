package game;

import characters.Character;
import db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

    public Map<Integer, Character> getHeroes() {

        Map<Integer, Character> charactersList = new HashMap<>();

        // On initialise un jeu de résultat vide
        ResultSet result;

        try {
            // Appel de la requête SQL
            result = Database.query("SELECT * FROM Hero");

            // On boucle sur le jeu de résultat reçu
            while (result.next()) {
                try{
                    Class c = Class.forName("characters." + result.getString("Type"));
                    Character character = (Character) c.newInstance();
                    character.setName(result.getString("Nom"));
                    character.setLife(result.getInt("NiveauVie"));
                    character.setAtk(result.getInt("NiveauForce"));
                    charactersList.put(result.getInt("Id"), character);
                } catch (Throwable e) {
                    System.err.println(e);
                }
            }
        } catch (SQLException e) {
            // On gère les exceptions possibles
            System.err.println(e);
        } finally {
            // On ferme les ressources
            Database.close();
        }
        return charactersList;
    }

    public boolean heroExist(String name) {
        ResultSet result;
        boolean heroExist = false;
        try {
            result = Database.query("SELECT Nom FROM Hero WHERE Nom='" + name + "'");
            if (result.first()) {
                heroExist = true;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return heroExist;
    }

    public void setHero(Character character) {
        String query;
        if (heroExist(character.getName())) {
            System.out.println("Mise à jour");
            String type = character.getClass().getName().split("[.]")[1];
            query = "UPDATE Hero SET Nom='" + character.getName() +
                    "', Type='" + type +
                    "', NiveauVie='" + character.getLife() +
                    "', NiveauForce='" + character.getAtk() +
                    "', Arme=''" +
                    ", Bouclier='' WHERE Nom='" + character.getName() + "'";
        } else {
            System.out.println("Création d'un joueur");
            String type = character.getClass().getName().split("[.]")[1];
            query = "INSERT INTO Hero (Nom, Type, NiveauVie, NiveauForce, Arme, Bouclier) VALUES ('"
                    + character.getName() + "', '"
                    + type + "', '"
                    + character.getLife() + "', '"
                    + character.getAtk() + "', '', '')";
        }
        try {
            int statut = Database.update(query);
            if (statut == 1) {
                System.out.println("Joueur : " + character.getName() + " sauvegardé");
            } else {
                System.out.println("Joueur : " + character.getName() + " non sauvegardé");
            }
        } catch (SQLException e) {
            System.err.println(e);
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
