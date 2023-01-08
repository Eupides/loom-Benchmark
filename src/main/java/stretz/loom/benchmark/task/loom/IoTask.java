package stretz.loom.benchmark.task.loom;

import stretz.loom.benchmark.strategy.io.FileCreator;
import stretz.loom.benchmark.strategy.io.FileEditor;
import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.TaskState;
import stretz.loom.benchmark.util.FileUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IoTask implements Task {
    private TaskState state = TaskState.NOT_STARTED;
    private final int fileNumber;
    private final int editorNumber;
    private final String path = "./tests/";

    public IoTask(int fileNumber, int editorNumber) {
        this.fileNumber = fileNumber;
        this.editorNumber = editorNumber;
    }
    @Override
    public TaskState execute() {
        this.state = TaskState.ACTIVE;

        try (ExecutorService creatorExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= fileNumber; i++) {
                FileCreator creator = new FileCreator(this.path + i, ".txt");
                creatorExecutor.execute(creator);
            }
        }

        try (ExecutorService editorExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            final Object lock = new Object();
            for (int j = 1; j <= editorNumber; j++) {
                FileEditor editor = new FileEditor(this.path + "1", "Thread " + j + "\n", lock);
                editorExecutor.execute(editor);
            }
        }

        FileUtil.cleanUp(this.path);
        this.state = TaskState.DONE;
        return this.state;
    }

    @Override
    public TaskState getState() {
        return this.state;
    }
}
