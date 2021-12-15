package pl.polsl.tomasz.krypczyk.tictactoegame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.ComputerPlayer;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.GameStatus;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.HumanPlayer;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.Player;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.TopPlayersList;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.WinningConditions;

/**
 * Controller of the game class
 *
 * @author Tomasz Krypczyk
 */
public class GameController implements Initializable {

    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Label with first player name
     */
    @FXML
    private Label player1Label;

    /**
     * Label with first player wins counter
     */
    @FXML
    private Label player1WinsCountLabel;
    
    /**
     * Column with player names
     */
    @FXML
    private TableColumn PlayerNameColumn;
    
    /**
     * Column with player scores
     */
    @FXML
    private TableColumn PlayerScoreColumn;
    
    /**
     * Table of top players
     */
    @FXML
    private TableView TopPlayersTable;

    /**
     * Label with seconds player name
     */
    @FXML
    private Label player2Label;

    /**
     * Label with seconds player wins counter
     */
    @FXML
    private Label player2WinsCountLabel;

    /**
     * Label with actual round counter
     */
    @FXML
    private Label roundCountLabel;

    /**
     * Error Anchor Pane
     */
    @FXML
    private AnchorPane errorAnchorPane;

    /**
     * Label with error message
     */
    @FXML
    private Label errorMessageLabel;

    /**
     * Label with current player name
     */
    @FXML
    private Label currentPlayerLabel;

    /**
     * Label with message at the end of the game
     */
    @FXML
    private Label endGameMessageLabel;

    /**
     * End game anchor pane
     */
    @FXML
    private AnchorPane endGameAnchorPane;

    /**
     * Field of the tic tac toe board
     */
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    
    /**
     * object representanting closing table of the to players button
     */
    @FXML
    private Button closeTableButton;
    
    /**
     * object representanting open top players table button
     */
    @FXML
    private Button showTopPlayersButton;

    /**
     * Objects representanting players in a game
     */
    private Player player1, player2;

    /**
     * String representanting players names
     */
    private static String player1Name, player2Name;

    /**
     * int representanting game mode(single player or solo player)
     */
    private static int gameMode;

    /**
     * Enum representanting acutal game status
     */
    private static GameStatus gameStatus;

    /**
     * Object representanting actual game board
     */
    private Board board;

    /**
     * Int representanting rounds count
     */
    private int roundCount;

    /**
     * int representanting actual player1(1 - first player, 2 - second player)
     */
    private int actualPlayer;

    /**
     * ints representaning wins counter for both players
     */
    private int player1WinsCounter, player2WinsCounter;

    /**
     * Object representanting winning condtions of the game
     */
    private WinningConditions winningConditions;
    
    /**
     * object representanting top players list
     */
    private TopPlayersList topPlayers;

