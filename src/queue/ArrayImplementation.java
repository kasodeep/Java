package queue;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * Array Implementation of Queue.
 * Disadvantages -> size issue.
 */
public class ArrayImplementation {

    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray<>(Integer.class, 5);
        q.add(2);
        q.add(5);
        q.add(8);
        System.out.println(q.remove());
        q.display();
    }

    public static class QueueArray<T> {
        private final T[] arr;
        int size = 0;
        private int front = -1;
        private int rear = -1;

        @SuppressWarnings("unchecked")
        public QueueArray(Class<T> clazz) {
            arr = (T[]) Array.newInstance(clazz, 100);
        }

        @SuppressWarnings("unchecked")
        public QueueArray(Class<T> clazz, int size) {
            arr = (T[]) Array.newInstance(clazz, size);
        }

        // Add Function
        public void add(T val) {
            if (rear == arr.length - 1) {
                System.out.println("Queue is Full!");
                return;
            }

            if (front == -1) {
                front = rear = 0;
                arr[rear] = val;
            } else {
                arr[++rear] = val;
            }
            size++;
        }

        // Remove Function
        public T remove() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            front++;
            size--;
            return arr[front - 1];
        }

        // Return the First Element
        public T peek() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return arr[front];
        }

        // Display the Queue from rear to front.
        public void display() {
            if (size == 0) {
                System.out.println("Queue is Empty!");
            } else {
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }

    }
}
