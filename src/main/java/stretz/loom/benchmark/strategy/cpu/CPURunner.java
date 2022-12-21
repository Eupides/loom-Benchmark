package stretz.loom.benchmark.strategy.cpu;

public class CPURunner implements Runnable {
    private CalculationStrategy strategy;

    public CPURunner(CalculationStrategy strategy) {
        this.strategy = strategy;
    }
    @Override
    public void run() {
        try {
            strategy.calculate();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
