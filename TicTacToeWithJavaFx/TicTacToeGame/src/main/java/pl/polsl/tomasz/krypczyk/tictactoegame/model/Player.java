package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import java.util.ArrayList;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Abstract class representanting player
 */
public abstract class Player {

    /**
     *
     * String name contains a player name
     */
    String name;

    /**
     *
     * char sign contains a sign what player will put on the board(X or O)
     */
    char sign;

    /**
     *
     * ArrayList playerPositions Contains all player moves
     */
    ArrayList<Integer> playerPositions;

    /**
     * Player constructor
     *
     * @param argName players name
     * @param argSign players sign on the board
     */
    public Player(String argName, char argSign) {
        this.name = argName;
        this.sign = argSign;
        this.playerPositions = new ArrayList<>();
    }

    /**
     *
     * getPlayerName gets a players name
     *
     * @return String players name
     */
    public String getPlayerName() {
        return this.name;
    }

    /**
     *
     * getSign gets a players sign
     *
     * @return char players sign
     */
    public char getSign() {
        return this.sign;
    }

    /**
     *
     * getPositions gets a list of all taken positions of player
     *
     * @return ArrayList list of the player positions
     */
    public ArrayList<Integer> getPositions() {
        return this.playerPositions;
    }

    /**
     * clearPositions sets an empty positions list of player
     *
     */
    public void clearPositions() {
        this.playerPositions.clear();
    }

    /**
     *
     * addPosition adds a new position to the players position list
     *
     * @param position that player has taken
     */
    public void addPosition(int position) {
        this.playerPositions.add(position);
    }
    
    /**
     * monitorMove is responsible actions related to moves made by the players and 
     * checking correctness of these moves
     * @param board game board
     * @param position
     * @return 
     */
    public boolean monitorMove(Board board, int position) 
    {
        if (board.updateBoard(this, position) == true) 
        {
            this.addPosition(position);
            return true;
        }
        else
        {
           return false;
        }
    }
    
}
