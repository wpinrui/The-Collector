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
    public static final String ARGS_VIEW_INDEX_OOB = "You have entered an index for a car that doesn't exist.";
    public static final String ARGS_UNRECOGNISED = "Sorry, the command you entered is not recognised.";
    public static final String ALREADY_IN_SHOP_MESSAGE = "You are already at the car dealer.";
    public static final String MOVED_TO_SHOP_MESSAGE = "You are now at the car dealer.";
    public static final String ALREADY_IN_GARAGE_MESSAGE = "You are already at the garage.";
    public static final String MOVED_TO_GARAGE_MESSAGE = "You are now in your garage.";
    public static final String MUST_BE_IN_DEALER_MESSAGE = "You need to visit the car dealer to buy a car.";
    public static final String INSUFFICIENT_FUNDS_MESSAGE = "You do not have enough money to buy this car.";
    public static final String MUST_BE_IN_GARAGE_MESSAGE = "You need to be in your garage to sell a car.";
    public static final String PROMPT_PLAYER_INPUT_MESSAGE = "What would you like to do?";

    /**
     * Shows a message to the player.
     * @param message The message to be shown.
     */
    public static void display(String message) {
        System.out.println(message);
    }

    public static void displayPrompt(String message) {
        System.out.print(message + "\n> ");
    }

    /**
     * Waits for the user to input their name into the console, then returns it.
     *
     * @return The name that the player has entered
     */
    public static String promptPlayerName() {
        displayPrompt("Welcome to The Collector. What is your name?");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextLine();
        } catch (NoSuchElementException e) {
            return promptPlayerName();
        }
    }

    /**
     * Formats a message to display the player's balance
     *
     * @param money Integer number of cents
     * @return A formatted string informing the user of their balance
     */
    public static String formatCashMessage(int money) {
        return String.format("Current balance: %s", Utilities.formatMoney(money));
    }

    /**
     * Formats a message to display the player's location
     *
     * @param location The player's location
     * @return A formatted string informing the user of their location
     */
    public static String formatLocationMessage(Location location) {
        return String.format("Current location: %s", location.getName());
    }

    /**
     * Formats a message to precede the displaying of the list of cars at a given location.
     *
     * @param location The garage or dealer whose cars are to be displayed later
     * @return A formatted string to be shown before the list of cars at the location
     */
    public static Object formatCarsListString(Location location) {
        return String.format("%s\nCars: \n", location.getName());
    }

    /**
     * Formats a message to display the number of in-game months that have passed.
     *
     * @param month The number of months that have passed
     * @return A formatted string informing the user how many in-game months have passed
     */
    public static String formatMonthMessage(int month) {
        return String.format("Months Passed: %d", month + 1);
    }

    /**
     * Formats a message to inform the user what car they have just bought
     *
     * @param car The car that has been bought
     * @return A formatted string informing the user what car they have just bought
     */
    public static String formatCarBoughtMessage(Car car) {
        return String.format("You have bought a car: \n%s.", car.toString());
    }

    /**
     * Formats a message to inform the user what car they have just sold
     *
     * @param car The car that has been sold
     * @return A formatted string informing the user what car they have just sold
     */
    public static String formatCarSoldMessage(Car car) {
        return String.format("You have sold your car: \n%s.", car.toString());
    }

    /**
     * Formats a summary of the game state, including months passed, the player's location and their balance.
     *
     * @param game The state of the game
     * @return A summary of the game state
     */
    public static String formatSummary(Game game) {
        String divider = "==================================================";
        return String.format("%s\n%s\n%s\n%s\n%s\n",
                divider,
                formatMonthMessage(game.getMonth()),
                formatLocationMessage(game.getPlayer().getLocation()),
                formatCashMessage(game.getPlayer().getMoney()),
                divider);
    }

    /**
     * Prompts the player for their next instruction.
     *
     * @return The player's next instruction
     */
    public static String promptPlayerInput() {
        displayPrompt(Ui.PROMPT_PLAYER_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
