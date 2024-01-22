package stacks;


import java.util.*;

public class StackPermutations {

    public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> s = new Stack<>();
        int j = 0;

        for (Integer num : ip) {
            s.push(num);
            while (!s.empty() && s.peek().equals(op[j])) {
                s.pop();
                j++;
            }
        }

        if (j != op.length) return 0;
        return 1;
    }

    public static void main(String[] args) {

    }
}
