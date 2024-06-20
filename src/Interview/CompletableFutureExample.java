package Interview;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
 * It provides a powerful framework for building asynchronous applications.
 * Asynchronous Computation: You can run tasks asynchronously using supplyAsync or runAsync methods.
 * Chaining: You can chain multiple asynchronous tasks using methods like thenApply, thenAccept, thenRun, etc.
 * Combining Futures: You can combine multiple CompletableFuture instances using methods like thenCombine, thenCompose, allOf, anyOf.
 * Exception Handling: You can handle exceptions in the computation pipeline using exceptionally, handle, or whenComplete
 * */
public class CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // DB Task.
        CompletableFuture<String> dbFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetch();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenApply(String::toUpperCase);

        // Web Service.
        CompletableFuture<String> webFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchWeb();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenApply(String::toUpperCase);

        Thread.sleep(2000); // logic in main thread.
        String dbResult = dbFuture.get();
        String webResult = webFuture.get();

        System.out.println("Result: " + dbResult + " " + webResult);

        // combining two futures.
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, Integer::sum);
        combinedFuture.thenAccept(result -> System.out.println("Combined result: " + result));
    }

    private static String fetch() throws InterruptedException {
        System.out.println("Fetching data from database " + "(Thread: " + Thread.currentThread().getName() + ")");
        return "Hello";
    }

    private static String fetchWeb() throws InterruptedException {
        System.out.println("Fetching data from web service " + "(Thread: " + Thread.currentThread().getName() + ")");
        return "Data";
    }
}
