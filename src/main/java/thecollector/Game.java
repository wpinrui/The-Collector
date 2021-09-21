package thecollector;

import java.io.IOException;
import java.io.Serializable;
import java.util.TreeMap;

/**
 * This class contains all the data needed to describe the state of the game. An object of this class is written
 * to the save file to save the state.
 *
 * @author Ivan Wong
 */
public class Game implements Serializable {
    public static final int STARTING_MONEY = 10000_00;
    public static final Garage STARTING_GARAGE = new Garage("Default Garage", new TreeMap<>());
    public static final Dealer STARTING_DEALER = new Dealer("Good Cars Dealer", 3);
    private final Player player;
    private final Garage garage;
    private final Dealer dealer;
    private int monthsPassed;


    /**
     * Constructor for a game. A game object is commonly read directly from the save file, so this constructor
     * assumes a new game is being created.
     */
    public Game() {
        this.player = new Player(Ui.promptPlayerName(), STARTING_MONEY);
        this.dealer = STARTING_DEALER;
        this.garage = STARTING_GARAGE;
    }

    /**
     * Move forward the game time by a single month.
     */
    public void advanceTime() {
        monthsPassed++;
    }

    /**
     * Move the time forward by a specified number of months.
     *
     * @param months The number of months to move forward.
     */
    public void advanceTime(int months) {
        monthsPassed += months;
    }

    /**
     * Retrieves the player object associated with the instance of the game.
     *
     * @return Player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Retrieves the dealer object associated with the game.
     *
     * @return Dealer object
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * Begins the execution of the game.
     *
     * @throws IOException when unable to write to the save file
     */
    public void play() throws IOException {
        System.out.printf("Hi %s!", player.getName());
        Storage.writeSave(this);
    }
}
