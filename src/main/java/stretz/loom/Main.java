package stretz.loom;

import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.loom.CPUTask;
import stretz.loom.benchmark.task.loom.IoTask;

/**
 * Main Entry into the program
 * required arguments:
 * 1.: Task-Type (CPU, IO, MEM)
 * 2.: thread type (normal, loom)
 * non-required (dependent on task-type):
 * CPU:
 *      3.: maximum threads
 * IO:
 *      3.: number of created files
 */
public class Main {
    public static void main(String[] args) {
        String taskType = args[0];
        String threadType = args[1];
        Task task = null;

        if(threadType.equals("loom")) {
            switch (taskType) {
                case "CPU":
                    task = new CPUTask();
                    break;
                case "IO":
                    task = new IoTask();
                    break;
                case "MEM":
                    System.err.println("MEM needs to be implemented");
                default:
                    System.err.println("Task Type invalid, please use CPU, IO, or MEM");
                    break;
            }
        } else if(threadType.equals("normal")){
            switch (taskType) {
                case "CPU":
                    task = new stretz.loom.benchmark.task.normal.CPUTask();
                    break;
                case "IO":
                    task = new stretz.loom.benchmark.task.normal.IoTask();
                    break;
                case "MEM":
                    System.err.println("MEM needs to be implemented");
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