package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {

    public static int[] JobScheduling(Job[] arr, int n) {

        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.profit == j2.profit ?
                        Integer.compare(j1.deadline, j2.deadline) :
                        Integer.compare(j2.profit, j1.profit);
            }
        });

        int jobs = 0, max = 0;
        boolean[] isDone = new boolean[n];

        for (Job job : arr) {
            for (int i = job.deadline - 1; i >= 0; i--) {
                if (isDone[i]) continue;
                isDone[i] = true;

                jobs++;
                max += job.profit;
                break;
            }
        }
        return new int[]{jobs, max};
    }

    public static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
