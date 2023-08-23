package Recursion;

/**
 * There are N stones, numbered 1,2,…,N. For each i (1≤i≤N), the height of Stone ith is hi.
 * There is a frog who is initially on Stone 1.
 * He will repeat the following action some number of times to reach Stone N:
 * If the frog is currently on Stone i, jump to Stone i+1 or Stone i+2. Here, a cost of |hi - hj| is incurred, where j is the stone to land on.
 */
public class FrogJump {

    static int best(int[] h, int n, int idx) {
        if (idx == n - 1) return 0;
        int op1 = Math.abs(h[idx] - h[idx + 1]) + best(h, n, idx + 1);

        if (idx == n - 2) return 0;
        int op2 = Math.abs(h[idx] - h[idx + 2]) + best(h, n, idx + 2);

        return Math.min(op1, op2);
    }

    public static void main(String[] args) {
        int[] h = {10, 30, 40, 20};
        System.out.println(best(h, h.length, 0));

    }

}
