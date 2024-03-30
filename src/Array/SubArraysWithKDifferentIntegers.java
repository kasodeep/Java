package Array;

import java.util.HashMap;

/**
 * For counting sub-arrays with less than some value, we need to use this approach!
 */
public class SubArraysWithKDifferentIntegers {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k - 1);
    }

    private static int slidingWindowAtMost(int[] nums, int distinctK) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, totalCount = 0;

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() > distinctK) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);

                if (freqMap.get(nums[left]) == 0) freqMap.remove(nums[left]);
                left++;
            }
            totalCount += (right - left + 1);
        }
        return totalCount;
    }
}
