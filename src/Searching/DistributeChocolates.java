package Searching;

public class DistributeChocolates {

    static boolean isDivisionPossible(int[] a, int m, int mxChocoAllowed) {
        int numOfStudents = 1;
        int choc = 0;

        for (int j : a) {
            if (j > mxChocoAllowed)
                return false;

            if (choc + j <= mxChocoAllowed) {
                choc += j;
            } else {
                numOfStudents++;
                choc = j;
            }
        }

        return numOfStudents <= m;
    }

    static int distributeChocolates(int[] a, int m) {
        if (a.length < m)
            return -1;
        int ans = 0, st = 1, end = (int) 1e9;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isDivisionPossible(a, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 4, 2};
        int m = 3;
        System.out.println(distributeChocolates(a, m));
    }
}
