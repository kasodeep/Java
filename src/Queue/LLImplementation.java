package Queue;

import java.util.EmptyStackException;

/**
 * Linked List Implementation of Queue.
 * Advantages -> Size is unlimited, Works like a LL.
 */
public class LLImplementation {

    public static void main(String[] args) {
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        queue.add("John");
        queue.add("Seth");
        queue.add("Becky Lynch");

        System.out.println(queue.peek());
        queue.remove();
        queue.display();
    }

    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public static class QueueLinkedList<T> {
        int size = 0;
        private Node<T> head = null;
        private Node<T> tail = null;

        // Add Function
        public void add(T x) {
            Node<T> temp = new Node<>(x);
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        // Remove Function
        public T remove() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            T x = head.data;
            head = head.next;
            size--;
            return x;
        }

        // Peek Function
        public T peek() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return head.data;
        }

        // Function to Display
        public void display() {
            Node<T> temp = head;
            while (temp != null) {
                System.out.print(temp.data + ",");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
