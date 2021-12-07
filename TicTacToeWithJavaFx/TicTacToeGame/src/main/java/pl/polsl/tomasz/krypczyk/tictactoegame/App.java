package pl.polsl.tomasz.krypczyk.tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App class
 */
public class App extends Application {

    /**
     * Field representanting a scene in App class
     */
    private static Scene mainMenuScene;
////////////////////////////////////////////////////////////////////////////////
    
    /**
     * GUI loading method
     * @param stage
     * @throws IOException 
     */
    @Override
    public void start(Stage stage) throws IOException {
        
        mainMenuScene = new Scene(loadFXML("MainMenu"), 800, 600);
        stage.setScene(mainMenuScene);
        stage.show();
        
    }

    /**
     * Seeting root method
     * @param fxml
     * @throws IOException 
     */
    static void setRoot(String fxml) throws IOException {
        mainMenuScene.setRoot(loadFXML(fxml));
    }

    /**
     * Loading FXML method
     * @param fxml
     * @return
     * @throws IOException 
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main method in App class
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }

}