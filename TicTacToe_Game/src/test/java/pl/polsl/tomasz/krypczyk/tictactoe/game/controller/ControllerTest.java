/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoe.game.controller;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.ComputerPlayer;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.HumanPlayer;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Player;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.WinningConditions;

/**
 *
 * @author ASUS
 */
public class ControllerTest {
    
    public ControllerTest() {
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
     * Test of checkIfEmpty method, of class Controller.
     */
    @Test
    public void testCheckIfEmptyWhenEmpty() {
        //GIVEN
        
        System.out.println("checkIfEmpty");
        char position = ' ';
        Controller instance = new Controller();
        //boolean expResult = true;
        
        // WHEN
        boolean result = instance.checkIfEmpty(position);
        
        //THEN
        assertTrue(result);
    }
    
    /**
     * Test of checkIfEmpty method, of class Controller.
     */
    @ParameterizedTest
    @ValueSource (chars = {'x', 'd', 'W', 'R'})
    public void testCheckIfEmptyWhenNotEmpty(char n) {
        //GIVEN
        
        System.out.println("checkIfEmpty");
        char position = n;
        Controller instance = new Controller();
        //boolean expResult = true;
        
        // WHEN
        boolean result = instance.checkIfEmpty(position);
        
        //THEN
        assertFalse(result);
    }

    /**
     * Test of calculateColumn method, of class Controller.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 121, 21213, 13, -21, -2, 0})
    public void testCalculateColumnWithPositiveInput(int n) {
        //GIVEN
        System.out.println("calculateColumn");
        int position = n;
        Controller instance = new Controller();
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
        int result = instance.calculateColumn(position);
        
        //THEN
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateColumn method, of class Controller.
     */
    @ParameterizedTest
    @ValueSource(ints = {10, 121, 21213, 13, -21, -2, 0})
    public void testCalculateColumnWithNegativeInput(int n) {
        //GIVEN
        System.out.println("calculateColumn");
        int position = n;
        Controller instance = new Controller();
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
        int result = instance.calculateColumn(position);
        
        //THEN
        assertEquals(expResult, result);
    }
    
    /**
     * Test of updateBoard method, of class Controller.
     */
    @ParameterizedTest
    @ValueSource (ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void testUpdateBoardWithPositiveInput(int n) {
        //GIVEN
        System.out.println("updateBoard");
        Board board = new Board();
        Player player = new ComputerPlayer('X');
        int el = n;
        Controller instance = new Controller();
        boolean expResult = (n < 10 && n > 0);
        
        //WHEN
        boolean result = instance.updateBoard(board, player, el);
        
        //THEN
        assertEquals(expResult, result);
    }
    
    /**
     * Test of updateBoard method, of class Controller.
     */
    @ParameterizedTest
    @ValueSource (ints = {10, -1, 0, -1223, 1213131, -203829328})
    public void testUpdateBoardWithNegativeInput(int n) {
        //GIVEN
        System.out.println("updateBoard");
        Board board = new Board();
        Player player = new ComputerPlayer('X');
        int el = n;
        Controller instance = new Controller();
        boolean expResult = (n < 10 && n > 0);
        
        //WHEN
        boolean result = instance.updateBoard(board, player, el);
        
        //THEN
        assertEquals(expResult, result);
    }

    /**
     * Test of checkWinConditions method, of class Controller.
     */
    @Test
    public void testCheckWinConditionsWithPositiveWinningConditions() {
        //GIVEN
        System.out.println("checkWinConditions");
        Player player = new ComputerPlayer('O');
        WinningConditions winningConditions = new WinningConditions();
        Controller instance = new Controller();
        player.addPosition(1);
        player.addPosition(2);
        player.addPosition(3);
        //boolean expResult = true;
        
        //WHEN
        boolean result = instance.checkWinConditions(player, winningConditions);
        
        //THEN
        assertTrue(result);
    }
    
    /**
     * Test of checkWinConditions method, of class Controller.
     */
    @Test
    public void testCheckWinConditionsWithNegativeWinningConditions() {
        //GIVEN
        System.out.println("checkWinConditions");
        Player player = new ComputerPlayer('O');
        WinningConditions winningConditions = new WinningConditions();
        Controller instance = new Controller();
        player.addPosition(5);
        player.addPosition(3);
        player.addPosition(2);
        //boolean expResult = true;
        
        //WHEN
        boolean result = instance.checkWinConditions(player, winningConditions);
        
        //THEN
        assertFalse(result);
    }
    
/**
     * Test of checkWinConditions method, of class Controller.
     */
    @Test
    public void testCheckWinConditionsWithEmptyPositionsList() {
        //GIVEN
        System.out.println("checkWinConditions");
        Player player = new ComputerPlayer('O');
        WinningConditions winningConditions = new WinningConditions();
        Controller instance = new Controller();
        //boolean expResult = true;
        
        //WHEN
        boolean result = instance.checkWinConditions(player, winningConditions);
        
        //THEN
        assertFalse(result);
    }
    
    
    /**
     * Test of getPlayerName method, of class Controller.
     */
    @ParameterizedTest
    @ValueSource (strings = {"Tomasz", "Jan", "", "sweweweweqfefewff", " "})
    public void testGetPlayerName(String n) {
        //GIVEN
        System.out.println("getPlayerName");
        Player player = new HumanPlayer(n, 'O');
        Controller instance = new Controller();
        String expResult = n;
        
        //WHEN
        String result = instance.getPlayerName(player);
        
        //THEN
        assertEquals(expResult, result);
    }

    
    /**
     * Test of clearPositionsList method, of class Controller.
     */
    @Test
    public void testClearPositionsListWhenNotEmpty() {
        //GIVEN
        System.out.println("clearPositionsList");
        Player player = new ComputerPlayer('X');
        Controller instance = new Controller();
        instance.addPlayerPosition(player, 1);
        instance.addPlayerPosition(player, 2);
        ArrayList<Integer> expResult = new ArrayList<>();
        
        //WHEN
        instance.clearPositionsList(player);
        
        //THEN
        assertEquals(expResult, player.getPositions());
    }
    
    /**
     * Test of clearPositionsList method, of class Controller.
     */
    @Test
    public void testClearPositionsListWhenEmpty() {
        //GIVEN
        System.out.println("clearPositionsList");
        Player player = new ComputerPlayer('X');
        Controller instance = new Controller();
        ArrayList<Integer> expResult = new ArrayList<>();
        
        //WHEN
        instance.clearPositionsList(player);
        
        //THEN
        assertEquals(expResult, player.getPositions());
    }

    /**
     * Test of handleException method, of class Controller.
     */
    @Test
    public void testHandleException() {
        //GIVEN
        System.out.println("handleException");
        Controller instance = new Controller();
        String expResult = "Anonim";
        
        //WHEN
        String result = instance.handleException();
        
        //THEN
        assertEquals(expResult, result);
    }
    
}
