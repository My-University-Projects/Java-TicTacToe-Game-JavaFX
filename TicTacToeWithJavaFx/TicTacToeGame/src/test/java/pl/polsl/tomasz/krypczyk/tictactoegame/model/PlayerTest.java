package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Player model tests class
 * @author Tomasz Krypczyk
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

     /**
     * Test of clearPositionsList method, of class Controller.
     */
    @Test
    public void testClearPositionsListWhenNotEmpty() {
        //GIVEN
        System.out.println("clear Positions List when its not empty");
        Player instance = new ComputerPlayer('X');
        ArrayList<Integer> expResult = new ArrayList<>();
        instance.addPosition(0);
        instance.addPosition(3);
        
        //WHEN
        instance.clearPositions();
        
        //THEN
        assertEquals(expResult, instance.getPositions());
    }
    /**
     * Test of clearPositionsList method, of class Controller.
     */
    @Test
    public void testClearPositionsListWhenEmpty() {
        //GIVEN
        System.out.println("clear Positions List when its empty");
        Player instance = new ComputerPlayer('X');
        ArrayList<Integer> expResult = new ArrayList<>();
        
        //WHEN
        instance.clearPositions();
        
        //THEN
        assertEquals(expResult, instance.getPositions());
    }

    /**
     * Test of addPosition method, of class Player.
     */
    @Test
    public void testAddPosition() {
        System.out.println("add Position");
        
        //GIVEN
        int position = 0;
        Player instance = new ComputerPlayer('X');
        
        ArrayList<Integer> expResult = new ArrayList<>();
        
        
        //WHEN
        expResult.add(position);
        instance.addPosition(position);
        
        //THEN
        assertEquals(expResult, instance.getPositions());
    }

    /**
     * Test of monitorMove method, of class Player.
     */
    @Test
    public void testMonitorMoveWithPositiveInput() {
        System.out.println("monitor Move wiht positive input");
        
        //GIVEN
        Player player = new ComputerPlayer('X');
        Board board = new Board();
        int position = 5;
        
        //WHEN
        boolean result = player.monitorMove(board, position);
        
        //THEN
        assertTrue(result);
    }

    
    /**
     * Test of monitorMove method, of class Player.
     */
    @Test
    public void testMonitorMoveWithNegativeInput() {
        System.out.println("monitor Move with negative input");
        
        //GIVEN
        Player player = new ComputerPlayer('X');
        Board board = new Board();
        int position = -13;
        
        //WHEN
        boolean result = player.monitorMove(board, position);
        
        //THEN
        assertFalse(result);
    }
    
    public class PlayerImpl extends Player {

        public PlayerImpl() {
            super("", ' ');
        }
    }
    
}
