package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import java.io.*;
import java.util.*;

/**
 * Class representanting list of top 10 players in tictactoe game
 */
public class TopPlayersList {

    /**
     * List with players
     */
    List<HumanPlayer> topPlayers;

    /**
     * number of players on a list
     */
    int listSize;

    /**
     * counstructor of players list
     */
    public TopPlayersList() {
        topPlayers = new ArrayList<>();
        listSize = 0;
    }

    /**
     * Getter of the players list
     *
     * @return
     */
    public List<HumanPlayer> getTopPlayers() {
        return this.topPlayers;
    }

    /**
     * method that adds new player to the top players List
     *
     * @param playersName
     */
    public void addPlayerToList(String playersName) {
        for (var player : topPlayers) {
            if (Objects.equals(player.getPlayerName(), playersName)) {
                player.incrementScore();
                return;
            }
        }
        HumanPlayer position = new HumanPlayer(playersName, 1);
        topPlayers.add(position);
        this.sortPlayersList();
    }

    /**
     * Method that reades top players list from the file
     *
     */
    public void loadListFromFile() throws IOException {

        String name = "";
        int score = 0;
        File file = new File("C:\\Users\\ASUS\\OneDrive\\Pulpit\\TopPlayers.txt");
        try {

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException x) {
            file.createNewFile();
        } finally {
            Scanner scanner = new Scanner(file);
            int counter = 0;
            boolean nameOrScore = true;
            while (scanner.hasNextLine()) {
                if (nameOrScore) {
                    name = scanner.nextLine();
                    nameOrScore = false;
                    counter++;
                } else {
                    score = Integer.parseInt(scanner.nextLine());
                    nameOrScore = true;
                    counter++;
                }
                if (counter == 2) {
                    HumanPlayer player = new HumanPlayer(name, score);
                    this.topPlayers.add(player);
                    counter = 0;
                }
            }
        }
        this.sortPlayersList();
    }

    /**
     * method that saves actual top player list to file
     *
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void saveListToFile() throws IOException {
        if (this.topPlayers.isEmpty()) {
            return;
        }
        String name, score;
        try (PrintWriter writer = new PrintWriter("C:\\Users\\ASUS\\OneDrive\\Pulpit\\TopPlayers.txt", "UTF-8")) {
            for (var el : this.topPlayers) {
                name = el.playerName;
                score = el.getPlayerScore().toString();
                writer.println(name);
                writer.println(score);
            }
        } catch (FileNotFoundException x) {
            File file = new File("C:\\Users\\ASUS\\OneDrive\\Pulpit\\TopPlayers.txt");
            file.createNewFile();
        }
    }

    public void sortPlayersList() {
        this.topPlayers.sort(Comparator.comparing(HumanPlayer::getPlayerScore).reversed());
    }

}
