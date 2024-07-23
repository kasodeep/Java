package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestSubArraySum {

    public static int kthLargest(int N, int K, int[] Arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int sum = Arr[i];
            q.add(sum);

            for (int j = i + 1; j < N; j++) {
                sum += Arr[j];
                q.add(sum);
            }
        }

        int max = 0;
        for (int i = 0; i < K; i++) max = q.poll();
        return max;
    }
}
