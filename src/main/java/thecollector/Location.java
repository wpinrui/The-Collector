package thecollector;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Superclass of Dealer and Garage classes as both of them are possible locations for the player.
 *
 * @author Ivan Wong
 */
public class Location implements Serializable {
    protected String name;
    protected ArrayList<Car> cars;

    /**
     * Constructor for a location.
     *
     * @param name Name of the venue
     * @param cars List of cars available at the venue
     */
    public Location(String name, ArrayList<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    /**
     * Returns the name of the venue
     *
     * @return Name of the venue
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a string representation of the venue by stating its list of cars.
     *
     * @return A string representation of the venue
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            output.append(cars.get(i));
            output.append("\n");
        }
        if (output.toString().equals("")) {
            output.append("(None)\n");
        }
        return String.format("%s%s", Ui.formatCarsListString(this), output);
    }

    /**
     * Retrieves the car list of the venue.
     *
     * @return Car list of the venue
     */
    public ArrayList<Car> getCars() {
        return cars;
    }
}
