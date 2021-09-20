package thecollector;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * This class encapsulates a car dealer's characteristics and behaviour.
 *
 * @author Ivan Wong
 */
public class Dealer implements Serializable {
    private TreeMap<Integer, Car> listings;
    private final String name;
    private final int numberOfCars;

    /**
     * Constructor for a car dealer.
     *
     * @param name Name of the dealer
     * @param numberOfCars Number of cars available from the dealer each month
     */
    public Dealer(String name, int numberOfCars) {
        this.name = name;
        this.numberOfCars = numberOfCars;
        generateCarListings();
    }

    /**
     * Retrieve the listings from the dealer
     *
     * @return listings
     */
    public TreeMap<Integer, Car> getCarListings() {
        return listings;
    }

    /**
     * Generates a new list of cars to be sold.
     */
    public void generateCarListings() {
        // TODO: implement
    }

    /**
     * Remove a car from the listings, perhaps because it has been sold
     * @param treeKey
     */
    public void removeFromListings(int treeKey) {
        // TODO: implement
    }

    /**
     * Return the name of the car dealer.
     * @return Name of dealer
     */
    @Override
    public String toString() {
        return this.name;
    }
}
