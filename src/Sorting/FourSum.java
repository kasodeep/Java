package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int l = i + 1; l < nums.length - 1; l++) {
                if (l > i + 1 && nums[l] == nums[l - 1]) continue;

                // Two Pointers.
                int j = l + 1;
                int k = nums.length - 1;
                while (j < k) {
                    long sum = nums[i];
                    sum += nums[l];
                    sum += nums[j];
                    sum += nums[k];

                    if (sum > target) k--;
                    else if (sum < target) j++;
                    else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[l]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ls.add(temp);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    }
                }
            }
        }
        return ls;
    }
}
