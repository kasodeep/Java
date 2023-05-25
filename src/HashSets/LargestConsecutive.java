package HashSets;

import java.util.HashSet;

public class LargestConsecutive {

   public static void main(String[] args) {
      int[] arr = { 1, 100, 200, 4, 3, 2, 99 };
      HashSet<Integer> st = new HashSet<>();

      for (int num : arr)
         st.add(num);
      int maxStreak = 0;

      for (Integer num : st) {
         if (!st.contains(num - 1)) { // num is starting point of a sequence
            int currNum = num;
            int currStreak = 1;

            while (st.contains(currNum + 1)) {
               currStreak++;
               currNum++;
            }
            maxStreak = Math.max(currStreak, maxStreak);
         }
      }
      System.out.println(maxStreak);
   }
}
