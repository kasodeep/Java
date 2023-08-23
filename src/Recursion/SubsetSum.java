package Recursion;

public class SubsetSum {

    /**
     * @param a   - It is the original array
     * @param n   - It is the length of the array
     * @param idx - It points to the current index
     * @param sum - It is the current sum
     */
    static void sumSubset(int[] a, int n, int idx, int sum) {
        if (idx >= n) {
            System.out.print(sum + " ");
            return;
        }

        sumSubset(a, n, idx + 1, sum);
        sumSubset(a, n, idx + 1, sum + a[idx]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        sumSubset(arr, 4, 0, 0);
    }
}
