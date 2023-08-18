package Array.Questions;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 7, 4, 1};
        int k = 3;

        // Approach without sorting the array.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int element : arr) {
            if (pq.size() == k) {
                if (pq.peek() < element) {
                    pq.poll();
                    pq.add(element);
                }
                continue;
            }
            pq.add(element);
        }

        System.out.println(pq.peek());
    }
}
