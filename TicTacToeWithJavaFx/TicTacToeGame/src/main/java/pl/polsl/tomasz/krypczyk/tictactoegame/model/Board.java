package pl.polsl.tomasz.krypczyk.tictactoegame.model;

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
    
    /**
     * updateBoard puts on a board sign in the chosen by player position
     * @param player actual player
     * @param el chosen by the player board element
     * @return boolean if update has been finished succesful
     */
    public boolean updateBoard(Player player, int el) {
        boolean result;
        int row, column;
        if (el <= 3 && el >= 1) {
            row = 0;
            column = this.calculateColumn(el);
            if (checkIfEmpty(this.board[row][column]) == true) {
                this.board[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else if (el <= 6 && el >= 4) {
            row = 2;
            column = this.calculateColumn(el);
            if (checkIfEmpty(this.board[row][column]) == true) {
                this.board[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else if (el <= 9 && el >= 7) {
            row = 4;
            column = this.calculateColumn(el);
            if (checkIfEmpty(this.board[row][column]) == true) {
                this.board[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
    
    /**
     * calculateColumn calculates depending on chosen by the player position
     * @param position that players wants to put sign on
     * @return int the column on the game board
     */
    public int calculateColumn(int position) {

        int column;
        column = switch (position) {
            case 1 ->
                0;
            case 2 ->
                2;
            case 3 ->
                4;
            case 4 ->
                0;
            case 5 ->
                2;
            case 6 ->
                4;
            case 7 ->
                0;
            case 8 ->
                2;
            case 9 ->
                4;
            default ->
                -1;
        };
        return column;
    }
    
    /**
     * checkIfEmpty checks that actual position is avaible for player to put
     * sign on
     *
     * @param position that players wants to put sign on
     * @return boolean true if positon is empty
     */
    public boolean checkIfEmpty(char position) {
        return position == ' ';
    }
}
