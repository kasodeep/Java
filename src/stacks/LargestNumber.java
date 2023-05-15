package stacks;

import java.util.Stack;

public class LargestNumber {

   // Return the largest number, don't change the relative order.
   public static String largestNumber(int n, int[] a, int k) {
      Stack<Integer> s = new Stack<>();

      for (int i = 0; i < n; i++) {
         while (n - i > k && s.size() > 0 && s.peek() < a[i]) {
            s.pop();
            k++;
         }
         s.push(a[i]);
         k--;
      }

      StringBuffer ans = new StringBuffer();
      for (int i = 0; i < s.size(); i++) {
         ans.append(Integer.toString(s.get(i)));
      }
      return ans.toString();
   }
}
