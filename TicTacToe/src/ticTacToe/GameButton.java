package ticTacToe;

import javax.swing.JButton;

public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    public GameButton(int gameButtonIndex, GameBoard currentGameBoard) {
        this.buttonIndex = gameButtonIndex;
        this.board = currentGameBoard;
        int rowNum = buttonIndex / GameBoard.dimension;
        int cellNum = buttonIndex % GameBoard.dimension;
        this.setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        this.addActionListener(new GameActionListener(rowNum, cellNum, this));
    }

    public GameBoard getBoard() {
        return this.board;
    }
}