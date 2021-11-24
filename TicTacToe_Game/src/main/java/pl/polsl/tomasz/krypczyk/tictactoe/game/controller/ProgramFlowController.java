/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoe.game.controller;

import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.ComputerPlayer;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.GameStatus;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Player;
import pll.polsl.krypczyk.exceptions.TooLongNameException;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.WinningConditions;
import pl.polsl.tomasz.krypczyk.tictactoe.game.view.View;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 class responsible for controlling program
 */
public class ProgramFlowController {
    GameStatus status;

    /**
     * ProgramFlowController Constructor
     */
    public ProgramFlowController() {
    }

    ;
    
    /**
     * setter of a game status
     * @param status
     */
    public void setStatus(GameStatus status)
    {
        this.status = status;
    }
    
    public GameStatus getStatus(){
        return this.status;
    }
    
 /**
 * begin is responsible for all actions related to chosing player names, creating players and start a game
 * @param controller in MVC model
 * @param view in MVC model
  * @throws TooLongNameException
 */
    public void begin(Controller controller, View view) throws TooLongNameException {
        Board board = new Board();
        String firstPlayerName = view.takeFirstPlayerName(controller);
        String secondPlayerName = view.takeSecondPlayerName(controller);
        switch (secondPlayerName) {
            case "1" -> {
                Player player = controller.createPlayer(firstPlayerName, 'O');
                Player bot = controller.createPlayer("Cpu", 'X');
                while (true) {
                    this.status = GameStatus.InGame;
                    startGame(player, bot, board, view, controller);
                    if (view.nextGameQuestion() == false) {
                        this.status = GameStatus.Finished;
                        break;
                    }
                    controller.clearPositionsList(player);
                    controller.clearPositionsList(bot);
                    controller.clearBoard(board);
                }
            }
            default -> {
                Player player1 = controller.createPlayer(firstPlayerName, 'O');
                Player player2 = controller.createPlayer(secondPlayerName, 'X');
                while (true) {
                    this.status = GameStatus.InGame;
                    startGame(player1, player2, board, view, controller);
                    if (view.nextGameQuestion() == false) {
                        this.status = GameStatus.Finished;
                        break;
                    }
                    controller.clearPositionsList(player1);
                    controller.clearPositionsList(player2);
                    controller.clearBoard(board);
                }
            }
        }
    }

    /**
     * startGame is responsible for all actions made by players during the game,
     * catching errors and chose the winner of the game
     *
     * @param player1 first player
     * @param player2 second player
     * @param board game board
     * @param view in MVC model
     * @param controller in MVC model
     */
    public void startGame(Player player1, Player player2, Board board, View view, Controller controller) {
        WinningConditions winningConditions = new WinningConditions();
        int roundCount = 1;
        int player = 1;
        while (roundCount < 10) {
            switch (player) {
                case 1 -> {
                    view.printActualPlayer(controller.getPlayerName(player1));
                    view.printBoard(board);
                    monitorMove(player1, board, view, controller);
                    if (controller.checkWinConditions(player1, winningConditions) == true) {
                        view.printBoard(board);
                        view.winnerOfTheGame(player1);
                        return;
                    }
                    player++;
                }
                case 2 -> {
                    view.printActualPlayer(controller.getPlayerName(player2));
                    view.printBoard(board);
                    monitorMove(player2, board, view, controller);
                    if (controller.checkWinConditions(player2, winningConditions) == true) {
                        view.printBoard(board);
                        view.winnerOfTheGame(player2);
                        return;
                    }
                    player--;
                }
            }
            roundCount++;
        }
        view.printBoard(board);
        System.out.println(view.tie());
    }

    /**
     * monitorMove is responsible actions related to moves made by the players and
 checking correctness of these moves
     *
     * @param player actual player
     * @param board game board
     * @param view in MVC model
     * @param controller in MVC model
     */
    public void monitorMove(Player player, Board board, View view, Controller controller) {
        int intPosition;
        if (player instanceof ComputerPlayer == true) {
            while (true) {
                intPosition = 1 + (int) (Math.random() * 9);
                if (controller.updateBoard(board, player, intPosition) == true) {
                    controller.addPlayerPosition(player, intPosition);
                    break;
                }
            }
        } else {
            String position;
            while (1 == 1) {
                position = view.takePosition();
                try {
                    intPosition = Integer.parseInt(position);
                } catch (NumberFormatException x) {
                    System.out.println("Wpisałeś nieprawidłową liczbę!");
                    continue;
                }
                if (controller.updateBoard(board, player, intPosition) == true) {
                    controller.addPlayerPosition(player, intPosition);
                    break;
                }
                System.out.println("Coś poszło nie tak, Spróbuj jeszcze raz");
            }
        }
    }
}
