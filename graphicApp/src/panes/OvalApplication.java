package panes;

import javax.swing.*;

public class OvalApplication {
    public void droch(){

    }
    public static void main(String[] args) {
        Object string = new String();
        string = (String) string;
        // Создаем графическое окно
        JFrame of = new JFrame();
        // Задаем правидо, по которому приложение завершиться при
        // закрытии этой формы
        of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно видимым
        of.setVisible(true);
        JButton jButton = new JButton("Тикни меня");
        of.getContentPane().add(jButton);

    }
}


