package BackTracking;

public class PartitionIntoKSubsets {

    public boolean find(int sum, int[] a, int n, int k, int currSum, boolean[] flag) {
        if (currSum > sum) {
            return false;
        }

        if (k == 0) {
            return true;
        }

        if (currSum == sum) {
            return find(sum, a, n, k - 1, 0, flag);
        }

        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                if (find(sum, a, n, k, currSum + a[i], flag)) {
                    return true;
                }
                flag[i] = false;
            }
        }

        return false;
    }

    public boolean isKPartitionPossible(int[] a, int n, int k) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        if (k > n || sum % k != 0) {
            return false;
        }

        boolean[] flag = new boolean[n];
        sum /= k;
        boolean ans = find(sum, a, n, k, 0, flag);
        return ans;
    }
}
