package pl.polsl.tomasz.krypczyk.tictactoegame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import pl.polsl.tomasz.krypczyk.tictactoegame.exception.TooLongNameException;

/**
 * FXML Controller class
 *
 * @author Tomasz Krypczyk
 */
public class PrepareToSingleplayerGameController implements Initializable {

    //////////////////////////////////////////////////////////////////////////////////////////////
    
     /**
     * 
     */
    int gameMode;
    
    /**
     * 
     */
    String playerName;
    
    /**
     * 
     */
    @FXML
    TextField firstPlayerNameTextField;
    
    /**
     * 
     */
    @FXML
    AnchorPane tooLongNameAnchorPane;
    
     ///////////////////////////////////////////SETTERS AND GETTERS///////////////////////////////////////////////////
    /**
     * 
     * @return players name
     */
    public String getPlayerName()
    {
        return this.playerName;
    }
    
     //////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.gameMode = 0;
    }
    
    /**
     * 
     * @throws IOException 
     */
    @FXML
    private void switchToGameController() throws IOException
    {
        App.setRoot("Game");
    }

    /**
     * 
     * @throws TooLongNameException
     * @throws IOException 
     */
    @FXML
    private void takeFirstPlayerNameButtonClicked () throws TooLongNameException, IOException
    {
        try
        {
            if(this.firstPlayerNameTextField.getText().length() > 15)
            {
                throw new TooLongNameException("Za długa nazwa użytkownika");
            }
            this.playerName = this.firstPlayerNameTextField.getText();
        }
        catch(TooLongNameException x)
        {
            this.tooLongNameAnchorPane.setVisible(true);
            this.playerName = "Anonim";
        }

        this.firstPlayerNameTextField.setText("Zapisano!");
    }
    
    /**
     * 
     */
    @FXML
    private void tooLongNameButtonClicked()
    {
        this.tooLongNameAnchorPane.setVisible(false);
    }
    
    /**
     * 
     * @throws IOException 
     */
    @FXML
    private void startGameButtonClicked() throws IOException
    {
       this.passDataToGameController();
       this.switchToGameController();
    }
    
    void passDataToGameController() throws IOException
    {
       FXMLLoader loader = new FXMLLoader(App.class.getResource("Game.fxml"));
       Parent root = (Parent) loader.load();
       GameController controller = loader.getController();
       
       String name = this.playerName;
       int gameMod = this.gameMode;
       controller.setPlayer1Name(name);
       controller.setPlayer2Name("Cpu");
       controller.setGameMode(gameMod);
    }
    
}
