package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, new Comparator<>() {
            public int compare(int[] interval, int[] otherInterval) {
                return Integer.compare(interval[0], otherInterval[0]);
            }
        });

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] prevInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            if (interval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            } else {
                mergedIntervals.add(interval);
            }
        }

        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);

        for (int[] num : merged) {
            for (int j = 0; j < 2; j++) System.out.print(num[j] + " ");
            System.out.println();
        }
    }
}
