package thecollector;

import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private int money;
    private Garage garage;

    public Player(String name, int money, Garage garage) {
        this.name = name;
        this.money = money;
        this.garage = garage;
    }

    public String getName() {
        return name;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public Garage getGarage() {
        return garage;
    }
}
