package thecollector;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class encapsulates a car dealer's characteristics and behaviour.
 * It is a subclass of Location.
 *
 * @author Ivan Wong
 */
public class Dealer extends Location implements Serializable {
    private int numberOfCars;
    /**
     * Constructor for a car dealer.
     *
     * @param name Name of the dealer
     * @param numberOfCars Number of cars available from the dealer each month
     */
    public Dealer(String name, int numberOfCars) {
        super(name, new ArrayList<>());
        this.numberOfCars = numberOfCars;
        generateCarListings(numberOfCars);
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    /**
     * Retrieve the listings from the dealer
     *
     * @return listings
     */
    public ArrayList<Car> getCarListings() {
        return cars;
    }

    /**
     * Generates a new list of cars to be sold.
     */
    public void generateCarListings(int numberOfCars) {
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(generateSingleListing());
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
     * @param index Index of the car to remove
     */
    public Car removeFromListings(int index) {
        return cars.remove(index);
    }

    public void addToListings(Car car) {
        cars.add(car);
    }
}
