package Interview;

/*
 * It refers to a type of thread that run in the background of an application, providing services to other threads or performing tasks independently.
 * */
public class DaemonThread {

    public static void main(String[] args) {
        startServer();
        System.out.println("Main thread started.");

        try {
            Thread.sleep(5000);
            System.out.println("Main thread exit.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startServer() {
        Thread loggerThread = new Thread(() -> {
            while (true) {
                System.out.println("Logging Server Activities..");
                try {
                    // simulate logging interval.
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        loggerThread.setDaemon(true);
        loggerThread.start();

        System.out.println("Server Started...");
    }
}
