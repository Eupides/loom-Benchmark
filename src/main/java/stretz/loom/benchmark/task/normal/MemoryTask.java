package stretz.loom.benchmark.task.normal;

import stretz.loom.benchmark.strategy.memory.MemoryBloat;
import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.TaskState;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MemoryTask implements Task {
    private TaskState state = TaskState.NOT_STARTED;
    private final int bloatCount;
    private final int objectNumber;
    private final int subObjectNumber;
    private final int waitTime;

    public MemoryTask(int bloatCount, int objectNumber, int subObjectNumber, int waitTime) {
        this.bloatCount = bloatCount;
        this.objectNumber = objectNumber;
        this.subObjectNumber = subObjectNumber;
        this.waitTime = waitTime;
    }

    @Override
    public TaskState execute() {
        this.state = TaskState.ACTIVE;

        try (ThreadPoolExecutor bloatExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool()) {
            for (int i=0; i < bloatCount; i++) {
                bloatExecutor.execute(new MemoryBloat(waitTime, objectNumber, subObjectNumber));
            }
        }

        this.state = TaskState.DONE;
        System.out.println("Bloat done");

        return this.state;
    }

    @Override
    public TaskState getState() {
        return this.state;
    }
}
