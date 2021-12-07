package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Tomasz Krypczyk
 */
public class BoardTest {
    
    public BoardTest() {
    }

    /**
     * Test of clearBoard method, of class Board.
     */
    @Test
    public void testClearBoardWhenNotEmpty() {
        System.out.println("clear Board when not empty");
        //GIVEN
        Board instance = new Board();
        instance.updateBoard(new ComputerPlayer('X'), 2);
        instance.updateBoard(new ComputerPlayer('X'), 4);
        instance.updateBoard(new ComputerPlayer('X'), 8);
        char[][] expResult = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};
        
        //WHEN
        instance.clearBoard();
        
        //THEN
        assertArrayEquals(expResult, instance.getBoard());
    }
    
    /**
     * Test of clearBoard method, of class Board.
     */
    @Test
    public void testClearBoardWhenEmpty() {
        System.out.println("clear Board when empty");
        //GIVEN
        Board instance = new Board();
        char[][] expResult = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};
        
        //WHEN
        instance.clearBoard();
        
        //THEN
        assertArrayEquals(expResult, instance.getBoard());
    }

    /**
     * Test of updateBoard method, of class Board.
     * @param n
     */
    @ParameterizedTest
    @ValueSource (ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void testUpdateBoardWithPositiveInput(int n) {
        System.out.println("update Board with positive input");
        
        //GIVEN
        Board board = new Board();
        Player player = new ComputerPlayer('X');
        int el = n;
        //boolean expResult = (n < 10 && n > 0);
        
        //WHEN
        boolean result;
        result = board.updateBoard(player, el);
        
        //THEN
        assertTrue(result);
    }
    
    /**
     * Test of updateBoard method, of class Board.
     * @param n
     */
    @ParameterizedTest
    @ValueSource (ints = {10, -1, 0, -1223, 1213131, -203829328})
    public void testUpdateBoardWithNegativeInput(int n) {
        System.out.println("update Board with negative input");
        
        //GIVEN
        Board board = new Board();
        Player player = new ComputerPlayer('X');
        int el = n;
        //boolean expResult = (n < 10 && n > 0);
        
        //WHEN
        boolean result;
        result = board.updateBoard(player, el);
        
        //THEN
        assertFalse(result);
    }

    /**
     * Test of calculateColumn method, of class Board.
     * @param n
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void testCalculateColumnWithPositiveInput(int n) {
        System.out.println("calculate Column with positive input");
        //GIVEN
        int position = n;
        Board board = new Board();
        int expResult = switch (n) {
            case 1 ->
                0;
            case 2 ->
                2;
            case 3 ->
                4;
            case 4 ->
                0;
            case 5 ->
                2;
            case 6 ->
                4;
            case 7 ->
                0;
            case 8 ->
                2;
            case 9 ->
                4;
            default ->
                -1;
        };
      
        //WHEN
        int result = board.calculateColumn(position);
        
        //THEN
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculateColumn method, of class Controller.
     * @param n
     */
    @ParameterizedTest
    @ValueSource(ints = {10, 121, 21213, 13, -21, -2, 0})
    public void testCalculateColumnWithNegativeInput(int n) {
        //GIVEN
        System.out.println("calculate Column with negative input");
        int position = n;
        Board instance = new Board();
        int expResult = -1;
        
      
        //WHEN
        int result = instance.calculateColumn(position);
        
        //THEN
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkIfEmpty method, of class Controller.
     */
    @Test
    public void testCheckIfEmptyWhenEmpty() {
        //GIVEN
        
        System.out.println("check If Empty when tile is empty");
        char position = ' ';
        Board instance = new Board();
        //boolean expResult = true;
        
        // WHEN
        boolean result = instance.checkIfEmpty(position);
        
        //THEN
        assertTrue(result);
    }
    
    /**
     * Test of checkIfEmpty method, of class Controller.
     */
    @Test
    public void testCheckIfEmptyWhenNotEmpty() {
        
        //GIVEN
        System.out.println("check If Empty when tile is not empty");
        char position = 'n';
        Board instance = new Board();
        //boolean expResult = true;
        
        // WHEN
        boolean result = instance.checkIfEmpty(position);
        
        //THEN
        assertFalse(result);
    }
    
}
