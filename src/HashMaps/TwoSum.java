package HashMaps;

import java.util.HashMap;

public class TwoSum {

   public int[] twoSum(int[] nums, int target) {
      int n = nums.length;
      int[] ans = { -1 };
      // Value, Index
      HashMap<Integer, Integer> mp = new HashMap<>();

      for (int i = 0; i < n; i++) {
         if (mp.containsKey(target - nums[i])) {
            ans = new int[] { i, mp.get(target - nums[i]) };
            return ans;
         }
         mp.put(nums[i], i);
      }
      return ans;
   }

   public static void main(String[] args) {

   }
}
