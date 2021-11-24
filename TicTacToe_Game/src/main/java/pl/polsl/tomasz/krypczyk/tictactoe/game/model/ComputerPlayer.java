/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoe.game.model;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representantin a computer player
 */
public class ComputerPlayer extends Player {

    /**
     * ComputerPlayer contructor
     *
     * @param argSign sign on the board of the player
     */
    public ComputerPlayer(char argSign) {
        super("Cpu", argSign);
    }
}
