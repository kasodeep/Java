package Array;

public class JumpGame2 {

    public static int jump(int[] arr) {
        int n = arr.length;
        int jumps = 0;
        int curMax = 0, curReach = 0;

        for (int i = 0; i < n - 1; i++) {
            if (i + arr[i] > curMax) curMax = i + arr[i];
            if (i == curReach) {
                jumps++;
                curReach = curMax;
            }

            if (arr[i] == 0 && i == curMax) return -1;
        }
        return jumps;
    }
}
