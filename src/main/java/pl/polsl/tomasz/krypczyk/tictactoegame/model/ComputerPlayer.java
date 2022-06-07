package pl.polsl.tomasz.krypczyk.tictactoegame.model;

/**
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
