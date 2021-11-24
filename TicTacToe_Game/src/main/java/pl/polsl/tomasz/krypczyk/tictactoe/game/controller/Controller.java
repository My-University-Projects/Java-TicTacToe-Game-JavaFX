/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoe.game.controller;

import java.util.List;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Player;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.HumanPlayer;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.ComputerPlayer;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.WinningConditions;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a game controller in mvc model
 */
public class Controller {

    /**
     * Controller constructor
     */
    public Controller() {
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

    /**
     * calculateColumn calculates depending on chosen by the player position
     *
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
     * updateBoard puts on a board sign in the chosen by player position
     *
     * @param board game board
     * @param player actual player
     * @param el chosen by the player board element
     * @return boolean if update has been finished succesful
     */
    public boolean updateBoard(Board board, Player player, int el) {
        boolean result;
        int row, column;
        if (el <= 3 && el >= 1) {
            row = 0;
            column = this.calculateColumn(el);
            if (checkIfEmpty(board.getBoard()[row][column]) == true) {
                board.getBoard()[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else if (el <= 6 && el >= 4) {
            row = 2;
            column = this.calculateColumn(el);
            if (checkIfEmpty(board.getBoard()[row][column]) == true) {
                board.getBoard()[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else if (el <= 9 && el >= 7) {
            row = 4;
            column = this.calculateColumn(el);
            if (checkIfEmpty(board.getBoard()[row][column]) == true) {
                board.getBoard()[row][column] = player.getSign();
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
     * checkWinConditions checks that actual player sign positions are winning
     * positions
     *
     * @param player actual player
     * @param winningConditions list of the winning positions
     * @return boolean if positions of actual player meet the winning conditions
     */
    public boolean checkWinConditions(Player player, WinningConditions winningConditions) {
        boolean result = false;
        for (List el : winningConditions.getWinningPositions()) {
            if (player.getPositions().containsAll(el)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * getPlayerName gets a name of the player
     *
     * @param player that name we need
     * @return String players name
     */
    public String getPlayerName(Player player) {
        return player.getPlayerName();
    }

    /**
     * addPlayerPosition adds a position to list of actual player position
     *
     * @param player that made a move
     * @param position that player has put sign on
     */
    public void addPlayerPosition(Player player, int position) {
        player.addPosition(position);
    }

    /**
     * createPlayer creates a object of the player
     *
     * @param playerName name of the player
     * @param playerSign sign of the player(X or O)
     * @return Player instance
     */
    public Player createPlayer(String playerName, char playerSign) {

        if ("Cpu".equals(playerName)) {
            Player newPlayer = new ComputerPlayer(playerSign);
            return newPlayer;
        }
        Player newPlayer = new HumanPlayer(playerName, playerSign);
        return newPlayer;
    }

    /**
     * clearBoard clears a board for new game
     *
     * @param board from last game
     */
    public void clearBoard(Board board) {
        board.clearBoard();
    }

    /**
     * clearPositionsList removes all saved moves of the player
     *
     * @param player actual player
     */
    public void clearPositionsList(Player player) {
        player.setPositions();
    }

    /**
     * handleException handles my own exception thrown during the game
     *
     * @return String players name
     */
    public String handleException() {
        return "Anonim";
    }
}
