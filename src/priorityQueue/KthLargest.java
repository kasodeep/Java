package priorityQueue;

import java.util.PriorityQueue;

public class KthLargest {

    // Time Complexity - O(N * logN), Auxiliary Space - O(K)
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 5};
        int k = 3;

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
