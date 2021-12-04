package pl.polsl.tomasz.krypczyk.tictactoegame.model;

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
