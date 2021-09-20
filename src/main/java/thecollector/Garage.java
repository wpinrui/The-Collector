package thecollector;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * This class represents a garage, which has a name and consists of cars owned by the player.
 *
 * @author Ivan Wong
 */
public class Garage implements Serializable {
    private String name;
    private TreeMap<Integer, Car> cars;

    /**
     * Class constructor for Garage.
     *
     * @param name The name of the garage
     * @param cars A TreeMap of cars owned by the player
     */
    public Garage(String name, TreeMap<Integer, Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    /**
     * Retrieves the name of the garage.
     *
     * @return The garage name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds a car to the garage.
     * @param car Car to be added
     */
    public void addCar(Car car) {
        cars.put(cars.size(), car);
    }

    /**
     * Removes the car from the garage that corresponds to a given key
     *
     * @param key The index of the car to be removed
     * @return The car that has been removed from the garage
     */
    public Car removeCar(int key) {
        return cars.remove(key);
    }

    /**
     * Returns a string representation of all the cars in the garage.
     *
     * @return String representation of cars in garage
     */
    public String listAllCars() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            output.append(cars.get(i));
            output.append("\n");
        }
        return String.format("%s\n%s", Ui.formatGarageListString(this), output);
    }
}
