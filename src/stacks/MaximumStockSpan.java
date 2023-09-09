package stacks;

import java.util.Stack;

public class MaximumStockSpan {

    public static int[] maxSpan(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            if (!st.isEmpty())
                res[i] = i - st.peek();
            else
                res[i] = i + 1;
            st.push(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {74, 665, 742, 512, 254, 469, 748, 445, 663, 758, 38, 69, 724, 142, 339, 779, 317, 636, 591, 243,
                289, 507, 241, 143, 65, 249, 247, 606, 691, 339, 371, 151, 607, 702, 394, 349, 439, 624, 8, 5, 755, 357,
        };
        int[] res = maxSpan(arr);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
