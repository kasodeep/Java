package Greedy;

import java.util.Arrays;

public class MaxLengthChain {

    public static int findLongestChain(int[][] pairs) {
        int count = 1;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int currentEnd = pairs[0][1];

        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > currentEnd) {
                count++;
                currentEnd = pairs[i][1];
            }
        }
        return count;
    }
}
