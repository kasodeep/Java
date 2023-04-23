package stacks;

import java.util.Stack;

public class consecutiveSubsequences {

   public static int[] remove(int[] arr) {
      int n = arr.length;
      Stack<Integer> st = new Stack<>();

      for (int i = 0; i < n; i++) {
         if (st.isEmpty() || st.peek() != arr[i])
            st.push(arr[i]);
         else if (arr[i] == st.peek())
            if (i == n - 1 || arr[i] != arr[i + 1])
               st.pop();
      }

      int[] res = new int[st.size()];
      for (int i = 0; i < res.length; i++) {
         res[i] = st.pop();
      }
      return res;
   }

   public static void main(String[] args) {

   }
}
