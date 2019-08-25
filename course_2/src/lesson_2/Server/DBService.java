package lesson_2.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass) throws SQLException {
        System.out.println(pass.hashCode());
        String qry = String.format("SELECT nickname FROM main where login = '%s' and password = '%s'", login, pass.hashCode());
        ResultSet rs = stmt.executeQuery(qry);

        if (rs.next()) {
            return rs.getString(1);
        }

        return null;
    }

    public static void addUserInBlacklist(String user, String affronter) throws SQLException{
        String sql = String.format("INSERT INTO Black_list (Nick, User_ignored) VALUES ('%s', '%s')" ,user, affronter);
        stmt.execute(sql);
    }

//    public static void addNewUser(String login, String token1) {
//
//    }

    public static void changeNick(String newNick, String userNick) throws SQLException{
        String sql = String.format("UPDATE main SET nickname = '%s' WHERE nickname = '%s'" ,newNick, userNick);
        String sql2 = String.format("UPDATE Black_list SET User_ignored = '%s' WHERE User_ignored = '%s'" ,newNick, userNick);
        String sql3 = String.format("UPDATE Black_list SET Nick = '%s' WHERE Nick = '%s'" ,newNick, userNick);
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql2);
        stmt.executeUpdate(sql3);
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getBlackList(String user) throws SQLException{
        List<String> list = new ArrayList<>();
        String qryForBlacklist = String.format("SELECT User_ignored FROM Black_list where Nick = '%s'", user);
        ResultSet resultSet = stmt.executeQuery(qryForBlacklist);
        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        System.out.println(list);
        return list;
    }
}
