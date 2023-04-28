package stacks;

import java.util.Stack;

public class SlidingWindow {

   public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;

      // The ans array.
      int[] ans = new int[n - k + 1];
      int z = 0;

      // Finding the next greater element
      Stack<Integer> st = new Stack<>();
      int[] nge = new int[n];
      st.push(n - 1);
      nge[n - 1] = n;
      for (int i = n - 2; i >= 0; i--) {
         while (st.size() > 0 && nums[i] > nums[st.peek()]) {
            st.pop();
         }
         if (st.size() == 0)
            nge[i] = n;
         else
            nge[i] = st.peek();
         st.push(i);
      }

      // Using two pointer approach moving to the next greater as long as it is in the
      // window.
      int j = 0;
      for (int i = 0; i < n - k + 1; i++) {
         if (j >= i + k)
            j = i;
         int max = nums[j];
         while (j < i + k) {
            max = nums[j];
            j = nge[j];
         }
         ans[z++] = max;
      }
      return ans;
   }

}
