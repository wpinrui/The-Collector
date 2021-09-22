package thecollector;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a garage, which has a name and consists of cars owned by the player.
 * It is a subclass of Location.
 *
 * @author Ivan Wong
 */
public class Garage extends Location implements Serializable {
    /**
     * Class constructor for Garage.
     *
     * @param name The name of the garage
     * @param cars A TreeMap of cars owned by the player
     */
    public Garage(String name, ArrayList<Car> cars) {
        super(name, cars);
    }

    /**
     * Adds a car to the garage.
     * @param car Car to be added
     */
    public void addCar(Car car) {
        cars.add(car);
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
}
