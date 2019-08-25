import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(0, 0, 100, 100);
        KeyListener keyListener = new KeyListener() {
            int x = 0;
            int y = 0;
            int width = 100;

            {
                System.out.println("q");
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        if (e.isShiftDown())
                        {width += 10;}
                        else
                        {x += 10;}

                        jFrame.setBounds(x, y, width, 100);
                        break;
                    case KeyEvent.VK_LEFT:
                        x -= 10;
                        jFrame.setBounds(x, y, 100, 100);
                        break;
                    case KeyEvent.VK_UP:
                        y -= 10;
                        jFrame.setBounds(x, y, 100, 100);
                        break;
                    case KeyEvent.VK_DOWN:
                        y += 10;
                        jFrame.setBounds(x, y, 100, 100);
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        jFrame.addKeyListener(keyListener);
    }
}
