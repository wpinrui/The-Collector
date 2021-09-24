package thecollector;

import java.io.IOException;

/**
 * This class handles the logic for all user instructions.
 *
 * @author Ivan Wong
 */
public class Logic {
    /**
     * Retrieves the cash balance of the player and displays it.
     *
     * @param game The state of the game
     */
    public static void handleCash(Game game) {
        int money = game.getPlayer().getMoney();
        Ui.display(Ui.formatCashMessage(money));
    }
    /**
     * Moves the user to the car dealer if they are not already there. Saves the game.
     *
     * @param game The state of the game
     * @throws IOException If the game cannot be saved
     */
    public static void handleShop(Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Dealer) {
            Ui.display(Ui.ALREADY_IN_SHOP_MESSAGE);
            return;
        }
        Dealer dealer = game.getDealer();
        game.getPlayer().setLocation(dealer);
        Ui.display(Ui.MOVED_TO_SHOP_MESSAGE);
        Ui.display(dealer.toString());
        Storage.writeSave(game);

    }
    /**
     * Moves the user to the garage if they are not already there. Saves the game.
     *
     * @param game The state of the game
     * @throws IOException If the game cannot be saved
     */
    public static void handleGarage(Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Garage) {
            Ui.display(Ui.ALREADY_IN_GARAGE_MESSAGE);
            return;
        }
        Garage garage = game.getGarage();
        game.getPlayer().setLocation(garage);
        Ui.display(Ui.MOVED_TO_GARAGE_MESSAGE);
        Ui.display(garage.toString());
        Storage.writeSave(game);

    }
    /**
     * Advances the game time by a month. Saves the game.
     *
     * @param game The state of the game
     * @throws IOException If the game cannot be saved
     */
    public static void handleAdvance(Game game) throws IOException {
        game.advanceTime();
        Ui.display(Ui.formatSummary(game));
        Storage.writeSave(game);
    }
    /**
     * Retrieves a car from a list of cars and displays it to the player. If the player is at a car dealer, the car
     * retrieved is from the dealer's listings. If the player is in their garage, then the car retrieved is from the
     * player's owned cars.
     *
     * @param index The list index of the car
     * @param game The state of the game
     */
    public static void handleView(int index, Game game) {
        Car car = game.getPlayer().getLocation().getCars().get(index);
        Ui.display(car.toString());

    }
    /**
     * Moves a car from a car dealer to the player's garage if the player has sufficient balance to afford it. Saves
     * the game. The player must be at the car dealer to use this command.
     *
     * @param index The list index of the car
     * @param game The state of the game
     * @throws IOException If the game cannot be saved
     */
    public static void handleBuy(int index, Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Garage) {
            Ui.display(Ui.MUST_BE_IN_DEALER_MESSAGE);
            return;
        }
        Dealer dealer = game.getDealer();
        Car car = dealer.removeFromListings(index);
        if (game.getPlayer().getMoney() < car.getValue()) {
            Ui.display(Ui.INSUFFICIENT_FUNDS_MESSAGE);
            dealer.addToListings(car);
            return;
        }
        game.getGarage().addCar(car);
        game.getPlayer().addMoney(car.getValue() * -1);
        Ui.display(Ui.formatCarBoughtMessage(car));
        Storage.writeSave(game);

    }

    /**
     * Removes a car from the player's garage and adds the sale value back to the player's balance. Saves
     * the game. The player must be at the garage to use this command.
     *
     * @param index The list index of the car
     * @param game The state of the game
     * @throws IOException If the game cannot be saved
     */
    public static void handleSell(int index, Game game) throws IOException {
        if (game.getPlayer().getLocation() instanceof Dealer) {
            Ui.display(Ui.MUST_BE_IN_GARAGE_MESSAGE);
            return;
        }
        Car car = game.getGarage().removeCar(index);
        game.getPlayer().addMoney(car.getValue());
        Ui.display(Ui.formatCarSoldMessage(car));
        Storage.writeSave(game);
    }
}
