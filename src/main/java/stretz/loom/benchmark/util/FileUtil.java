package stretz.loom.benchmark.util;

import java.io.File;
import java.util.Objects;

public class FileUtil {
    /**
     * cleans the testingfolder where the files are created
     */
    public static void cleanUp(String path) {
        File dir = new File(path);
        for(File file: Objects.requireNonNull(dir.listFiles())) {
            if(!file.isDirectory()) {
                if(!file.delete()) {
                    System.out.println("couldn't delete " + path);
                }
            }
        }
    }
}