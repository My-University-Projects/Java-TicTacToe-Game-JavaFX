package pl.polsl.tomasz.krypczyk.tictactoegame;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import pl.polsl.tomasz.krypczyk.tictactoegame.exception.TooLongNameException;

/**
 * Class representanting controller of main menu view
 *
 * @author Tomasz Krypczyk
 */
public class MainMenuController {

    /**
     * Method that switches to single game preparing controller
     *
     * @throws IOException
     */
    @FXML
    private void switchToSingleplayerGameController() throws IOException {
        App.setRoot("PrepareToSingleplayerGame");
    }

    /**
     * FXML load method
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
     * Method that switches to multi player game preparing controller
     *
     * @throws IOException when fxml not found
     */
    private void switchToMultiPlayerGameController() throws IOException {
        App.setRoot("PrepareToMultiPlayerGame");
    }

    /**
     * method that starts when solo player game button is clicked
     *
     * @throws TooLongNameException when players name is too long
     * @throws IOException when fxml is not found
     */
    @FXML
    private void soloPlayerGameClicked() throws TooLongNameException, IOException {
        this.switchToSingleplayerGameController();
    }

    /**
     * method that starts when multi player game button is clicked
     *
     * @throws TooLongNameException when the names is too long
     * @throws IOException when fxml is not founs
     */
    @FXML
    private void multiplayerGameClicked() throws TooLongNameException, IOException {
        this.switchToMultiPlayerGameController();
    }

    /**
     * Method that closes the program
     */
    @FXML
    private void leaveGame() {
        System.exit(0);
    }
}
