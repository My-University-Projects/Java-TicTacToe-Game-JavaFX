package pl.polsl.tomasz.krypczyk.tictactoe.game.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.polsl.tomasz.krypczyk.tictactoe.game.controller.Controller;

/**
 *
 * @author Tomasz Krypczyk
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    
    /**
     * Test of clearBoard method, of class Board.
     */
    @Test
    public void testClearBoardWhenNonEmpty() {
        System.out.println("clearBoard");
        //GIVEN
        Board instance = new Board();
        Controller controller = new Controller();
        controller.updateBoard(instance, new ComputerPlayer('X'), 2);
        controller.updateBoard(instance, new ComputerPlayer('X'), 4);
        controller.updateBoard(instance, new ComputerPlayer('X'), 8);
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
        System.out.println("clearBoard");
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

}
