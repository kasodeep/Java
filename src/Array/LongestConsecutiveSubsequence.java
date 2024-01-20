package Array;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    static int findLongestConsecutiveSubSeq(int[] arr, int N) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
            max = Math.max(num, max);
        }

        int i = 0, temp = 0, len = 0;
        while (i <= max) {
            if (set.contains(i)) temp++;
            else temp = 0;

            len = Math.max(len, temp);
            i++;
        }
        return len;
    }
}
