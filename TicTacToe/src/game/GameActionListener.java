package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton){
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if(board.isTurnable(row, cell)){
            updateByPlayerData(board);

            if(board.isFull()){
                board.getGame().showMessage("Ничья");
                board.emptField();
            }else{
                updateByAiData(board);
            }
        } else {
            board.getGame().showMessage("Некорректный ход");
        }

    }

    private void updateByAiData(GameBoard board) {
        int x, y;
        Random rnd = new Random();

        do {
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
        } while (!board.isTurnable(x, y));

        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.cheakWin()){
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptField();
        } else {
            board.getGame().passTurn();
        }
    }

    private void updateByPlayerData(GameBoard board) {
        board.updateGameField(row, cell);
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.cheakWin()){
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptField();
        } else {
            board.getGame().passTurn();
        }
    }
}
