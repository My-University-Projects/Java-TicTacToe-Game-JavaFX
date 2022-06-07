/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoegame;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pl.polsl.tomasz.krypczyk.tictactoegame.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.Player;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.WinningConditions;


/**
 *
 * @author Tomasz Krypczyk
 */
public class GameControllerTest {
    
    public GameControllerTest() {
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

    @Test
    public void testCreatePlayer() {
        System.out.println("createPlayer");
        String playerName = "";
        char playerSign = ' ';
        GameController instance = new GameController();
        Player expResult = null;
        Player result = instance.createPlayer(playerName, playerSign);
        assertEquals(expResult, result);
    }

    /**
     * Test of clearPositionsList method, of class GameController.
     */
    @Test
    public void testClearPositionsList() {
        System.out.println("clearPositionsList");
        Player player = null;
        GameController instance = new GameController();
        instance.clearPositionsList(player);
    }

    
    /**
     * Test of addPlayerPosition method, of class GameController.
     */
    @Test
    public void testAddPlayerPosition() {
        System.out.println("addPlayerPosition");
        Player player = null;
        int position = 0;
        GameController instance = new GameController();
        instance.addPlayerPosition(player, position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
