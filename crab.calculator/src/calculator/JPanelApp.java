package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelApp extends JPanel {
    Calculator calculator = new Calculator();

    JTextField txt1 = null;
    int operand_1 = 0;
    int operand_2 = 0;
    Operations operation;

    public JPanelApp() {
        try {
            setLayout(null);
            // Specifies the position of the element
            final TextField txt1 = new TextField();
            txt1.setBounds(10, 10, 235, 25);

            JButton bC = new JButton("C");
            bC.setBounds(170, 40, 60, 50);

            JButton bRes = new JButton("=");
            bRes.setBounds(60, 110, 50, 50);
            Font bigFont = new Font("serif", Font.BOLD, 22);
            bRes.setFont(bigFont);

            JButton bExponentiation = new JButton("2x");
            bExponentiation.setBounds(110, 110, 50, 50);
            Font bigFontExponentiation = new Font("serif", Font.BOLD, 16);
            bExponentiation.setFont(bigFontExponentiation);

            JButton bPlus = new JButton("+");
            bPlus.setBounds(10, 40, 50, 50);
            Font bigFontPlus = new Font("serif", Font.BOLD, 22);
            bPlus.setFont(bigFontPlus);

            JButton bMinus = new JButton("-");
            bMinus.setBounds(60, 40, 50, 50);
            Font bigFontMinus = new Font("serif", Font.BOLD, 22);
            bMinus.setFont(bigFontMinus);

            JButton bMultiplicate = new JButton("*");
            bMultiplicate.setBounds(110, 40, 50, 50);
            Font bigFontMulti = new Font("serif", Font.BOLD, 22);
            bMultiplicate.setFont(bigFontMulti);

            JButton bDivision = new JButton("/");
            bDivision.setBounds(10, 110, 50, 50);
            Font bigFontDivision = new Font("serif", Font.BOLD, 22);
            bDivision.setFont(bigFontDivision);

            add(txt1);

            add(bC);

            add(bRes);

            add(bExponentiation);

            add(bPlus);

            add(bMinus);

            add(bMultiplicate);

            add(bDivision);

            bExponentiation.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    operand_1 = Integer.parseInt(txt1.getText());
                    txt1.setText(String.valueOf(calculator.calculate(operand_1, Operations.Multiplication, operand_1)));
                }
            });

            bC.addActionListener(new

                                         ActionListener() {
                                             @Override
                                             public void actionPerformed(ActionEvent arg1) {
                                                 txt1.setText(null);
                                                 operation = null;
                                                 operand_1 = 0;
                                                 operand_2 = 0;
                                             }
                                         });

            bPlus.addActionListener(new

                                            ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent arg1) {
                                                    operand_1 = Integer.valueOf(txt1.getText());
                                                    txt1.setText("");
                                                    operation = Operations.Addition;
                                                }
                                            });

            bMinus.addActionListener(new

                                             ActionListener() {
                                                 @Override
                                                 public void actionPerformed(ActionEvent arg1) {
                                                     operand_1 = Integer.valueOf(txt1.getText());
                                                     txt1.setText("");
                                                     operation = Operations.Subtraction;
                                                 }
                                             });

            bMultiplicate.addActionListener(new

                                             ActionListener() {
                                                 @Override
                                                 public void actionPerformed(ActionEvent arg1) {
                                                     operand_1 = Integer.valueOf(txt1.getText());
                                                     txt1.setText("");
                                                     operation = Operations.Multiplication;
                                                 }
                                             });

            bDivision.addActionListener(new

                                                ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent arg1) {
                                                        operand_1 = Integer.valueOf(txt1.getText());
                                                        txt1.setText("");
                                                        operation = Operations.Division;
                                                    }
                                                });

            bRes.addActionListener(new

                                           ActionListener() {
                                               @Override
                                               public void actionPerformed(ActionEvent arg0) {
                                                   operand_2 = Integer.parseInt(txt1.getText());

                                                   String strRes = String.valueOf(calculator.calculate(operand_1, operation, operand_2));
                                                   txt1.setText(strRes);
                                               }
                                           });
        } catch (ArithmeticException exception) {
            //System.out.println("Can not divide by zero ");
        }
    }
}

