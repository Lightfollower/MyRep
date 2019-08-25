package ticTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton button) {
        this.row = row;
        this.cell = cell;
        this.button = button;
    }

    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();
        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);
            if (board.isFull()) {
                board.getGame().showMessage("draw");
                board.emptyField();
            } else {
                updateByAiData(board);
                if (board.isFull()) {
                    board.getGame().showMessage("draw");
                    board.emptyField();
                }
            }
        } else {
            board.getGame().showMessage("Incorrect turn");
        }

    }

    private void updateByAiData(GameBoard board) {
        int x = -1;
        int y = -1;
        int maxScoreFieldX = -1;
        int maxScoreFieldY = -1;
        int maxScore = 0;

        int i;
        for(i = 0; i < board.getGameField().length; ++i) {

            for(int j = 0; j < board.getGameField().length; ++j) {
                int fieldScore = 0;
                if (board.getGameField()[i][j] == GameBoard.nullSymbol) {
                    if (i - 1 >= 0 && j - 1 >= 0 && board.getGameField()[i - 1][j - 1] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }

                    if (i - 1 >= 0 && board.getGameField()[i - 1][j] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }

                    if (i - 1 >= 0 && j + 1 < GameBoard.dimension && board.getGameField()[i - 1][j + 1] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }

                    if (j - 1 >= 0 && board.getGameField()[i][j - 1] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }

                    if (j + 1 < GameBoard.dimension && board.getGameField()[i][j + 1] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }

                    if (i + 1 < GameBoard.dimension && j - 1 >= 0 && board.getGameField()[i + 1][j - 1] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }

                    if (i + 1 < GameBoard.dimension && board.getGameField()[i + 1][j] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }

                    if (i + 1 < GameBoard.dimension && j + 1 < GameBoard.dimension && board.getGameField()[i + 1][j + 1] == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        ++fieldScore;
                    }
                }

                if (fieldScore > maxScore) {
                    maxScore = fieldScore;
                    maxScoreFieldX = j;
                    maxScoreFieldY = i;
                }
            }
        }

        if (maxScoreFieldX != -1) {
            x = maxScoreFieldX;
            y = maxScoreFieldY;
        }

        if (x == -1) {
            Random random = new Random();

            do {
                x = random.nextInt(GameBoard.dimension);
                y = random.nextInt(GameBoard.dimension);
            } while(!board.isTurnable(x, y));

        }

        board.updateGameField(x, y);
        i = GameBoard.dimension * x + y;
        board.getButton(i).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        if (board.checkWin()) {
            this.button.getBoard().getGame().showMessage("Computer won");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }

    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(this.row, this.cell);
        this.button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        if (board.checkWin()) {
            this.button.getBoard().getGame().showMessage("You won");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }

    }
}
