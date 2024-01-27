package Stacks;

import java.util.Stack;

public class LongestValidParenthesis {

    public static int findMaxLen(String str) {
        int n = str.length();

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(')
                stk.push(i);
            else {
                if (!stk.empty())
                    stk.pop();
                if (!stk.empty())
                    result = Math.max(result, i - stk.peek());
                else
                    stk.push(i);
            }
        }
        return result;
    }

    public static int findMaxLenTwo(String s, int n) {
        int left = 0, right = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right)
                maxLength = Math.max(maxLength, 2 * right);
            else if (right > left)
                left = right = 0;
        }

        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right)
                maxLength = Math.max(maxLength, 2 * left);
            else if (left > right)
                left = right = 0;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Function call
        System.out.println(findMaxLen("((()()()()(((())"));
        System.out.println(findMaxLenTwo("((()()()()(((())", 16));
    }
}
