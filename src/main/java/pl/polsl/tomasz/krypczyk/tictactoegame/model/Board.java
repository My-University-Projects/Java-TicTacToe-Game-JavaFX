package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a tictactoe game board
 */
public class Board {

    /**
     * char[][] game board
     */
    List<List<Character>> board;

    /**
     * Board constructor
     */
    public Board() {
        this.board = Arrays.asList(Arrays.asList(' ', '|', ' ', '|', ' '), Arrays.asList('-', '+', '-', '+', '-'), Arrays.asList(' ', '|', ' ', '|', ' '), Arrays.asList('-', '+', '-', '+', '-'), Arrays.asList(' ', '|', ' ', '|', ' '));
    }

    /**
     * getBoard gets a game board
     *
     * @return char[][] game board
     */
    public List<List<Character>> getBoard() {
        return this.board;
    }

    /**
     * clearBoard sets a clear board
     */
    public void clearBoard() {
        this.board = Arrays.asList(Arrays.asList(' ', '|', ' ', '|', ' '), Arrays.asList('-', '+', '-', '+', '-'), Arrays.asList(' ', '|', ' ', '|', ' '), Arrays.asList('-', '+', '-', '+', '-'), Arrays.asList(' ', '|', ' ', '|', ' '));
    }

    /**
     * updateBoard puts on a board sign in the chosen by player position
     *
     * @param player   actual player
     * @param position chosen by the player board element
     * @return boolean if update has been finished succesful
     */
    public boolean updateBoard(Player player, Integer position) {
        boolean result;
        int row, column;
        if (position <= 3 && position >= 1) {
            row = 0;
            column = this.calculateColumn(position);
            if (checkIfEmpty(this.board.get(row).get(column))) {
                this.board.get(row).set(column, player.getSign());
                result = true;
            } else {
                result = false;
            }
        } else if (position <= 6 && position >= 4) {
            row = 2;
            column = this.calculateColumn(position);
            if (checkIfEmpty(this.board.get(row).get(column))) {
                this.board.get(row).set(column, player.getSign());
                result = true;
            } else {
                result = false;
            }
        } else if (position <= 9 && position >= 7) {
            row = 4;
            column = this.calculateColumn(position);
            if (checkIfEmpty(this.board.get(row).get(column))) {
                this.board.get(row).set(column, player.getSign());
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
     *
     * @param position that players wants to put sign on
     * @return int the column on the game board
     */
    public int calculateColumn(Integer position) {

        int column;
        column = switch (position) {
            case 1, 4, 7 -> 0;
            case 2, 5, 8 -> 2;
            case 3, 6, 9 -> 4;
            default -> -1;
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
    public boolean checkIfEmpty(Character position) {
        return Objects.equals(' ', position);
    }
}
