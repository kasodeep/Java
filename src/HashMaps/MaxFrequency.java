package HashMaps;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {

   public static void main(String[] args) {

      int[] arr = { 1, 2, 3, 4, 1, 3, 4, 5, 1, 1, 3, 4, 6, 1, 2, 6, 6, 2, 2, 4, 4, 4, 5 };
      Map<Integer, Integer> freq = new HashMap<>();

      for (int el : arr) {
         if (!freq.containsKey(el)) {
            freq.put(el, 1);
         } else {
            freq.put(el, freq.get(el) + 1);
         }
      }

      int mxFreq = 0, ansKey = -1;
      for (var e : freq.entrySet()) {
         if (e.getValue() > mxFreq) {
            mxFreq = e.getValue();
            ansKey = e.getKey();
         }
      }

      System.out.printf("%d has max frequency and it occurs %d times", ansKey, mxFreq);
   }
}
