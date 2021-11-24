package pl.polsl.tomasz.krypczyk.tictactoe.game.model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Tomasz Krypczyk
 */
public class PlayerTest {

    public PlayerTest() {
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
     * Test of addPosition method, of class Player.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 0, -1, 243141, -313413})
    public void testAddPosition(int n) {
        System.out.println("addPosition");
        int position = n;
        ArrayList<Integer> expResult = new ArrayList<>();
        Player instance = new ComputerPlayer('X');
        instance.addPosition(position);
        expResult.add(n);
        assertEquals(expResult, instance.getPositions());
    }

    public class PlayerImpl extends Player {

        public PlayerImpl() {
            super("", ' ');
        }
    }

}
