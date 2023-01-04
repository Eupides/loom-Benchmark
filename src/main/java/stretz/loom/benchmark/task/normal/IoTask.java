package stretz.loom.benchmark.task.normal;

import stretz.loom.benchmark.strategy.io.FileCreator;
import stretz.loom.benchmark.strategy.io.FileEditor;
import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.TaskState;
import stretz.loom.benchmark.util.FileUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Handling of the IO Tasks
 */
public class IoTask implements Task {
    private TaskState state = TaskState.NOT_STARTED;
    private final int fileNumber;
    private final String path = "./tests/";

    public IoTask(int fileNumber) {
        this.fileNumber = fileNumber;
    }

    @Override
    public TaskState execute() {
        this.state = TaskState.ACTIVE;
        try (ThreadPoolExecutor creatorExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool()) {
            for (int i = 1; i <= fileNumber; i++) {
                FileCreator creator = new FileCreator(this.path + i, ".txt");
                creatorExecutor.execute(creator);
            }
        }


        try (ThreadPoolExecutor editorExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool()) {
            final Object lock = new Object();
            /** @todo make writing threads a variable, also fix filepath */
            int editorMax = 100000;
            for (int j = 1; j <= editorMax; j++) {
                FileEditor editor = new FileEditor(this.path + "1", "Thread " + j + "\n", lock);
                editorExecutor.execute(editor);
            }
        }

        FileUtil.cleanUp(this.path);
        System.out.println("done");
        this.state = TaskState.DONE;
        return TaskState.DONE;
    }

    @Override
    public TaskState getState() {
        return this.state;
    }
}
