package queue;

public class CircularQueue {

    public static void main(String[] args) throws Exception {

    }

    public static class CircularQueueArray {
        private final int[] arr = new int[100];
        int size = 0;
        private int rear = -1;
        private int front = -1;

        // Add Function
        public void add(int x) throws Exception {
            if (size == arr.length) {
                throw new Exception("Queue is Full!");
            } else if (size == 0) {
                front = rear = 0;
                arr[0] = x;
            } else if (rear < arr.length - 1) {
                arr[++rear] = x;
            } else if (rear == arr.length - 1) {
                rear = 0;
                arr[0] = x;
            }
            size++;
        }

        // Remove Function
        public int remove() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is Empty!");
            } else {
                int val = arr[front];
                if (front == arr.length - 1)
                    front = 0;
                else
                    front++;
                size--;
                return val;
            }
        }

        // Peek Function
        public int peek() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is Empty!");
            } else
                return arr[front];
        }

        // Display Function
        public void display() {
            if (size == 0) {
                System.out.println("Queue is Empty!");
                return;
            } else if (front <= rear) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = front; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
