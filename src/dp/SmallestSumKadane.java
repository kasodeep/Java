package dp;

public class SmallestSumKadane {

    public static int smallestSumSubArray(int[] a, int size) {
        int ans = a[0];
        int curr = a[0];

        for (int i = 1; i < size; i++) {
            curr = Math.min(a[i], curr + a[i]);
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}
