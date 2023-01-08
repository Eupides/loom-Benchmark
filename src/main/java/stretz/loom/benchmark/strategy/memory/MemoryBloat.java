package stretz.loom.benchmark.strategy.memory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MemoryBloat implements Runnable {
    int waitTime;
    int numberOfObjects;
    int numberOfSubObjects;

    public MemoryBloat(int waitTime, int numberOfObjects, int numberOfSubObjects) {
        this.waitTime = waitTime;
        this.numberOfObjects = numberOfObjects;
        this.numberOfSubObjects = numberOfSubObjects;
    }

    @Override
    public void run() {
        ArrayList<MemoryObject> objectList = new ArrayList<>();
        for(int i = 0; i < numberOfObjects; i++) {
            objectList.add(new MemoryObject(numberOfSubObjects));
        }

        try {
            if(waitTime > 0) TimeUnit.SECONDS.sleep(waitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
