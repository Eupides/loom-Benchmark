package stretz.loom.benchmark.strategy.cpu;

public class CalculatorFactory {
    public static CalculationStrategy getNewCalculator(CalculationStrategy strategy) {
        if (strategy.getClass() == SimpleCalculation.class) {
            SimpleCalculation newStrategy = (SimpleCalculation) strategy;
            return new SimpleCalculation(
                    newStrategy.getCalculationCycles(),
                    newStrategy.getMaxInt(),
                    newStrategy.getSleepTime());
        } else {
            throw new IllegalArgumentException("CalculationStrategy now accepted");
        }
    }
}
