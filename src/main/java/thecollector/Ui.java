package thecollector;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Encapsulates interactions from the game to the player.
 *
 * @author Ivan Wong
 */
public class Ui {
    public static final String ARGS_VIEW = "View command expected an integer car index.";
    public static final String ARGS_BUY = "Buy command expected an integer listing number.";
    public static final String ARGS_SELL = "Sell command expected an integer car index.";

    /**
     * Shows a message to the player.
     * @param message The message to be shown.
     */
    public static void display(String message) {
        System.out.println(message);
    }

    /**
     * Waits for the user to input their name into the console, then returns it.
     *
     * @return The name that the player has entered
     */
    public static String promptPlayerName() {
        System.out.println("Welcome to The Collector. What is your name?");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextLine();
        } catch (NoSuchElementException e) {
            return promptPlayerName();
        }
    }

    public static String formatCashMessage(int money) {
        return String.format("Current balance: %s", Utilities.formatMoney(money));
    }

    public static Object formatCarsListString(Location location) {
        return String.format("%s\nCars: \n", location.getName());
    }
}
