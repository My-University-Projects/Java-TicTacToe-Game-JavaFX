package pl.polsl.tomasz.krypczyk.tictactoegame.model;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a human player
 */
public class HumanPlayer extends Player {
    
    /**
     * Integer with won rounds counter
     */
    private Integer playerScore;

    /**
     * HumanPlayer constructor
     *
     * @param argName players name
     * @param argSign sign of the player on the board
     */
    public HumanPlayer(String argName, char argSign) {
        super(argName, argSign);
    }
    
    /**
     * 
     * @param name
     * @param score 
     */
    public HumanPlayer(String name, Integer score){
        super(name, 'O');
        this.playerScore = score;
    }
    
    /**
     * Getter for players playerScore
     * @return 
     */
    public Integer getPlayerScore(){
        return this.playerScore;
    }
    
    /**
     * Method that increments players actual playerScore
     */
    public void incrementScore()
    {
        this.playerScore += 1;
    }
    

}
