package queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * FIFO - First In First Out
 */
public class Basics {

   public static void main(String[] args) {
      Queue<Integer> q = new ArrayDeque<>();
      Queue<Integer> q2 = new LinkedList<>();

      // 3 Basics Operations
      q.add(1);
      q.add(2);
      q.remove(); // q.poll() is also the same.
      q.peek();
      q2.add(4);
   }
}
