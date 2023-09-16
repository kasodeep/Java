package stacks;

import java.util.Stack;

public class LargestHistogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] nse = new int[n];
        int[] pse = new int[n];

        // Calculate nse[]
        st.push(n - 1);
        nse[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() == 0)
                nse[i] = n;
            else
                nse[i] = st.peek();
            st.push(i);
        }

        // Emptying Stack
        while (st.size() > 0)
            st.pop();

        // Calculate pse[]
        st.push(0);
        pse[0] = -1;

        for (int i = 1; i <= n - 1; i++) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() == 0)
                pse[i] = -1;
            else
                pse[i] = st.peek();
            st.push(i);
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    public static long getMaxArea(long[] hist, long n) {
        Stack<Integer> st = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || hist[st.peek()] >= hist[i])) {
                long height = hist[st.pop()];
                long width;

                if (st.isEmpty()) width = i;
                else width = i - st.peek() - 1;

                long area = width * height;
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
