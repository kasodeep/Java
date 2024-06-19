package Searching;

public class DaysToMakeMBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length)
            return -1;

        int right = -1, left = 1;
        for (int day : bloomDay) {
            right = Math.max(day, right);
        }

        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] bloom, int m, int k, int day) {
        int count = 0;
        for (int i = 0; i < bloom.length; ) {
            int temp = k;
            int j = i;

            while (j < bloom.length && temp > 0 && bloom[j] <= day) {
                j++;
                temp--;
            }

            if (temp == 0) count++;

            if (temp < k) i = j;
            else i = j + 1;

        }
        return count >= m;
    }
}
