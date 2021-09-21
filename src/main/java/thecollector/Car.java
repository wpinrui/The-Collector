package thecollector;

/**
 * This class represents a car object, which players can buy and sell.
 *
 * @author Ivan Wong
 */
public class Car {
    private String brand;
    private String modelName;
    private int value;

    /**
     * Constructor for a car.
     *
     * @param brand     Brand of the car
     * @param modelName Model name of the car
     * @param value     Value of the car
     */
    public Car(String brand, String modelName, int value) {
        this.brand = brand;
        this.modelName = modelName;
        this.value = value;
    }

    /**
     * Returns the string representation of a car object.
     *
     * @return String representation of a car
     */
    @Override
    public String toString() {
        return String.format("%s %s (Est. value: %s)", brand, modelName, Utilities.formatMoney(value));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }
        Car c = (Car) o;
        return brand.equals(c.brand)
                && modelName.equals(c.modelName)
                && value == c.value;
    }
}
