package stretz.loom.benchmark.strategy.memory;

import java.util.ArrayList;

public class MemoryBloat implements Runnable {
    int numberOfObjects;
    int numberOfSubObjects;

    public MemoryBloat(int numberOfObjects, int numberOfSubObjects) {
        this.numberOfObjects = numberOfObjects;
        this.numberOfSubObjects = numberOfSubObjects;
    }

    @Override
    public void run() {
        ArrayList<MemoryObject> objectList = new ArrayList<>();
        for(int i = 0; i < numberOfObjects; i++) {
            objectList.add(new MemoryObject(numberOfSubObjects));
        }
    }
}
