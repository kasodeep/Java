package Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {

    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                count1 = 1;
                candidate1 = num;
            } else if (count2 == 0 && num != candidate1) {
                count2 = 1;
                candidate2 = num;
            } else if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 == num) count1++;
            else if (candidate2 == num) count2++;
        }

        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);
        return result;
    }
}
