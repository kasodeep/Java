package queue;

/**
 * Array Implementation of Queue.
 * Disadvantages -> size issue,
 */
public class ArrayImplementation {

   public static class QueueArray {
      private int f = -1;
      private int r = -1;
      int size = 0;
      private int[] arr = new int[100];

      // Add Function
      public void add(int val) {
         if (r == arr.length - 1) {
            System.out.println("Queue is Full!");
            return;
         }

         if (f == -1) {
            f = r = 0;
            arr[r] = val;
         } else {
            arr[++r] = val;
         }
         size++;
      }

      // Remove Function
      public int remove() {
         if (size == 0) {
            System.out.println("Queue is Empty!");
         }
         f++;
         size--;
         return arr[f - 1];
      }

      // Return the First Element
      public int peek() {
         if (size == 0) {
            System.out.println("Queue is Empty!");
         }
         return arr[f];
      }

      // Display the Queue from r to f.
      public void display() {
         if (size == 0) {
            System.out.println("Queue is Empty!");
         } else {
            for (int i = f; i <= r; i++) {
               System.out.print(arr[i] + " ");
            }
            System.out.println();
         }
      }

   }

   public static void main(String[] args) {
      QueueArray q = new QueueArray();
      q.add(2);
      q.add(5);
      q.add(8);
      q.remove();
      q.display();
   }
}
