package ticTacToe;

public class GamePlayer {
    private char playerSign;
    private boolean realPlayer = true;

    public GamePlayer(boolean realPlayer, char playerSign) {
        this.playerSign = playerSign;
        this.realPlayer = realPlayer;
    }

    public char getPlayerSign() {
        return this.playerSign;
    }

    public boolean isRealPlayer() {
        return this.realPlayer;
    }
}
