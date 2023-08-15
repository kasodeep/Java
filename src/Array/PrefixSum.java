package Array;

public class PrefixSum {

    /**
     * @param a - It is the array under consideration.
     * @return - It returns the prefixSum array.
     */
    static int[] prefixSum(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            a[i] += a[i - 1];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3};
        int[] ans = prefixSum(arr);

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
