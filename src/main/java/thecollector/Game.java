package thecollector;

import java.io.IOException;
import java.io.Serializable;
import java.util.TreeMap;

public class Game implements Serializable {
    public static final int STARTING_MONEY = 10000_00;
    public static final Garage STARTING_GARAGE = new Garage("Default Garage", new TreeMap<>());
    public static final Dealer STARTING_DEALER = new Dealer("Good Cars Dealer", 3);
    private final Player player;
    private final Dealer[] dealers;
    private int monthsPassed;

    public Game() {
        this.player = new Player(Ui.promptPlayerName(), STARTING_MONEY, STARTING_GARAGE);
        this.dealers = new Dealer[]{STARTING_DEALER};
    }

    public void advanceTime() {
        monthsPassed++;
    }

    public void advanceTime(int months) {
        monthsPassed += months;
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer[] getDealers() {
        return dealers;
    }

    public void play() throws IOException {
        System.out.printf("Hi %s!", player.getName());
        Storage.writeSave(this);
    }
}
