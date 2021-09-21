package thecollector;

import java.io.Serializable;

/**
 * This class represents the player of the game.
 *
 * @author Ivan Wong
 */
public class Player implements Serializable {
    private final String name;
    private int money;
    private Garage garage;

    /**
     * Constructor for the player class.
     *
     * @param name The name of the player
     * @param money The amount of money that the player has
     * @param garage The garage that the player owns
     */
    public Player(String name, int money, Garage garage) {
        this.name = name;
        this.money = money;
        this.garage = garage;
    }

    /**
     * Retrieves the player's name
     *
     * @return The player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a specified amount of money to the player's balance
     *
     * @param amount Amount of money to be added
     */
    public void addMoney(int amount) {
        money += amount;
    }

    /**
     * Sets the player's money to a specific amount
     *
     * @param amount Amount of money that the balance should be set to
     */
    public void setMoney(int amount) {
        money = amount;
    }

    /**
     * Returns the amount of money that the player has.
     *
     * @return Amount of money in cents
     */
    public int getMoney() {
        return money;
    }

    /**
     * Retrieves the garage belonging to the player
     *
     * @return Garage belonging to player
     */
    public Garage getGarage() {
        return garage;
    }
}
