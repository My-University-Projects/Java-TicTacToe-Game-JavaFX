/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
 * @author ASUS
 */
public class PrepareToMultiplayerGameController implements Initializable {

     //////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 
     */
    @FXML
    TextField firstPlayerNameTextField;
    
    /**
     * 
     */
    @FXML
    TextField secondPlayerNameTextField;
    
    /**
     * 
     */
    @FXML
    AnchorPane tooLongNameAnchorPane;
    
    /**
     * 
     */
    String firstPlayerName;
    
    /**
     * 
     */
    String secondPlayerName;
    
    /**
     * 
     */
    int gameMode;
    
     //////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.gameMode = 1;
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
     */
    @FXML
    private void takeFirstPlayerNameButtonClicked() throws TooLongNameException, IOException
    {
        try
        {
            if(this.firstPlayerNameTextField.getText().length() > 15)
            {
                throw new TooLongNameException("Za długa nazwa użytkownika");
            }
            this.firstPlayerName = this.firstPlayerNameTextField.getText();
        }
        catch(TooLongNameException x)
        {
            this.tooLongNameAnchorPane.setVisible(true);
            this.firstPlayerName = "Anonim";
        }
        this.firstPlayerNameTextField.setText("Zapisano!");
    }
    
    /**
     * 
     */
    @FXML
    private void takeSecondPlayerNameButtonClicked() throws TooLongNameException, IOException
    {
        try
        {
            if(this.secondPlayerNameTextField.getText().length() > 15)
            {
                throw new TooLongNameException("Za długa nazwa użytkownika");
            }
            this.secondPlayerName = this.secondPlayerNameTextField.getText();
        }
        catch(TooLongNameException x)
        {
            this.tooLongNameAnchorPane.setVisible(true);
            this.secondPlayerName = "Anonim";
        }
        this.secondPlayerNameTextField.setText("Zapisano!");
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
       this.passNamesToGameController();
       this.switchToGameController();
    }
    
    /**
     * 
     * @throws IOException 
     */
    void passNamesToGameController() throws IOException
    {
       FXMLLoader loader = new FXMLLoader(App.class.getResource("Game.fxml"));
       Parent root = (Parent) loader.load();
       GameController controller = loader.getController();
       
       String firstPlayerName = this.firstPlayerName;
       String secondPlayerName = this.secondPlayerName;
       int gameMode = this.gameMode;
       
       controller.setPlayer1Name(firstPlayerName);
       controller.setPlayer2Name(secondPlayerName);
       controller.setGameMode(gameMode);
    }
    
}
