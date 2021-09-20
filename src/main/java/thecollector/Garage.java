package thecollector;

import java.io.Serializable;
import java.util.TreeMap;

public class Garage implements Serializable {
    private String name;
    private TreeMap<Integer, Car> cars;

    public Garage(String name, TreeMap<Integer, Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return this.name;
    }

    public void addCar(Car car) {
        cars.put(cars.size(), car);
    }

    public Car removeCar(int key) {
        return cars.remove(key);
    }

    public String listAllCars() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            output.append(cars.get(i));
            output.append("\n");
        }
        return String.format("%s\n%s", Ui.formatGarageListString(this), output);
    }
}
