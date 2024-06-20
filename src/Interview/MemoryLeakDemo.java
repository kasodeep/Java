package Interview;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }

        System.out.println("Size before gc: " + list.size());
        // Suggesting garbage collection.
        System.gc();
        // Adding time to allow gc to run.
        threadSleep();
        System.out.println("Size after gc: " + list.size());

        list.clear();
    }

    private static void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
