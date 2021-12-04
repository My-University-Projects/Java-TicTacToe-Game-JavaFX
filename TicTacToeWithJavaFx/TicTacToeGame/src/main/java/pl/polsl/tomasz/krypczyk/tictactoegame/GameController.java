package pl.polsl.tomasz.krypczyk.tictactoegame;

import java.io.IOException;
import java.net.URL;
import static java.time.Clock.system;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.ComputerPlayer;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.GameStatus;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.HumanPlayer;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.Player;
import pl.polsl.tomasz.krypczyk.tictactoegame.model.WinningConditions;

/**
 * 
 * @author Tomasz Krypczyk
 */
public class GameController implements Initializable {

    ////////////////////////////////////////////////////////////////////////////////
    
    /**
     * 
     */
    @FXML
    private Label player1Label;

    /**
     * 
     */
    @FXML
    private Label player1WinsCountLabel;

    /**
     * 
     */
    @FXML
    private Label player2Label;

    /**
     * 
     */
    @FXML
    private Label player2WinsCountLabel;
    
    /**
     * 
     */
    @FXML
    private Label roundCountLabel;
    
    /**
     * 
     */
    @FXML
    private AnchorPane errorAnchorPane;
    
    /**
     * 
     */
    @FXML
    private Label errorMessageLabel;
    
    /**
     * 
     */
    @FXML
    private Label currentPlayerLabel;
    
    /**
     * 
     */
    @FXML
    private Label endGameMessageLabel;
    
    /**
     * 
     */
    @FXML
    private AnchorPane endGameAnchorPane;
    
    /**
     * 
     */
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    
    /**
     * 
     */
    private Player player1, player2;
    
    /**
     * 
     */
    private static String player1Name, player2Name;
    
    /**
     * 
     */
    private static int gameMode;
    
    /**
     * 
     */
    private static GameStatus gameStatus;
    
    /**
     * 
     */
    private Board board;
    
    /**
     * 
     */
    private int roundCount;
    
    /**
     * 
     */
    private int actualPlayer;
    
    /**
     * 
     */
    private int player1WinsCounter, player2WinsCounter;
    
    /**
     * 
     */
    private WinningConditions winningConditions;
    
    /////////////////////////////////////////////BUTTONSCLICKED////////////////////////////////////////////////////
    
    /**
     * 
     */
    @FXML
    private void button1Clicked() throws InterruptedException
    {
        int position = 1;
        this.saveMove(button1, position);
    }
    
    /**
     * 
     */
    @FXML
     private void button2Clicked() throws InterruptedException
    {
        int position = 2;
        this.saveMove(button2, position);
    } 
     
    /**
     * 
    */
     @FXML
     private void button3Clicked() throws InterruptedException
    {
        int position = 3;
        this.saveMove(button3, position);
    }
     
    /**
     * 
    */
     @FXML
     private void button4Clicked() throws InterruptedException
    {
        int position = 4;
        this.saveMove(button4, position);
    }
     
    /**
     * 
    */
     @FXML
     private void button5Clicked() throws InterruptedException
    {
        int position = 5;
        this.saveMove(button5, position);
    }
     
    /**
     * 
    */
     @FXML
     private void button6Clicked() throws InterruptedException
    {
        int position = 6;
        this.saveMove(button6, position);
    }
     
    /**
     * 
    */
     @FXML
     private void button7Clicked() throws InterruptedException
    {
        int position = 7;
        this.saveMove(button7, position);
    }
     
    /**
     * 
    */
     @FXML
     private void button8Clicked() throws InterruptedException
    {
        int position = 8;
        this.saveMove(button8, position);
    }
     
    /**
     * 
    */
     @FXML
     private void button9Clicked() throws InterruptedException
    {
        int position = 9;
        this.saveMove(button9, position);
    }
     
     /**
      * 
      */
     @FXML
     private void errorMessageButtonClicked()
     {
         this.errorAnchorPane.setVisible(false);
     }
     
     @FXML
     private void nextGameButtonClicked()
     {
         this.clearView();
         this.endGameAnchorPane.setVisible(false);
         this.startNewGame();
     }
     
     @FXML
     private void backToMenuButtonClicked() throws IOException
     {
         this.clearView();
         this.switchToPrimary();
     }
    
    ////////////////////////////////////////////SETTERS AND GETTERS//////////////////////////////////////////////////
    
    /**
     * 
     * @param name 
     */
    public void setPlayer1Name(String name)
    {
        this.player1Name = name;
    }
    
