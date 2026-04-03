package Interview.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * javac GCBehavior.java
 * <p>
 * java -Xms128m -Xmx128m \
 * -XX:+PrintGC \
 * -XX:+PrintGCDetails \
 * -XX:+PrintGCTimeStamps \
 * GCBehavior
 *
 */
public class GCBehavior {

    public static void main(String[] args) throws InterruptedException {

        List<byte[]> list = new ArrayList<>();

        while (true) {
            // Allocate 1MB
            byte[] block = new byte[1024 * 1024];
            list.add(block);

            // Slow it down so you can observe GC
            Thread.sleep(50);

            // Prevent unbounded growth occasionally
            if (list.size() > 50) {
                list.clear();
            }
        }
    }
}
