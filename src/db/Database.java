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

    private static String db = null;

    private static Connection getDB() {
        if (db == null) {
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
            } finally {
                return connector;
            }
        } else {
            return connector;
        }
    }

    public static ResultSet result(String query) throws SQLException {
        Statement statement = getDB().createStatement();
        return statement.executeQuery(query);
    }
}
