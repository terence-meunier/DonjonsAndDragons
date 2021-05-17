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
    private static PreparedStatement preparedStatement = null;
    private static ResultSet result = null;

    private static Connection getDB() {
        if (connector == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
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

    private static boolean heroExist(String name) {
        PreparedStatement pSth = null;
        ResultSet result = null;
        Boolean exist = false;

        try {
            pSth = getDB().prepareStatement("SELECT Nom FROM Hero WHERE Nom=?");
            pSth.setString(1, name);
            result = pSth.executeQuery();
            while (result.next()) {
                if (result.getString("Nom").equals(name)) {
                    exist = true;
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                if (pSth != null) {
                    pSth.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return exist;
    }

    public static void save(Character character) throws SQLException {

        String paramNom = character.getName();
        String paramType = character.getClass().getName().split("[.]")[1];
        int paramNiveauVie = character.getLife();
        int paramNiveauForce = character.getAtk();
        String paramArme = "";
        String paramBouclier = "";
        if (paramType.equals("Warrior")) {
            paramArme = "Epée";
            paramBouclier = "Ecu";
        } else if (paramType.equals("Wizard")) {
            paramArme = "Eclair";
            paramBouclier = "Barrière";
        }

        if (heroExist(paramNom)) {
            preparedStatement = getDB().prepareStatement("UPDATE Hero SET Nom=?, Type=?, NiveauVie=?, NiveauForce=?, Arme=?, Bouclier=? WHERE Nom=?");
        } else {
            preparedStatement = getDB().prepareStatement("INSERT INTO Hero (Nom, Type, NiveauVie, NiveauForce, Arme, Bouclier) VALUES (?, ?, ?, ?, ?, ?)");
        }

        preparedStatement.setString(1, paramNom);
        preparedStatement.setString(2, paramType);
        preparedStatement.setInt(3, paramNiveauVie);
        preparedStatement.setInt(4, paramNiveauForce);
        preparedStatement.setString(5, paramArme);
        preparedStatement.setString(6, paramBouclier);

        if (heroExist(paramNom)) {
            preparedStatement.setString(7, paramNom);
        }

        int statut = preparedStatement.executeUpdate();

        if (statut == 1) {
            System.out.println("La requête à réussie");
        } else {
            System.out.println("La requête à échoué");
        }
    }

    public static void close() {

        // Libération de la ressource result
        if (result != null) {
            try {
                result.close();
                result = null;
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        // Libération de la ressource preparedStatement
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        // Libération de la ressource statement
        if (statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        // Libération de la ressource connector
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
