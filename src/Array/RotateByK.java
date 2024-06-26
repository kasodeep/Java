package Array;

public class RotateByK {

    /**
     * @param a - It is the array under consideration.
     * @param k - It is the steps which the array must be rotated.
     */
    public static void rotate(int[] a, int k) {
        // In-Case : If k > a.length
        k %= a.length;

        reverse(a, 0, a.length - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
    }

    private static void reverse(int[] a, int i, int j) {
        int temp;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    // Time Complexity - O(n), Auxiliary Space - O(1)
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        rotate(arr, k);
    }
}
