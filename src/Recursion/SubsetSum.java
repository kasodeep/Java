package Recursion;

public class SubsetSum {

    static void sumSubset(int[] a, int n, int idx, int sum) {

        if (idx >= n) {
            System.out.println(sum);
            return;
        }
        sumSubset(a, n, idx + 1, sum);
        sumSubset(a, n, idx + 1, sum + a[idx]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        sumSubset(arr, 4, 0, 0);
    }
}
