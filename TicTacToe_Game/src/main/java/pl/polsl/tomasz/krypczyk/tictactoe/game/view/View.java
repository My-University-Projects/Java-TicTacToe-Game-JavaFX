/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tomasz.krypczyk.tictactoe.game.view;

import java.util.Scanner;
import pl.polsl.tomasz.krypczyk.tictactoe.game.controller.Controller;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Board;
import pl.polsl.tomasz.krypczyk.tictactoe.game.model.Player;
import pll.polsl.krypczyk.exceptions.TooLongNameException;

/**
 *
 * @author Tomasz Krypczyk
 * @version 1.1 Class representanting a view in MVC model
 */
public class View {

    /**
     *
     * View Constructor
     */
    public View() {
    }

    /**
     *
     * printBoard prints actual game board
     *
     * @param board game board
     */
    public void printBoard(Board board) {
        for (char[] row : board.getBoard()) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    /**
     *
     * takeFirstPlayerNAme takes a name from first player
     *
     * @param controller
     * @return String players name
     * @throws TooLongNameException
     */
    public String takeFirstPlayerName(Controller controller) throws TooLongNameException {
        System.out.println("Podaj swoją nazwę: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        try {
            if (name.length() > 15) {
                throw new TooLongNameException("Za długie imię! Przydzielamy ci specjalną nazwę...");
            }
        } catch (TooLongNameException x) {
            name = controller.handleException();
        } finally {
            return name;
        }

    }

    /**
     *
     * takeSecondPlayerNAme takes a name from second player
     *
     * @param controller
     * @return String players name
     * @throws TooLongNameException
     */
    public String takeSecondPlayerName(Controller controller) throws TooLongNameException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj swoją nazwę drugiego gracza, jeśli chcesz zagrać z komputerem wciśnij 1: ");
        String name = scan.nextLine();
        try {
            if (name.length() > 15) {
                throw new TooLongNameException("Za długie imię! Przydzielamy ci specjalną nazwę...");
            }
        } catch (TooLongNameException x) {
            name = controller.handleException();
        } finally {
            return name;
        }
    }

    /**
     *
     * takePosition takes a position from player
     *
     * @return String position
     */
    public String takePosition() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj miejsce, w które chcesz wpisać( odpowiednio cyfry od 1 do 9) twój znak ");
        String position = scan.next();
        return position;
    }

    /**
     *
     * winnerOfTheGame writes on the console output winners name
     *
     * @param player winner of the game
     */
    public void winnerOfTheGame(Player player) {
        System.out.println("Wygrał gracz o nazwie " + player.getPlayerName());
        System.out.println("Gratulacje!!");
    }

    /**
     *
     * tie writes on the console output information when no one wins
     *
     * @return String information about tie
     */
    public String tie() {
        return "No i mamy remis!";
    }

    /**
     *
     * printActualPlayer prints the name of actual player
     *
     * @param playerName actual player name
     */
    public void printActualPlayer(String playerName) {
        System.out.println("Teraz tura gracza o nazwie: " + playerName);
    }

    /**
     * clearConsole clears a console view
     */
    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     *
     * @return boolean true if players want to play again
     */
    public boolean nextGameQuestion() {
        System.out.println("Czy chcecie zagrać jeszcze raz?\n Wpisz 1 jeśli tak");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if ("1".equals(answer)) {
            clearConsole();
            return true;
        } else {
            return false;
        }
    }
}
