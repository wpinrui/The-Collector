package thecollector;

import java.io.IOException;

/**
 * This class is the entry-point for the game to run.
 *
 * @author Ivan Wong
 */
public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Game game = Storage.readSave();
            game.play();
        } catch (IOException e) {
            System.out.println("IOException. Save file not found. New game started.");
            Game game = new Game();
            game.play();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException. This should not occur.");
            System.exit(0);
        }
    }
}
