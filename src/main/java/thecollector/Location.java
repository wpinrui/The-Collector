package thecollector;

import java.util.TreeMap;

public class Location {
    protected String name;
    protected TreeMap<Integer, Car> cars;

    public Location(String name, TreeMap<Integer, Car> cars) {
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
}
