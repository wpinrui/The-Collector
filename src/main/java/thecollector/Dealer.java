package thecollector;

import java.io.Serializable;
import java.util.TreeMap;

public class Dealer implements Serializable {
    private TreeMap<Integer, Car> listings;
    private final String name;

    public Dealer(String name, int numberOfCars) {
        this.name = name;
        generateCarListings(numberOfCars);
    }

    public TreeMap<Integer, Car> getCarListings() {
        return listings;
    }

    public void generateCarListings(int numberOfCars) {
        // TODO: implement
    }

    public void removeFromListings(int treeKey) {
        // TODO: implement
    }

    ;

    @Override
    public String toString() {
        return this.name;
    }
}
