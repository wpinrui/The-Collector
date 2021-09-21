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
     * Retrieves the name of the dealer.
     *
     * @return The dealer name
     */
    public String getName() {
        return this.name;
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
        listings = new TreeMap<>();
        for (int i = 0; i < this.numberOfCars; i++) {
            listings.put(i, generateSingleListing());
        }
    }

    public Car generateSingleListing() {
        // TODO: add more cars
        return new Car("Nissom", "Moony", 20000_00);
    }

    /**
     * Remove a car from the listings, perhaps because it has been sold.
     * Returns the car.
     *
     * @param treeKey Index of the car to remove
     */
    public Car removeFromListings(int treeKey) {
        return listings.remove(treeKey);
    }

    /**
     * Return the name of the car dealer.
     * @return Name of dealer
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < listings.size(); i++) {
            output.append(listings.get(i));
            output.append("\n");
        }
        return String.format("%s:\n%s", Ui.formatDealerListingsString(this), output);
    }
}
