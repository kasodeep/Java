package Interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // Single Thread
        ExecutorService singleThreadService = Executors.newSingleThreadExecutor();
        System.out.println("Single Thread Executor: ");
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            singleThreadService.execute(() -> System.out.println("Single Thread Task " + taskId
                    + " executed by Thread: " + Thread.currentThread().getName()));
        }

        // Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        System.out.println("\nFixed Thread Pool: ");
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            fixedThreadPool.execute(() -> System.out.println("Fixed Thread Task " + taskId
                    + " executed by Thread: " + Thread.currentThread().getName()));
        }

        fixedThreadPool.shutdown();
        try {
            if (!fixedThreadPool.awaitTermination(800, TimeUnit.MILLISECONDS))
                fixedThreadPool.shutdownNow();
        } catch (InterruptedException e) {
            fixedThreadPool.shutdown();
        }

        // Cached Thread Pool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("\nCached Thread Pool: ");
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            cachedThreadPool.execute(() -> System.out.println("Cached Thread Task " + taskId
                    + " executed by Thread: " + Thread.currentThread().getName()));
        }
        cachedThreadPool.shutdown();

        // Scheduled Thread Pool
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(() ->
                System.out.println("Scheduled Task"), 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() ->
                System.out.println("Scheduled Task"), 0, 1, TimeUnit.SECONDS);
    }
}
