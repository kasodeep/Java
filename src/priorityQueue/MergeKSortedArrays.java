package priorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < K; i++) pq.offer(new int[]{arr[i][0], i, 0});

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int ele = temp[0], row = temp[1], col = temp[2];

            ans.add(ele);
            if (col + 1 < K) pq.offer(new int[]{arr[row][col + 1], row, col + 1});
        }
        return ans;
    }
}
