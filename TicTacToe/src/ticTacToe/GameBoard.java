package ticTacToe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JFrame {
    static int dimension = 3;
    static int cellSize = 150;
    private char[][] gameField;
    private GameButton[] gameButtons;
    private Game game;
    static char nullSymbol = 'g';

    public GameBoard(Game currentGame) {
        this.game = currentGame;
        this.initField();
    }

    boolean isTurnable(int x, int y) {
        if (gameField[y][x] == nullSymbol) {
            return true;
        }
        return false;
    }

    void updateGameField(int x, int y) {
        this.gameField[y][x] = this.game.getCurrentPlayer().getPlayerSign();
    }

    private void initField() {
        this.setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("New game");
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameBoard.this.emptyField();
            }
        });
        controlPanel.setLayout(new BoxLayout(controlPanel, 1));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);
        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);
        this.gameField = new char[dimension][dimension];
        this.gameButtons = new GameButton[dimension * dimension];

        for(int i = 0; i < dimension * dimension; ++i) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            this.gameButtons[i] = fieldButton;
        }

        this.getContentPane().add(controlPanel, "North");
        this.getContentPane().add(gameFieldPanel, "Center");
        this.setVisible(true);
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j]=nullSymbol;
                System.out.print(gameField[i][j]);
            }
            System.out.println();

        }
    }

    void emptyField() {
        for(int i = 0; i < dimension * dimension; ++i) {
            gameButtons[i].setText("");
            int x = i / dimension;
            int y = i % dimension;
            gameField[x][y] = nullSymbol;
        }
    }

    public Game getGame() {
        return game;
    }

    boolean checkWin() {
        boolean result = false;
        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();
        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }

        return result;
    }

    boolean isFull() {
        for(int i = 0; i < gameField.length; ++i) {
            for(int j = 0; j < gameField.length; ++j) {
                if (gameField[i][j] == nullSymbol) {
                    return  false;
                }
            }
        }
        return true;
    }

    private boolean checkWinDiagonals(char playerSymbol) {
        boolean leftRight = true;
        boolean rightLeft = true;
        boolean result = false;

        for(int i = 0; i < dimension; ++i) {
            leftRight &= this.gameField[i][i] == playerSymbol;
            rightLeft &= this.gameField[dimension - i - 1][i] == playerSymbol;
        }

        if (leftRight || rightLeft) {
            result = true;
        }

        return result;
    }

    private boolean checkWinLines(char playerSymbol) {
        boolean result = false;

        for(int col = 0; col < dimension; ++col) {
            boolean cols = true;
            boolean rows = true;

            for(int row = 0; row < dimension; ++row) {
                cols &= this.gameField[col][row] == playerSymbol;
                rows &= this.gameField[row][col] == playerSymbol;
            }

            if (cols || rows) {
                result = true;
                break;
            }

            if (result) {
                break;
            }
        }

        return result;
    }

    public GameButton getButton(int buttonIndex) {
        return this.gameButtons[buttonIndex];
    }

    public char[][] getGameField() {
        return this.gameField;
    }
}