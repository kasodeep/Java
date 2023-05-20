package HashMaps;

import java.util.HashMap;

public class LargestSubArray {

   static int zeroSumLargestSubarray(int[] arr, int n) {
      // prefixSum, Index
      HashMap<Integer, Integer> mp = new HashMap<>();
      int maxLen = 0, prefixSum = 0;
      mp.put(0, -1);

      for (int i = 0; i < arr.length; i++) {
         prefixSum += arr[i];
         if (mp.containsKey(prefixSum)) {
            maxLen = Math.max(maxLen, i - mp.get(prefixSum));
         } else {
            mp.put(prefixSum, i);
         }
      }
      return maxLen;
   }

   public static void main(String[] args) {

   }
}
