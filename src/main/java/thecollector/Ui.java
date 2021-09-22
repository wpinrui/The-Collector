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
    public static String alreadyInShopMessage = "You are already at the car dealer.";
    public static String movedToShopMessage = "You are now at the car dealer.";
    public static String alreadyInGarageMessage = "You are already at the garage.";
    public static String movedToGarageMessage = "You are now in your garage.";
    public static String mustBeInDealerMessage = "You need to visit the car dealer to buy a car.";
    public static String insufficientFundsMessage = "You do not have enough money to buy this car.";
    public static String mustBeInGarageMessage = "You need to be in your garage to sell a car.";

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

    public static String formatLocationMessage(Location location) {
        return String.format("Current location: %s", location.getName());
    }

    public static Object formatCarsListString(Location location) {
        return String.format("%s\nCars: \n", location.getName());
    }

    public static String formatMonthMessage(int month) {
        return String.format("Months Passed: %d", month + 1);
    }

    public static String formatCarBoughtMessage(Car car) {
        return String.format("You have bought a car: \n%s.", car.toString());
    }

    public static String formatCarSoldMessage(Car car) {
        return String.format("You have sold your car: \n%s.", car.toString());
    }

    public static String formatSummary(Game game) {
        String divider = "==================================================";
        return String.format("%s\n%s\n%s\n%s\n%s\n",
                divider,
                formatMonthMessage(game.getMonth()),
                formatLocationMessage(game.getPlayer().getLocation()),
                formatCashMessage(game.getPlayer().getMoney()),
                divider);
    }

    public static String promptPlayerInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
