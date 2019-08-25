package sql;


import com.mysql.fabric.jdbc.FabricMySQLDriver;
import com.mysql.jdbc.Driver;

import java.sql.*;


public class SqlRequester {

    public final static String URL= "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public final static String USERNAME= "root";
    public final static String PASSWORD= "root";
    public static void isertion(String s) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT into users (name) values (%s)", s));
            if(!connection.isClosed()){
                System.out.println("Ты- хуй");
            }
        } catch (SQLException e) {
            System.err.println("Ешь писю");
        }

    }
}
