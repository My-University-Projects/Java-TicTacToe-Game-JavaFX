package pl.polsl.tomasz.krypczyk.tictactoegame;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import pl.polsl.tomasz.krypczyk.tictactoegame.exception.TooLongNameException;

public class MainMenuController {
      
    /**
     * 
     * @throws IOException 
     */
    @FXML
    private void switchToSingleplayerGameController() throws IOException {
        App.setRoot("PrepareToSingleplayerGame");
    }
    
    /**
     * 
     * @param fxml
     * @return
     * @throws IOException 
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /**
     * 
     * @throws IOException 
     */
    private void switchToMultiPlsyerGameController() throws IOException{
        App.setRoot("PrepareToMultiPlayerGame");
    }
    
    /**
     * 
     * @throws TooLongNameException
     * @throws IOException 
     */
    @FXML private void soloPlayerGameClicked() throws TooLongNameException, IOException
    {
        this.switchToSingleplayerGameController();
    }
    
    /**
     * 
     * @throws TooLongNameException
     * @throws IOException 
     */
    @FXML
    private void multiplayerGameClicked() throws TooLongNameException, IOException
    {
        this.switchToMultiPlsyerGameController();      
    }
 
}
