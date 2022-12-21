package stretz.loom.benchmark.strategy.io;

import java.io.File;
import java.io.FileWriter;

public class FileEditor implements Runnable{
    private final File file;
    private final String text;
    private final Object lock;
    public FileEditor(String filePath, String text, Object lock) {
        this.file = new File(filePath + ".txt");
        this.text = text;
        this.lock = lock;
    }

    public void run() {
        synchronized(this.lock) {
            /** @todo make append mode not hardcoded */
            try (FileWriter writer = new FileWriter(this.file, true)){
                writer.write(this.text);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
