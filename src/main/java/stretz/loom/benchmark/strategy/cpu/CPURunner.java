package stretz.loom.benchmark.strategy.cpu;

import java.util.concurrent.TimeUnit;

public class CPURunner implements Runnable {
    private CalculationStrategy strategy;
    private final int waitTime;

    public CPURunner(CalculationStrategy strategy, int waitTime) {
        this.strategy = strategy;
        this.waitTime = waitTime;
    }
    @Override
    public void run() {
        try {
            strategy.calculate();
            if (this.waitTime > 0) {
                TimeUnit.SECONDS.sleep(waitTime);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
