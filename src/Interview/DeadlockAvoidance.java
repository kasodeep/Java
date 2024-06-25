package Interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockAvoidance {

    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                if (acquireLocks(lock1, lock2)) {
                    doWork();
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire lock!");
                }
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            try {
                if (acquireLocks(lock1, lock2)) {
                    doWork();
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire lock!");
                }
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }, "Thread2");

        thread1.start();
        thread2.start();
    }

    private static void doWork() {
        System.out.println(Thread.currentThread().getName() + " doing work!");
    }

    private static boolean acquireLocks(Lock firstLock, Lock secondLock) {
        boolean gotFirstLock = false;
        boolean gotSecondLock = false;

        while (true) {
            try {
                gotFirstLock = firstLock.tryLock(50, TimeUnit.MILLISECONDS);
                gotSecondLock = secondLock.tryLock(50, TimeUnit.MILLISECONDS);
                return gotSecondLock && gotFirstLock;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (gotFirstLock && !gotSecondLock) {
                    firstLock.unlock();
                }
                if (!gotFirstLock && gotSecondLock) {
                    secondLock.unlock();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
