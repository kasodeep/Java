package queue;

/**
 * Traffic system: In computer controlled traffic system, circular queues are used to switch on the traffic lights one by one repeatedly as per the time set.
 * CPU Scheduling: Operating systems often maintain a queue of processes that are ready to execute or that are waiting for a particular event to occur.
 */
public class CircularQueue {

    public static void main(String[] args) throws Exception {
        CircularQueueArray queueArray = new CircularQueueArray(4);
        queueArray.add(10);
        queueArray.add(20);
        queueArray.add(30);
        queueArray.add(40);

        queueArray.display();
        queueArray.remove();
        queueArray.display();
        queueArray.add(10);
        queueArray.display();
    }

    public static class CircularQueueArray {
        private final int[] arr;
        int size;
        private int rear;
        private int front;

        public CircularQueueArray(int size) {
            arr = new int[size];
            front = -1;
            rear = -1;
        }

        // Add Function
        public void add(int x) throws Exception {
            if (size == arr.length) {
                throw new Exception("Queue is Full!");
            } else if (size == 0) {
                front = rear = 0;
                arr[0] = x;
            } else {
                rear = (rear + 1) % arr.length;
                arr[rear] = x;
            }
            size++;
        }

        // Remove Function
        public int remove() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is Empty!");
            } else {
                int val = arr[front];
                front = (front + 1) % arr.length;
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
