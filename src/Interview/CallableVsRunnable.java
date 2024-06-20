package Interview;

import java.util.concurrent.*;

/*
 * Runnable is used to perform a lightweight task.
 * Callable is more suitable for handling a task asynchronously like fetching data or exception handling.
 * */
public class CallableVsRunnable {

    public static void main(String[] args) {
        int number = 10;
        Callable<Integer> sumTask = () -> {
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                if (i == 3) Thread.sleep(2000);
                sum += i;
            }
            return sum;
        };

        // Use ExecutorService to execute the Callable task
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(sumTask);

        try {
            // Get the result from the Callable task
            int result = future.get(); // waits for the complete result.
            System.out.println("The sum is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
