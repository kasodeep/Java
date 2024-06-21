package Interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        // Creating a blocking queue with a capacity of 5.
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        ProducerBlockingQueue producer = new ProducerBlockingQueue(queue);
        ConsumerBlockingQueue consumer = new ConsumerBlockingQueue(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }

    static class ProducerBlockingQueue implements Runnable {
        private final BlockingQueue<Integer> queue;

        public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(1000);
                    queue.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ConsumerBlockingQueue implements Runnable {
        private final BlockingQueue<Integer> queue;

        public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Integer item = queue.take();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
