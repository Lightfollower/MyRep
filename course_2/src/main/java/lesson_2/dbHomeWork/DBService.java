package lesson_2.dbHomeWork;

import org.sqlite.JDBC;

import java.sql.*;

public class DBService {
    private static Connection connection;
    private static Statement stmt;
    private static String qry;
    public static void mainClass() {
        try {
            connection = DriverManager.getConnection(JDBC.PREFIX + "main.db");
            stmt = connection.createStatement();
            String qry = "CREATE TABLE IF NOT EXISTS goods (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "prodid INT NOT NULL, " +
                    "title VARCHAR NOT NULL, " +
                    "cost DECIMAL NOT NULL)";
            stmt.execute(qry);
            qry = "DELETE FROM goods";
            stmt.execute(qry);
            qry = "DELETE FROM sqlite_sequence WHERE NAME = 'goods'";
            stmt.execute(qry);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO goods (prodid, title, cost)" +
                    " VALUES (?, ?, ?)");
            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, i + "goods");
                preparedStatement.setFloat(3, i * 10);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getCostByTitle(String goodsName) throws SQLException{
        qry = String.format("SELECT cost FROM goods WHERE title = '%s'", goodsName);
            return stmt.executeQuery(qry);
    }

    public static int changeCostByTitle(String goodsTitle, String newCost) throws SQLException{
        qry = String.format("UPDATE goods SET cost = %s WHERE title = '%s'", newCost, goodsTitle);
        return stmt.executeUpdate(qry);
    }

    public static ResultSet getGoodsByPriceRange(String fromPrice, String toPrice) throws SQLException{
        qry = String.format("SELECT title, cost FROM goods WHERE cost BETWEEN %s AND %s", fromPrice, toPrice);
        return stmt.executeQuery(qry);
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
