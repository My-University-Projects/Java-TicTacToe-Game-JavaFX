package pl.polsl.tomasz.krypczyk.tictactoe.game.model;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a tictactoe game board
 */
public class Board {

    /**
     * char[][] game board
     */
    char[][] board;

    /**
     * Board constructor
     */
    public Board() {
        this.board = new char[][]{{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};
    }

    /**
     * getBoard gets a game board
     *
     * @return char[][] game board
     */
    public char[][] getBoard() {
        return this.board;
    }

    /**
     * clearBoard sets a clear board
     */
    public void clearBoard() {
        this.board = new char[][]{{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};
    }
}
