package stretz.loom;

import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.loom.CPUTask;
import stretz.loom.benchmark.task.loom.IoTask;
import stretz.loom.benchmark.task.loom.MemoryTask;

/**
 * Main Entry into the program
 * required arguments:
 * 1.: Task-Type (CPU, IO, MEM)
 * 2.: thread type (normal, loom)
 * non-required (dependent on task-type):
 * CPU:
 *      3.: maximum threads
 *      4.: number of calculation cycles
 *      5.: time in seconds a thread should sleep after ending a calculation
 *      6.: the max value of a calculation
 * IO:
 *      3.: number of created files
 *      4.: number of editors who want to edit the first file
 * MEM:
 *      3.: number of threads
 *      4.: number of bloat objects
 *      5.: number of bloat sub-object per bloat object
 *      6.: number of seconds each Thread should sleep before finishing
 */
public class Main {
    public static void main(String[] args) {
        String taskType = args[0].toLowerCase();
        String threadType = args[1].toLowerCase();
        Task task = null;

        if(threadType.equals("loom")) {
            switch (taskType) {
                case "cpu":
                    int maxThreads = args.length < 3 ? 1000 : Integer.parseInt(args[2]);
                    int calculationCycles = args.length < 4 ? 10 : Integer.parseInt(args[3]);
                    int threadSleepTime = args.length < 5 ? 0 : Integer.parseInt(args[4]);
                    int maxValue = args.length < 6 ? Integer.MAX_VALUE : Integer.parseInt(args[4]);
                    task = new CPUTask(maxThreads, calculationCycles, threadSleepTime, maxValue);
                    break;
                case "io":
                    int fileNumber = args.length < 3 ? 100 : Integer.parseInt(args[2]);
                    int editorNumber = args.length < 4 ? 10000 : Integer.parseInt(args[3]);
                    task = new IoTask(fileNumber, editorNumber);
                    break;
                case "mem":
                    int bloatCount = args.length < 3 ? 100 : Integer.parseInt(args[2]);
                    int objects = args.length < 4 ? 100 : Integer.parseInt(args[3]);
                    int subObjects = args.length < 5 ? 100 : Integer.parseInt(args[4]);
                    int waitTime = args.length < 6 ? 0 : Integer.parseInt(args[5]);
                    task = new MemoryTask(bloatCount, objects, subObjects, waitTime);
                    break;
                default:
                    System.err.println("Task Type invalid, please use CPU, IO, or MEM");
                    break;
            }
        } else if(threadType.equals("normal")){
            switch (taskType) {
                case "cpu":
                    int maxThreads = args.length < 3 ? 1000 : Integer.parseInt(args[2]);
                    int calculationCycles = args.length < 4 ? 10 : Integer.parseInt(args[3]);
                    int threadSleepTime = args.length < 5 ? 0 : Integer.parseInt(args[4]);
                    int maxValue = args.length < 6 ? Integer.MAX_VALUE : Integer.parseInt(args[4]);
                    task = new stretz.loom.benchmark.task.normal.CPUTask(maxThreads, calculationCycles, threadSleepTime, maxValue);
                    break;
                case "io":
                    int fileNumber = args.length < 3 ? 100 : Integer.parseInt(args[2]);
                    int editorNumber = args.length < 4 ? 10000: Integer.parseInt(args[3]);
                    task = new stretz.loom.benchmark.task.normal.IoTask(fileNumber, editorNumber);
                    break;
                case "mem":
                    int bloatCount = args.length < 3 ? 100 : Integer.parseInt(args[2]);
                    int objects = args.length < 4 ? 100 : Integer.parseInt(args[3]);
                    int subObjects = args.length < 5 ? 100 : Integer.parseInt(args[4]);
                    int waitTime = args.length < 6 ? 0 : Integer.parseInt(args[5]);
                    task = new stretz.loom.benchmark.task.normal.MemoryTask(bloatCount, objects, subObjects, waitTime);
                    break;
                default:
                    System.err.println("Task Type invalid, please use CPU, IO, or MEM");
                    break;
            }
        } else {
            System.err.println("Thread type invalid. Please use loom or normal");
        }

        if(task != null) {
            task.execute();
        }
    }
}