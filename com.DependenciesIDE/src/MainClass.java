import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/idetest?serverTimezone=UTC", "root", "root")){
            JFrame of = new JFrame();
            // Задаем правидо, по которому приложение завершиться при
            // закрытии этой формы
            of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            of.setBounds(100, 100, 100, 100);
            // Делаем окно видимым
            of.setVisible(true);
            JButton jButton = new JButton("Тикни меня");
            of.getContentPane().add(jButton);
        } catch (SQLException e) {
            e.printStackTrace();
            JFrame of = new JFrame();
            // Задаем правидо, по которому приложение завершиться при
            // закрытии этой формы
            of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Делаем окно видимым
            of.setVisible(true);
            JButton jButton = new JButton("Ешь писю");
            of.getContentPane().add(jButton);
        }
        try {
            FileReader fileReader = new FileReader("");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
