package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoegame.GameController;

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
    public void testClearBoardWhenNonEmpty() {
        System.out.println("clearBoard");
        //GIVEN
        Board instance = new Board();
        GameController controller = new GameController();
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