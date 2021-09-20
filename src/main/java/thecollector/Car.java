package thecollector;

public class Car {
    String brand;
    String modelName;
    int value;

    public Car(String brand, String modelName, int value) {
        this.brand = brand;
        this.modelName = modelName;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s %s (Est. value: %d)", brand, modelName, value);
    }
}
