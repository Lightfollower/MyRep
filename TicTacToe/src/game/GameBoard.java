package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimension = 3;
    static int cellSize = 150;
    private char[][] gameField;
    private GameButton[] gameButtons;

    private Game game;

    static char nullSymbol = '\u0000';

    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }

    private void initField(){
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);

        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        for(int i = 0; i < (dimension * dimension); i++){
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);

    }

    void emptField(){                                                   // Упростил очистку поля.
        for (int i = 0; i < (dimension * dimension); i++){
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[y][x] = nullSymbol;
        }
    }

    Game getGame() {
        return game;
    }

    boolean isTurnable(int x, int y){
        boolean result = false;

        if(gameField[y][x] == nullSymbol) {
            result = true;
        }

        return result;
    }

    void updateGameField(int x, int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    boolean cheakWin(){
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if(cheakWinDiagonals(playerSymbol) || cheakWinLins(playerSymbol)){
            result = true;
        }

        return result;
    }

    private boolean cheakWinDiagonals(char playerSymbol) {
        boolean left, right, result;

        left = true;
        right = true;
        result = false;

        for (int i = 0; i < dimension; i++){

            left &= (gameField[i][i] == playerSymbol);
            right &= (gameField[dimension - i - 1][i] == playerSymbol);
        }

        if (left || right){
            result = true;
        }

        return result;
    }

    private boolean cheakWinLins(char playerSymbol){
        boolean cols, rows, result;

        result = false;

        for (int col = 0; col < dimension; col++){
            cols = true;
            rows = true;

            for (int row = 0; row < dimension; row++ ){
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }

            if (cols || rows) {
                result = true;
                break;
            }
            if(result){
                break;
            }
        }

        return  result;
    }

    boolean isFull(){
        boolean result = true;

        /*for (int i = 0; i < dimension * dimension; i++){
            if (gameButtons[i].getText() == ""){
                result = false;
                break;
            }
        }*/

        for (int i = 0; i < (dimension * dimension); i++){   //Заменил двойной цикл

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            if (gameField[y][x] == nullSymbol);{
                result = false;
                break;
            }
        }

        return  result;
    }

    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }
}
