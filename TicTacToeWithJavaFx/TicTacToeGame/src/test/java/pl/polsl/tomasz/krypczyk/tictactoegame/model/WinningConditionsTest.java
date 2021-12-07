package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  WinningConditions model test class
 * @author Tomasz Krypczyk
 */
public class WinningConditionsTest {
    
    public WinningConditionsTest() {
    }

    
    /**
     * Test of checkWinConditions method, of class WinningConditions.
     */
    @Test
    public void testCheckWinConditionsWithpositiveWinConditions() {
        System.out.println("check Win Conditions with positive win conditions input");
        //GIVEN
        Player player = new ComputerPlayer('X');
        WinningConditions instance = new WinningConditions();
        player.addPosition(1);
        player.addPosition(2);
        player.addPosition(3);
        
        //WHEN
        boolean result = instance.checkWinConditions(player);
        
        //THEN
        assertTrue(result);
    }
    
     /**
     * Test of checkWinConditions method, of class WinningConditions.
     */
    @Test
    public void testCheckWinConditionsWithNegativeWinConditions() {
        System.out.println("check Win Conditions with negative win conditions input");
        //GIVEN
        Player player = new ComputerPlayer('X');
        WinningConditions instance = new WinningConditions();
        player.addPosition(4);
        player.addPosition(9);
        player.addPosition(3);
        
        //WHEN
        boolean result = instance.checkWinConditions(player);
        
        //THEN
        assertFalse(result);
    }
    
}