    /**
     * 
     * @param name 
     */
    public void setPlayer2Name(String name)
    {
        this.player2Name = name;
    }
    
    /**
     * 
     * @param gameMode 
     */
    public void setGameMode(int gameMode)
    {
        GameController.gameMode = gameMode;
    }
    
        /**
     * 
     * @param message 
     */
    private void setErrorMessagePane(String message)
    {
        this.errorMessageLabel.setText(message);
        this.errorAnchorPane.setVisible(true);
    }
    
    /**
     * 
     * @param message 
     */
    private void setEndGameAnchorPane(String message)
    {
        this.endGameMessageLabel.setText(message);
        this.endGameAnchorPane.setVisible(true);
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        this.currentPlayerLabel.setText(this.player1Name);
        this.begin();
        this.startNewGame();
    }
    
    /**
     * 
     * @throws IOException 
     */
    @FXML
    private void switchToPrimary() throws IOException 
    {
        App.setRoot("MainMenu");
    }  
    
    /**
    * begin is responsible for creating players and change game status
    */
    public void begin()
    {
        switch (GameController.gameMode)
        {
            case 0 -> 
            {
                this.createSingleplayerGame();
            }
            default ->
            {
                this.createMultiplayerGame();
            }
        }
            this.player1WinsCounter = 0;
            this.player1WinsCounter = 0;
            GameController.gameStatus = GameStatus.InGame;
    }
   
    /**
     * 
     * 
     */
    private void createSingleplayerGame()
    {
       this.player1 = createPlayer(this.player1Name, 'O');
       this.player2 = createPlayer("Cpu", 'X');
    }
    
    /**
     * 
     * 
     */
    private void createMultiplayerGame()
    {
       this.player1 = createPlayer(this.player1Name, 'O');
       this.player2 = createPlayer(this.player2Name, 'X');
    }
    
     /**
     * createPlayer creates a object of the player
     * @param playerName name of the player
     * @param playerSign sign of the player(X or O)
     * @return Player instance
     */
    public Player createPlayer(String playerName, char playerSign) {

        if ("Cpu".equals(playerName))
        {
            Player newPlayer = new ComputerPlayer(playerSign);
            return newPlayer;
        }
        Player newPlayer = new HumanPlayer(playerName, playerSign);
        return newPlayer;
    }
    
