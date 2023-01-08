package stretz.loom.benchmark.strategy.cpu;

import java.util.concurrent.TimeUnit;

public class SimpleCalculation implements CalculationStrategy {
    private int calculationCycles;
    private int maxInt;

    public SimpleCalculation(int calculationCycles, int maxInt) {
        this.calculationCycles = calculationCycles;
        this.maxInt = maxInt;
    }

    @Override
    public void calculate() {
        int start = 2;

        for (int i = 0; i < calculationCycles; i++) {
            sumToMaxInt(start);
        }
    }

    private void sumToMaxInt(int start) {
        int sum = start;
        while ((maxInt / sum) < sum) {
            sum = sum*sum;
        }
    }

    public int getMaxInt() {
        return maxInt;
    }

    public int getCalculationCycles() {
        return calculationCycles;
    }

    public long getSleepTime() {
        return calculationCycles;
    }
}
