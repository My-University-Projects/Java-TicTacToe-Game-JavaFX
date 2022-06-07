package pl.polsl.tomasz.krypczyk.tictactoegame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tomasz Krypczyk
 * @version 1.1 Class that contains all possible ways to win a tictactoe game
 */
public class WinningConditions {

    /**
     * winningPositions is a List of all possible positions that player has to
     * put a sign on to win a tictactoe game
     */
    List<List<Integer>> winningPositions;

    /**
     * WinningConditions constructor
     */
    public WinningConditions() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> leftCross = Arrays.asList(1, 5, 9);
        List<Integer> rightCross = Arrays.asList(3, 5, 7);

        this.winningPositions = new ArrayList<>();
        this.winningPositions.add(topRow);
        this.winningPositions.add(midRow);
        this.winningPositions.add(botRow);
        this.winningPositions.add(leftCol);
        this.winningPositions.add(midCol);
        this.winningPositions.add(rightCol);
        this.winningPositions.add(leftCross);
        this.winningPositions.add(rightCross);
    }

    /**
     * checkWinConditions checks that actual player sign positions are winning
     * positions
     *
     * @param player actual player
     * @return boolean if positions of actual player meet the winning conditions
     */
    public boolean isWinner(Player player) {
        return this.winningPositions.stream().anyMatch(wp -> player.getPositions().containsAll(wp));
    }
}
