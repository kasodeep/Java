package dp.commonsubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    static int longestSubsequence(int size, int[] a) {
        int[] nums = new int[size];
        int len = 1;
        nums[0] = a[0];

        for (int i = 1; i < size; i++) {
            if (a[i] > nums[len - 1]) {
                nums[len++] = a[i];
            } else {
                int ind = Arrays.binarySearch(nums, 0, len, a[i]);
                if (ind < 0) ind = -(ind + 1);
                nums[ind] = a[i];
            }
        }
        return len;
    }
}
