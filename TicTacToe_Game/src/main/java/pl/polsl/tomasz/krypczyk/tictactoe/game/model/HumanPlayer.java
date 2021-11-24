/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoe.game.model;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a human player
 */
public class HumanPlayer extends Player {

    /**
     * HumanPlayer constructor
     *
     * @param argName players name
     * @param argSign sign of the player on the board
     */
    public HumanPlayer(String argName, char argSign) {
        super(argName, argSign);
    }

}
