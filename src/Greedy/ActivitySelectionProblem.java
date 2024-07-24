package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem {

    public static int activitySelection(int[] start, int[] end, int n) {
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pairs, Comparator.comparingInt(p -> p.end));

        int endTime = pairs[0].end;
        int activity = 1;

        for (int i = 1; i < n; i++) {
            if (endTime < pairs[i].start) {
                endTime = pairs[i].end;
                activity++;
            }
        }
        return activity;
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
