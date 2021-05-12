package db;

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
        result = statement.executeQuery(query);
        return result;
    }

    public static void close() {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        if (connector != null) {
            try {
                connector.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
