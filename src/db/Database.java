package db;

import characters.Character;

import java.sql.*;

public class Database {
    private static String dbName = "dd";
    private static String user = "dd_user";
    private static String pass = "dd";
    private static String host = "localhost";
    private static int port = 3306;
    private static String driver = "mysql";
    private static Connection connector = null;
    private static Statement statement = null;
    private static ResultSet result = null;

    private static Connection getDB() {
        if (connector == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println(e);
            }

            try {
                String url = "jdbc:" + driver + "://" + host + ":" + port + "/" + dbName;
                connector = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return connector;
    }

    public static ResultSet query(String query) throws SQLException {
        statement = getDB().createStatement();
        return statement.executeQuery(query);
    }

    public static void insert(Character character) throws SQLException {
        PreparedStatement preparedStatement = getDB().prepareStatement("INSERT INTO Hero (Nom, Type, NiveauVie, NiveauForce, Arme, Bouclier) VALUES (?, ?, ?, ?, ?, ?)");

        String paramNom = character.getName();
        String paramType = character.getClass().getName().split("[.]")[1];
        int paramNiveauVie = character.getLife();
        int paramNiveauForce = character.getAtk();
        String paramArme = "";
        String paramBouclier = "";

        preparedStatement.setString(1, paramNom);
        preparedStatement.setString(2, paramType);
        preparedStatement.setInt(3, paramNiveauVie);
        preparedStatement.setInt(4, paramNiveauForce);
        preparedStatement.setString(5, paramArme);
        preparedStatement.setString(6, paramBouclier);

        int statut = preparedStatement.executeUpdate();

        if (statut == 1) {
            System.out.println("La requête à réussie");
        } else {
            System.out.println("La requête à échoué");
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void close() {
        if (result != null) {
            try {
                result.close();
                result = null;
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        if (connector != null) {
            try {
                connector.close();
                connector = null;
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
