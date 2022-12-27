package Recursion;

public class PowerOf {

    // Time Complexity - O(q)
    static int pow(int p, int q) {

        // Base Case
        if (q == 0)
            return 1;

        // Self-Work
        return pow(p, q - 1) * p;
    }

    // Time Complexity - O(logq)
    static int POW(int p, int q) {

        // Base Case
        if (q == 0)
            return 1;

        int ans = POW(p, q / 2);
        if (q % 2 == 0) {
            return ans * ans;
        } else {
            return p * ans * ans;
        }
    }

    public static void main(String[] args) {

    }
}
