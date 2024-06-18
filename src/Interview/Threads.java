package Interview;

/**
 * New -> Runnable -> Running -> Non Runnable -> Terminated.
 */
public class Threads {
    public static void main(String[] args) {
        Temp temp = new Temp();
        temp.start();

        Hi hello = new Hi();
        Thread thread = new Thread(hello);
        thread.start();
    }
}

class Hi implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (i <= 10000) {
            System.out.println("Thread 2");
            i++;
        }
    }
}

class Temp extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i <= 10000) {
            System.out.println("Thread 2");
            i++;
        }
    }
}
