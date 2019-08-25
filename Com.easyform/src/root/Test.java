package root;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Test extends JFrame implements ListSelectionListener, ActionListener {

    private JList list;

    public Test() {
        list = new JList();
        // Вот здесь выставляем режим выделения одного пункта
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Создадим модель и отдади ее нашему списку вместо его стандартной
        DefaultListModel dlm = new DefaultListModel();
        list.setModel(dlm);

        // Список будет посылать сообщения форме
        list.addListSelectionListener(this);

        JButton add = new JButton("Add");
        JButton del = new JButton("Del");

        // Кнопка тоже будет посылать сообщения форме
        add.addActionListener(this);
        del.addActionListener(this);

        // Дадим нашим кнопкам имена, чтобы их можно было различать
        // при обработке
        add.setName("add");
        del.setName("del");

        // Создадим панель для наших кнопок и сделаем ее layout
        // в виде таблицы - 1 строка, 2 столбца
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        p.add(add);
        p.add(del);

        // Добавляем список на панель формы
        getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);

        // Добавляем панель в нижнюю часть
        getContentPane().add(p, BorderLayout.SOUTH);

        // Устанавливаем границы
        setBounds(100, 100, 200, 200);
    }

    // Единственный метод, который реализует интерфейс ListSelectionListener
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            System.out.println("New index:" + list.getSelectedIndex());
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Мы знаем, что у списка модель класса DefaultListModel
        // И поэтому можем ее привести к такому типу
        DefaultListModel dlm = (DefaultListModel) list.getModel();

        JButton sender = (JButton) e.getSource();

        if (sender.getName().equals("add")) {
            dlm.addElement(String.valueOf(dlm.getSize()));
        }
        // Проверяем имя для удаления и проверяем индекс - если он =-1,
        // значит нет выделенной строки
        if (sender.getName().equals("del")) {
            if (list.getSelectedIndex() >= 0) {
                dlm.remove(list.getSelectedIndex());
            }
            else
                if(dlm.getSize() > 0)
                dlm.remove(dlm.getSize() - 1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Test t = new Test();
                t.setDefaultCloseOperation(t.EXIT_ON_CLOSE);
                t.setVisible(true);
            }
        });
    }
}