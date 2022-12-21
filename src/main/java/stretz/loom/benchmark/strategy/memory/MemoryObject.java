package stretz.loom.benchmark.strategy.memory;

import java.util.ArrayList;

public class MemoryObject {
    private ArrayList<Integer> list;

    public MemoryObject(int numberOfObjects) {
        this.fillList(numberOfObjects);
    }

    private void fillList(int numberOfObjects) {
        for(int i = 0; i < numberOfObjects; i++) {
            list.add(Integer.MAX_VALUE);
        }
    }
}
