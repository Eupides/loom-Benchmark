package stretz.loom.benchmark.task.loom;

import stretz.loom.benchmark.strategy.cpu.CPURunner;
import stretz.loom.benchmark.strategy.cpu.CalculationStrategy;
import stretz.loom.benchmark.strategy.cpu.CalculatorFactory;
import stretz.loom.benchmark.strategy.cpu.SimpleCalculation;
import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.TaskState;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUTask implements Task {
    private TaskState state = TaskState.NOT_STARTED;
    private CalculationStrategy strategy;
    private final int maxThreads;

    public CPUTask(int maxThreads) {
        this.strategy = new SimpleCalculation(1000, Integer.MAX_VALUE);
        this.maxThreads = maxThreads;
    }

    @Override
    public TaskState execute() {
        this.state = TaskState.ACTIVE;

        try (ExecutorService calculatorExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
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
