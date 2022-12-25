package Array;

public class EqualSumSubArrays {

    static int totalSum(int arr[], int n) {

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum;
    }

    static boolean check(int[] a) {

        int n = a.length;
        int pref = 0;
        int total_sum = totalSum(a, n);

        for (int i = 0; i < n; i++) {
            pref += a[i];
            int suff = total_sum - pref;
            if (pref == suff)
                return true;

        }
        return false;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int[] a = { 2, 3, -1, 8, 4 };
        System.out.println(check(a));
    }
}
