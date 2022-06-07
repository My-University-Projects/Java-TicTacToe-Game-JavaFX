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
 * Prepare to multi player game Controller class
 *
 * @author Tomasz Krypczyk
 */
public class PrepareToMultiplayerGameController implements Initializable {

    //////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Textfield with first player name
     */
    @FXML
    TextField firstPlayerNameTextField;

    /**
     * Textfield with second player name
     */
    @FXML
    TextField secondPlayerNameTextField;

    /**
     * Pane with too Long name error message
     */
    @FXML
    AnchorPane tooLongNameAnchorPane;

    /**
     * String with first player name
     */
    String firstPlayerName;

    /**
     * String with second player name
     */
    String secondPlayerName;

    /**
     * Int representanting actual game mode
     */
    int gameMode;

    //////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.gameMode = 1;
    }

    /**
     * Method that switched root to gsme controller
     *
     * @throws IOException
     */
    @FXML
    private void switchToGameController() throws IOException {
        App.setRoot("Game");
    }

    /**
     * Method that takes first player name from the text field
     */
    @FXML
    private void takeFirstPlayerNameButtonClicked() throws TooLongNameException, IOException {
        try {
            if (this.firstPlayerNameTextField.getText().length() > 15) {
                throw new TooLongNameException("Za długa nazwa użytkownika");
            }
            this.firstPlayerName = this.firstPlayerNameTextField.getText();
        } catch (TooLongNameException e) {
            this.tooLongNameAnchorPane.setVisible(true);
            this.firstPlayerName = "Anonim";
        }
        this.firstPlayerNameTextField.setText("Zapisano!");
    }

    /**
     * Method that takes second player name from the textfield
     */
    @FXML
    private void takeSecondPlayerNameButtonClicked() {
        try {
            if (this.secondPlayerNameTextField.getText().length() > 15) {
                throw new TooLongNameException("Za długa nazwa użytkownika");
            }
            this.secondPlayerName = this.secondPlayerNameTextField.getText();
        } catch (TooLongNameException e) {
            this.tooLongNameAnchorPane.setVisible(true);
            this.secondPlayerName = "Anonim";
        }
        this.secondPlayerNameTextField.setText("Zapisano!");
    }

    /**
     * Method activated when players name is too long
     */
    @FXML
    private void tooLongNameButtonClicked() {
        this.tooLongNameAnchorPane.setVisible(false);
    }

    /**
     * Starting game method
     *
     * @throws IOException
     */
    @FXML
    private void startGameButtonClicked() throws IOException {
        this.passNamesToGameController();
        this.switchToGameController();
    }

    /**
     * Method that passes names of the players and game mode to gsme controller
     *
     * @throws IOException
     */
    void passNamesToGameController() throws IOException {
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
