package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/* Sum of elements between k1 and k2. */
public class K1thAndK2th {

    // Time Complexity - O(N * logN), Auxiliary Space - O(K2)
    public static void main(String[] args) {
        int k1 = 3;
        int k2 = 6;
        int[] arr = {20, 8, 22, 4, 12, 10, 14};

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int element : arr) {
            pq.add(element);
            if (pq.size() > k2) pq.remove();
        }

        pq.remove();
        int sum = 0;
        while (pq.size() != k1) sum += pq.remove();
        System.out.println(sum);
    }
}
