package Array;

public class EqualSumSubArrays {

    /**
     * 
     * @param arr - It is the array whos total sum is to be calculated.
     * @param n   - It is the length of the array.
     * @return - It returns the total sum of the array.
     */
    static int totalSum(int arr[], int n) {

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum;
    }

    /**
     * 
     * @param a - It is the array under consideration
     * @return - It returns if the array 'a' has any two subarrays whose sums are
     *         equal.
     */
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
