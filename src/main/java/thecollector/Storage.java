package thecollector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Storage {
    private static final String path = "save.txt";

    public static void writeSave(Game game) throws IOException {
        FileOutputStream writeData = new FileOutputStream(path);
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(game);
        writeStream.flush();
        writeStream.close();
    }

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
