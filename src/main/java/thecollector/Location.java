package thecollector;

import java.io.Serializable;
import java.util.ArrayList;

public class Location implements Serializable {
    protected String name;
    protected ArrayList<Car> cars;

    public Location(String name, ArrayList<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            output.append(cars.get(i));
            output.append("\n");
        }
        return String.format("%s:\n%s", Ui.formatCarsListString(this), output);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
