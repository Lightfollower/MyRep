package lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Hello");
        setBounds(800,500,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        centerPanel.setBackground(Color.gray);
        bottomPanel.setBackground(Color.green);

        bottomPanel.setPreferredSize(new Dimension(1,40));

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        JButton jb = new JButton("Send");
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);

        JTextField jtf = new JTextField();

        centerPanel.add(jsp, BorderLayout.CENTER);
        bottomPanel.add(jtf);
        bottomPanel.add(jb);

        jtf.setPreferredSize(new Dimension(300,28));
        jta.setEditable(false);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });


        setVisible(true);
    }
}


class MyLis implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}








//        setLayout(null);
//        JButton btn1 = new JButton("btn1");
//        btn1.setBounds(10,10,200,100);
//
//        JButton btn2 = new JButton("btn2");
//        btn2.setBounds(200,200,150,70);
//
//        add(btn1);
//        add(btn2);

//        JButton btn1 = new JButton("ok");
//        JButton btn2 = new JButton("cancel");
//
//        JPanel panel = new JPanel(new GridLayout(1,3));
//        panel.add(btn1);
//        panel.add(btn2);


//        btn1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(getClass().getName());
//                System.out.println("ok");
//            }
//        });
//
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.gray);
//        add(panel, BorderLayout.CENTER);
//
//        panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println(e.getX() + " " + e.getY());
//            }
//        });
//
//        JTextField jtf = new JTextField();
//
//        jtf.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    System.out.println("Enter");
//                }
//            }
//        });
//
//        panel.add(jtf);
//
//
////        add(panel, BorderLayout.SOUTH);
//
//        setVisible(true);