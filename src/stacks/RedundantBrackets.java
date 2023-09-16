package stacks;

import java.util.Stack;

public class RedundantBrackets {

    static boolean checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();

        for (char ch : str) {
            if (ch == ')') {
                boolean flag = true;
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        flag = false;
                    }
                }
                if(!st.isEmpty()) st.pop();
                if (flag) return true;
            } else {
                st.push(ch);
            }
        }
        return false;
    }

    static void findRedundant(String str) {
        boolean ans = checkRedundancy(str);
        if (ans) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        findRedundant(str);
    }
}

