package dp;

public class JobSchedule {

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] minDiff = new int[d + 1][n + 1];

        for (int daysRemaining = 0; daysRemaining <= d; daysRemaining++) {
            for (int i = 0; i < n; i++) {
                minDiff[daysRemaining][i] = Integer.MAX_VALUE;
            }
        }

        for (int daysRemaining = 1; daysRemaining <= d; daysRemaining++) {
            for (int i = 0; i < n - daysRemaining + 1; i++) {
                int dailyMaxJobDiff = 0;

                for (int j = i + 1; j < n - daysRemaining + 2; j++) {
                    dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[j - 1]);
                    if (minDiff[daysRemaining - 1][j] != Integer.MAX_VALUE) {
                        minDiff[daysRemaining][i] = Math.min(minDiff[daysRemaining][i], dailyMaxJobDiff + minDiff[daysRemaining - 1][j]);
                    }
                }
            }
        }
        return minDiff[d][0] < Integer.MAX_VALUE ? minDiff[d][0] : -1;
    }

    public static void main(String[] args) {

    }
}
