package Daily.GfG;

public class DuplicateKnapsack {

    public static int knapSack(int N, int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];

        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < N; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int N = 4;
        int W = 8;
        int[] val = {6, 1, 7, 7};
        int[] wt = {1, 3, 4, 5};
        System.out.println(knapSack(N, W, val, wt));
    }
}