    /**
     * startNewGame is responsible for all actions made by players during the game,
 catching errors and chose the winner of the game
     *
     */
    public void startNewGame()
    {
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
     * 
     * @param button
     * @param position 
     */
    public void saveMove(Button button, int position) throws InterruptedException
    {
        if(this.roundCount < 9)
        {
            switch(this.actualPlayer)
            {
                case 1 -> {
                    boolean didMove = false;
                    if(monitorMove(player1, board, position) == true)
                    {
                        button.setText(Character.toString(player1.getSign()));
                        if (checkWinConditions(player1, winningConditions) == true) 
                        {
                            String message = "Wygrał " + player1.getPlayerName() + "!";
                            this.player1WinsCounter++;
                            this.setEndGameAnchorPane(message);
                        }
                        this.roundCount++;
                        this.actualPlayer++;
                        this.updateView(player2, roundCount);
                        didMove = true;
                    }
                    else
                    {
                        String message = "Wybrałeś zajętą pozycję! Spróbuj jeszcze raz.";
                        this.setErrorMessagePane(message);
                    }
                    if(player2 instanceof ComputerPlayer == true  && didMove == true)
                    {
                        //TimeUnit.MILLISECONDS.sleep(500);
                        while (true)
                        {
                            int intPosition = 1 + (int) (Math.random() * 9);
                            if (this.updateBoard(board, player2, intPosition) == true) 
                            {
                                addPlayerPosition(player2, intPosition);
                                this.setCpusSign(player2.getSign(), intPosition);
                                break;
                            }
                        }
                        if (checkWinConditions(player2, winningConditions) == true)
                            {
                                String message = "Wygrał " + player2.getPlayerName() + "!";
                                this.player2WinsCounter++;
                                this.setEndGameAnchorPane(message);
                            }
                        this.roundCount++;
                        this.actualPlayer--;
                        this.updateView(player1, roundCount);
                    }
                }
                case 2 ->
                {
                        if(monitorMove(player2, board, position) == true)
                        {
                            button.setText(Character.toString(player2.getSign()));
                            if (checkWinConditions(player2, winningConditions) == true)
                            {
                                String message = "Wygrał " + player2.getPlayerName() + "!";
                                this.player2WinsCounter++;
                                this.setEndGameAnchorPane(message);
                            }
                            this.roundCount++;
                            this.actualPlayer--;
                            this.updateView(player1, roundCount);
                        }
                        else
                        {
                            String message = "Wybrałeś zajętą pozycję! Spróbuj jeszcze raz.";
                            this.setErrorMessagePane(message);
                        }   
                }
            }
        }
        else
        {
            String message = "Mamy remis!";
            this.setEndGameAnchorPane(message);
        }
        
    }
    
    /**
     * 
     * @param sign
     * @param position 
     */
    public void setCpusSign(char sign, int position)
    {
        switch(position)
        {
            case 1 ->
            {
                button1.setText(Character.toString(sign));
                break;
            }
            case 2 ->
            {
                button2.setText(Character.toString(sign));
                break;
            }
            case 3 ->
            {
                button3.setText(Character.toString(sign));
                break;
            }
            case 4 ->
            {
                button4.setText(Character.toString(sign));
                break;
            }
            case 5 ->
            {
                button5.setText(Character.toString(sign));
                break;
            }
            case 6 ->
            {
                button6.setText(Character.toString(sign));
                break;
            }
            case 7 ->
            {
                button7.setText(Character.toString(sign));
                break;
            }
            case 8 ->
            {
                button8.setText(Character.toString(sign));
                break;
            }
            case 9 ->
            {
                button9.setText(Character.toString(sign));
                break;
            }
        }
    }
    
    /**
     * 
     * @param player
     * @param roundCount 
     */
    private void updateView(Player player, int roundCount)
    {
        this.currentPlayerLabel.setText(player.getPlayerName());
        this.roundCountLabel.setText(Integer.toString(roundCount));
    }
    
    /**
     * 
     */
    private void clearView()
    {
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
     * 
     * @param player 
     */
    public void clearPositionsList(Player player) {
        player.clearPositions();
    }
    
     /**
     * monitorMove is responsible actions related to moves made by the players and
 checking correctness of these moves
     *
     * @param player actual player
     * @param board game board
     * @param position
     * @return 
     */
    public boolean monitorMove(Player player, Board board, int position) 
    {
        if (this.updateBoard(board, player, position) == true) 
        {
            this.addPlayerPosition(player, position);
            return true;
        }
        else
        {
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
     * updateBoard puts on a board sign in the chosen by player position
     *
     * @param board game board
     * @param player actual player
     * @param el chosen by the player board element
     * @return boolean if update has been finished succesful
     */
    public boolean updateBoard(Board board, Player player, int el) {
        boolean result;
        int row, column;
        if (el <= 3 && el >= 1) {
            row = 0;
            column = this.calculateColumn(el);
            if (checkIfEmpty(board.getBoard()[row][column]) == true) {
                board.getBoard()[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else if (el <= 6 && el >= 4) {
            row = 2;
            column = this.calculateColumn(el);
            if (checkIfEmpty(board.getBoard()[row][column]) == true) {
                board.getBoard()[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else if (el <= 9 && el >= 7) {
            row = 4;
            column = this.calculateColumn(el);
            if (checkIfEmpty(board.getBoard()[row][column]) == true) {
                board.getBoard()[row][column] = player.getSign();
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
    
    /**
     * calculateColumn calculates depending on chosen by the player position
     *
     * @param position that players wants to put sign on
     * @return int the column on the game board
     */
    public int calculateColumn(int position) {

        int column;
        column = switch (position) {
            case 1 ->
                0;
            case 2 ->
                2;
            case 3 ->
                4;
            case 4 ->
                0;
            case 5 ->
                2;
            case 6 ->
                4;
            case 7 ->
                0;
            case 8 ->
                2;
            case 9 ->
                4;
            default ->
                -1;
        };
        return column;
    }
    
    /**
     * checkIfEmpty checks that actual position is avaible for player to put
     * sign on
     *
     * @param position that players wants to put sign on
     * @return boolean true if positon is empty
     */
    public boolean checkIfEmpty(char position) {
        return position == ' ';
    }
    
    /**
     * checkWinConditions checks that actual player sign positions are winning
     * positions
     *
     * @param player actual player
     * @param winningConditions list of the winning positions
     * @return boolean if positions of actual player meet the winning conditions
     */
    public boolean checkWinConditions(Player player, WinningConditions winningConditions) {
        boolean result = false;
        for (List el : winningConditions.getWinningPositions()) {
            if (player.getPositions().containsAll(el)) {
                result = true;
                break;
            }
        }
        return result;
    }
}