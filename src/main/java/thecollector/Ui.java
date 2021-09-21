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
     * Returns a string that is shown before the car list when the player views the garage
     * @param garage The garage being viewed
     * @return The string representing the garage
     */
    public static String formatGarageListString(Garage garage) {
        return String.format("Cars in %s", garage.getName());
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

    public static String formatDealerListingsString(Dealer dealer) {
        return String.format("%s's listings", dealer.getName());
    }
}
