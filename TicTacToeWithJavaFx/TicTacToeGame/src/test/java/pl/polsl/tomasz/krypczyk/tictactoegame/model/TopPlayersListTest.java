package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tomasz Krypczyk
 */
public class TopPlayersListTest {
    
    public TopPlayersListTest() {
    }

   
    @Test
    public void testSaveListToFile() throws Exception {
        System.out.println("saveListToFile");
        TopPlayersList instance = new TopPlayersList();
        instance.saveListToFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortPlayersList method, of class TopPlayersList.
     */
    @Test
    public void testSortPlayersList() {
        System.out.println("sortPlayersList");
        
        //GIVEN
        TopPlayersList instance = new TopPlayersList();
        instance.addPlayerToList("Aaa");
        instance.addPlayerToList("Aaa");
        instance.addPlayerToList("Bbb");
        
        //WHEN
        instance.sortPlayersList();
        
        instance.sortPlayersList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
