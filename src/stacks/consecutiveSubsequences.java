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
        int[] arr = {1, 2, 3, 3, 3, 5, 5, 6, 5, 6};
        int[] ans = remove(arr);

        for (int i = ans.length - 1; i >= 0; i--) {
            System.out.print(ans[i] + " ");
        }
    }
}
