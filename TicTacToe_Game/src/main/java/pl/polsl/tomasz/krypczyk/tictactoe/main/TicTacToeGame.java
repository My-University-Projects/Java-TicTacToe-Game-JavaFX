/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoe.main;

import pl.polsl.tomasz.krypczyk.tictactoe.game.controller.Controller;
import pl.polsl.tomasz.krypczyk.tictactoe.game.controller.ProgramFlowController;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.GameStatus;
import pll.polsl.krypczyk.exceptions.TooLongNameException;
import pl.polsl.tomasz.krypczyk.tictactoe.game.view.View;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Simple console tic tac toe game
 */
public class TicTacToeGame {

    /**
     * main method in the program
     *
     * @param args from the command line, but in this case there are no
     * arguments passed to main
     * @throws TooLongNameException
     */
    public static void main(String[] args) throws TooLongNameException {
        ProgramFlowController programFlowController = new ProgramFlowController();
        programFlowController.setStatus(GameStatus.Started);
        Controller controller = new Controller();
        View view = new View();
        programFlowController.begin(controller, view);
    }
}
