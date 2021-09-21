package thecollector;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * This class encapsulates a car dealer's characteristics and behaviour.
 * It is a subclass of Location.
 *
 * @author Ivan Wong
 */
public class Dealer extends Location implements Serializable {
    private final int numberOfCars;

    /**
     * Constructor for a car dealer.
     *
     * @param name Name of the dealer
     * @param numberOfCars Number of cars available from the dealer each month
     */
    public Dealer(String name, int numberOfCars) {
        super(name, new TreeMap<Integer, Car>());
        this.numberOfCars = numberOfCars;
        generateCarListings();
    }

    /**
     * Retrieve the listings from the dealer
     *
     * @return listings
     */
    public TreeMap<Integer, Car> getCarListings() {
        return cars;
    }

    /**
     * Generates a new list of cars to be sold.
     */
    public void generateCarListings() {
        for (int i = 0; i < this.numberOfCars; i++) {
            cars.put(i, generateSingleListing());
        }
    }

    /**
     * Generates a single car listing.
     *
     * @return A car to be listed by the dealer
     */
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
        return cars.remove(treeKey);
    }
}
