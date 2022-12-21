package stretz.loom.benchmark.task.normal;

import stretz.loom.benchmark.strategy.cpu.CPURunner;
import stretz.loom.benchmark.strategy.cpu.CalculationStrategy;
import stretz.loom.benchmark.strategy.cpu.CalculatorFactory;
import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.TaskState;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CPUTask implements Task {
    private TaskState state = TaskState.NOT_STARTED;
    private CalculationStrategy strategy;
    private final int maxThreads;

    public CPUTask(CalculationStrategy strategy, int maxThreads) {
        this.strategy = strategy;
        this.maxThreads = maxThreads;
    }
    @Override
    public TaskState execute() {
        this.state = TaskState.ACTIVE;

        try (ThreadPoolExecutor calculatorExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool()) {
            for (int i = 0; i < maxThreads; i++) {
                CPURunner runner = new CPURunner(CalculatorFactory.getNewCalculator(this.strategy));
                calculatorExecutor.execute(runner);
            }
        }

        this.state = TaskState.DONE;
        System.out.println("calculator done");

        return this.state;
    }

    @Override
    public TaskState getState() {
        return state;
    }
}
