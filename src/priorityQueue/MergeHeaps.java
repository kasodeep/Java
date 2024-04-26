package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MergeHeaps {

    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] ans = new int[m + n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : a) pq.add(num);
        for (int num : b) pq.add(num);

        int i = 0;
        while (pq.size() > 0) ans[i++] = pq.poll();
        return ans;
    }
}
