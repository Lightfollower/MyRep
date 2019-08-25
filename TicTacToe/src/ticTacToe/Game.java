package ticTacToe;

import javax.swing.JOptionPane;

public class Game {
    private GameBoard board = new GameBoard(this);
    private GamePlayer[] gamePlayers = new GamePlayer[2];
    private int playersTurn = 0;

    public Game() {
    }

    public void initGame() {
        this.gamePlayers[0] = new GamePlayer(true, 'X');
        this.gamePlayers[1] = new GamePlayer(false, '0');
    }

    void passTurn() {
        this.playersTurn = this.playersTurn == 0 ? 1 : 0;
    }

    GamePlayer getCurrentPlayer() {
        return this.gamePlayers[this.playersTurn];
    }

    void showMessage(String messageText) {
        JOptionPane.showMessageDialog(this.board, messageText);
    }

    public GameBoard getBoard() {
        return board;
    }

    public void setPlayersTurn(int playersTurn) {
        this.playersTurn = playersTurn;
    }
}