package stretz.loom.benchmark.strategy.io;

import java.io.File;
import java.io.IOException;

/**
 *  Runnable for creation of a single file
 * @TODO Handle filepath
 * @TODO Create Error Logging
 * @TODO Get Lorem Ipsum from different file
 */
public class FileCreator implements Runnable {
    private final File file;
    public FileCreator(String filePath, String format) {
        this.file = new File(filePath + format);
    }

    public void run() {
        this.createFile();
    }

    private void createFile() {
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            System.err.println("already exists: " + e.getMessage());
        }
    }
}