    /////////////////////////////////////////////BUTTONSCLICKED////////////////////////////////////////////////////
    /**
     * Buttons clicked method
     */
    @FXML
    private void button1Clicked() throws InterruptedException {
        int position = 1;
        this.saveMove(button1, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button2Clicked() throws InterruptedException {
        int position = 2;
        this.saveMove(button2, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button3Clicked() throws InterruptedException {
        int position = 3;
        this.saveMove(button3, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button4Clicked() throws InterruptedException {
        int position = 4;
        this.saveMove(button4, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button5Clicked() throws InterruptedException {
        int position = 5;
        this.saveMove(button5, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button6Clicked() throws InterruptedException {
        int position = 6;
        this.saveMove(button6, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button7Clicked() throws InterruptedException {
        int position = 7;
        this.saveMove(button7, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button8Clicked() throws InterruptedException {
        int position = 8;
        this.saveMove(button8, position);
    }

    /**
     * Buttons clicked method
     */
    @FXML
    private void button9Clicked() throws InterruptedException {
        int position = 9;
        this.saveMove(button9, position);
    }

    /**
     * error message accept button clicked method
     */
    @FXML
    private void errorMessageButtonClicked() {
        this.errorAnchorPane.setVisible(false);
    }

    /**
     * Next game request button clicked method
     */
    @FXML
    private void nextGameButtonClicked() {
        this.clearView();
        this.endGameAnchorPane.setVisible(false);
        this.startNewGame();
    }

    /**
     * Back to main menu method
     *
     * @throws IOException when main menu fxml is not found
     */
    @FXML
    private void backToMenuButtonClicked() throws IOException {
        this.topPlayers.saveListToFile();
        this.clearView();
        this.switchToMainMenu();
    }

    ////////////////////////////////////////////SETTERS AND GETTERS//////////////////////////////////////////////////
    /**
     * Setter of first player name
     *
     * @param name of the player
     *
     */
    public void setPlayer1Name(String name) {
        this.player1Name = name;
    }

    /**
     * Setter of second player name
     *
     * @param name of the second player
     */
    public void setPlayer2Name(String name) {
        this.player2Name = name;
    }

    /**
     * Game mode setter
     *
     * @param gameMode current game mode
     */
    public void setGameMode(int gameMode) {
        GameController.gameMode = gameMode;
    }

    /**
     * setter of the error message text in the error Anchor pane
     *
     * @param message sent to te textfield
     */
    private void setErrorMessagePane(String message) {
        this.errorMessageLabel.setText(message);
        this.errorAnchorPane.setVisible(true);
    }

    /**
     * Setter of the message at the end of the game Anchor pane
     *
     * @param message sent to the textfield
     */
    private void setEndGameAnchorPane(String message) {
        this.endGameMessageLabel.setText(message);
        this.endGameAnchorPane.setVisible(true);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Initializing method
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.currentPlayerLabel.setText(this.player1Name);
        try {
            this.begin();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.startNewGame();
    }

    /**
     * Switching to main menu method
     *
     * @throws IOException when main menu FXML is not found
     */
    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenu");
    }

    /**
     * begin is responsible for creating players and change game status
     */
    public void begin() throws FileNotFoundException, IOException {
        switch (GameController.gameMode) {
            case 0 -> {
                this.createSingleplayerGame();
            }
            default -> {
                this.createMultiplayerGame();
            }
        }
        this.player1WinsCounter = 0;
        this.player1WinsCounter = 0;
        GameController.gameStatus = GameStatus.InGame;
        this.topPlayers = new TopPlayersList();
        topPlayers.loadListfromFile(); 
        this.PlayerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        this.PlayerScoreColumn.setCellValueFactory(new PropertyValueFactory<>("playerScore"));
        this.updateTable();
    }

    /**
     * Method that creates Single player game
     *
     */
    private void createSingleplayerGame() {
        this.player1 = createPlayer(this.player1Name, 'O');
        this.player2 = createPlayer("Cpu", 'X');
    }

    /**
     * Method that creates multi player game
     *
     */
    private void createMultiplayerGame() {
        this.player1 = createPlayer(this.player1Name, 'O');
        this.player2 = createPlayer(this.player2Name, 'X');
    }

    /**
     * createPlayer creates a object of the player
     *
     * @param playerName name of the player
     * @param playerSign sign of the player(X or O)
     * @return Player instance
     */
    public Player createPlayer(String playerName, char playerSign) {

        if ("Cpu".equals(playerName)) {
            Player newPlayer = new ComputerPlayer(playerSign);
            return newPlayer;
        }
        Player newPlayer = new HumanPlayer(playerName, playerSign);
        return newPlayer;
    }

    /**
     * startNewGame is responsible for all actions made by players during the
     * game, catching errors and chose the winner of the game
     */
    public void startNewGame() {
        this.board = new Board();
        this.winningConditions = new WinningConditions();
        this.roundCount = 1;
        this.actualPlayer = 1;
        this.player1Label.setText(player1.getPlayerName());
        this.player2Label.setText(player2.getPlayerName());
        this.player1WinsCountLabel.setText(Integer.toString(this.player1WinsCounter));
        this.player2WinsCountLabel.setText(Integer.toString(this.player2WinsCounter));
        this.roundCountLabel.setText("1");
    }

    /**
     * method that saves actual player move
     *
     * @param button clicked by the player
     * @param position of the clicked button
     * @throws java.lang.InterruptedException
     */
    public void saveMove(Button button, int position) throws InterruptedException {
        if (this.roundCount < 9) {
            switch (this.actualPlayer) {
                case 1 -> {
                    boolean didMove = false;
                    if (monitorMove(player1, board, position) == true) {
                        button.setText(Character.toString(player1.getSign()));
                        if (winningConditions.checkWinConditions(player1) == true) {
                            String message = "Wygrał " + player1.getPlayerName() + "!";
                            this.player1WinsCounter++;
                            this.topPlayers.addPlayerToList(player1Name);
                            this.TopPlayersTable.refresh();                 ////////////////////////////////////////////////////
                            //this.updateTable();
                            this.setEndGameAnchorPane(message);
                        }
                        this.roundCount++;
                        this.actualPlayer++;
                        this.updateView(player2, roundCount);
                        didMove = true;
                    } else {
                        String message = "Wybrałeś zajętą pozycję! Spróbuj jeszcze raz.";
                        this.setErrorMessagePane(message);
                    }
                    //TimeUnit.MILLISECONDS.sleep(500);
                    if (player2 instanceof ComputerPlayer == true && didMove == true && roundCount < 9) {

                        while (true) {
                            int intPosition = 1 + (int) (Math.random() * 9);
                            if (board.updateBoard(player2, intPosition) == true) {
                                addPlayerPosition(player2, intPosition);
                                this.setCpusSign(player2.getSign(), intPosition);
                                break;
                            }
                        }
                        if (winningConditions.checkWinConditions(player2) == true) {
                            String message = "Wygrał " + player2.getPlayerName() + "!";
                            this.player2WinsCounter++;
                            this.setEndGameAnchorPane(message);
                        }
                        this.roundCount++;
                        this.actualPlayer--;
                        this.updateView(player1, roundCount);
                    }
                }
                case 2 -> {
                    if (monitorMove(player2, board, position) == true) {
                        button.setText(Character.toString(player2.getSign()));
                        if (winningConditions.checkWinConditions(player2) == true) {
                            String message = "Wygrał " + player2.getPlayerName() + "!";
                            this.player2WinsCounter++;
                            this.topPlayers.addPlayerToList(player2Name);
                            this.TopPlayersTable.refresh();             ////////////////////////////////////////////// test
                            //this.updateTable();
                            this.setEndGameAnchorPane(message);
                        }
                        this.roundCount++;
                        this.actualPlayer--;
                        this.updateView(player1, roundCount);
                    } else {
                        String message = "Wybrałeś zajętą pozycję! Spróbuj jeszcze raz.";
                        this.setErrorMessagePane(message);
                    }
                }

            }
        } else {
            String message = "Mamy remis!";
            this.setEndGameAnchorPane(message);
        }

    }

    /**
     * Method that manages cpu move
     *
     * @param sign of the cpu
     * @param position chosen by the cpu
     */
    public void setCpusSign(char sign, int position) {
        switch (position) {
            case 1 -> {
                button1.setText(Character.toString(sign));
                break;
            }
            case 2 -> {
                button2.setText(Character.toString(sign));
                break;
            }
            case 3 -> {
                button3.setText(Character.toString(sign));
                break;
            }
            case 4 -> {
                button4.setText(Character.toString(sign));
                break;
            }
            case 5 -> {
                button5.setText(Character.toString(sign));
                break;
            }
            case 6 -> {
                button6.setText(Character.toString(sign));
                break;
            }
            case 7 -> {
                button7.setText(Character.toString(sign));
                break;
            }
            case 8 -> {
                button8.setText(Character.toString(sign));
                break;
            }
            case 9 -> {
                button9.setText(Character.toString(sign));
                break;
            }
        }
    }

    /**
     * Method that updates view
     *
     * @param player actual player
     * @param roundCount actual round
     */
    private void updateView(Player player, int roundCount) {
        this.currentPlayerLabel.setText(player.getPlayerName());
        this.roundCountLabel.setText(Integer.toString(roundCount));
    }

    /**
     * Method that clears view
     */
    private void clearView() {
        String emptyTile = "";
        button1.setText(emptyTile);
        button2.setText(emptyTile);
        button3.setText(emptyTile);
        button4.setText(emptyTile);
        button5.setText(emptyTile);
        button6.setText(emptyTile);
        button7.setText(emptyTile);
        button8.setText(emptyTile);
        button9.setText(emptyTile);

        this.player1.clearPositions();
        this.player2.clearPositions();

        this.board.clearBoard();

    }

    /**
     * Method that clears players positions list
     *
     * @param player which positions list will be cleared
     */
    public void clearPositionsList(Player player) {
        player.clearPositions();
    }

    /**
     * monitorMove is responsible actions related to moves made by the players
     * and checking correctness of these moves
     *
     * @param player actual player
     * @param board game board
     * @param position
     * @return
     */
    public boolean monitorMove(Player player, Board board, int position) {
        if (board.updateBoard(player, position) == true) {
            this.addPlayerPosition(player, position);
            return true;
        } else {
            return false;
        }
    }

    /**
     * addPlayerPosition adds a position to list of actual player position
     *
     * @param player that made a move
     * @param position that player has put sign on
     */
    public void addPlayerPosition(Player player, int position) {
        player.addPosition(position);
    }
    
    /**
     * Method that updates top players table
     */
    private void updateTable()
    {
        
        for(var el : this.topPlayers.getTopPlayers()){
            this.TopPlayersTable.getItems().add(el);
        }
    }
    
    /**
     * 
     */
    @FXML
    private void showTopPlayersButtonClicked(){
        this.TopPlayersTable.setVisible(true);
        this.closeTableButton.setVisible(true);
        this.showTopPlayersButton.setVisible(false);
    }
    
    /**
     * 
     */
    @FXML
    private void closeTableButtonClicked(){
        this.TopPlayersTable.setVisible(false);
        this.closeTableButton.setVisible(false);
        this.showTopPlayersButton.setVisible(true);
    }
}
