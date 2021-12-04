package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import java.util.ArrayList;
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
    
    /**
     * Test of addPosition method, of class Player.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
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