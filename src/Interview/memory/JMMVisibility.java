package Interview.memory;

/**
 * javac JMMVisibility.java
 * <p>
 * java -server \
 * -XX:+UnlockDiagnosticVMOptions \
 * -XX:+PrintCompilation \
 * JMMVisibility
 */
public class JMMVisibility {

    static boolean running = true; // try with and without 'volatile'

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            long counter = 0;
            while (running) {
                counter++;
            }
            System.out.println("Stopped at: " + counter);
        });

        t.start();

        Thread.sleep(1000);

        running = false;

        t.join();
        System.out.println("Main thread finished");
    }
}
