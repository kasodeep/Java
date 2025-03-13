package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SlidingWindow {

    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int z = 0;

        // Finding the next greater elements.
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        st.push(n - 1);
        nge[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nge[i] = n;
            else
                nge[i] = st.peek();
            st.push(i);
        }

        // Using two pointer approach moving to the next greater as long as it is in the window.
        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (j >= i + k)
                j = i;
            int max = arr[j];
            while (j < i + k) {
                max = arr[j];
                j = nge[j];
            }
            ans[z++] = max;
        }
        return ans;
    }

    public int[] maxSlidingWindowTwo(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];
        Deque<Integer> win = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            while (!win.isEmpty() && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            while (!win.isEmpty() && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            win.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }
}
