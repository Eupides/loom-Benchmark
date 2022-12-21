package stretz.loom.benchmark.task;

public interface Task {
    public TaskState execute();
    public TaskState getState();
}
