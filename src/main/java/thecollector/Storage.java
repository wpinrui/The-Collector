package thecollector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Encapsulates the methods needed to read and write to a save file.
 *
 * @author Ivan Wong
 */
public class Storage {
    private static final String path = "save.txt";

    /**
     * Writes the contents of the game state to the save file.
     *
     * Code reused from Datsabk (https://mkyong.com/java/how-to-read-and-write-java-object-to-a-file/)
     * @param game The game to be saved
     * @throws IOException If the file cannot be written to
     */
    public static void writeSave(Game game) throws IOException {
        FileOutputStream writeData = new FileOutputStream(path);
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(game);
        writeStream.flush();
        writeStream.close();
    }

    /**
     * Reads the contents of the save file and returns the Game object containing the game state.
     *
     * Code reused from Datsabk (https://mkyong.com/java/how-to-read-and-write-java-object-to-a-file/)
     * @return Game object containing game state
     * @throws IOException            If the reading of the file fails
     * @throws ClassNotFoundException If the save data is of a missing class
     */
    public static Game readSave() throws IOException, ClassNotFoundException {
        File f = new File(path);
        if (f.createNewFile()) { // created a blank save file
            return new Game();
        }
        FileInputStream readData = new FileInputStream(path);
        ObjectInputStream readStream = new ObjectInputStream(readData);
        Game readList = (Game) readStream.readObject();
        readStream.close();
        return readList;
    }
}
