package Array;

public class PairInSortedRotated {

    /**
     * 
     * @param arr - It is the array under cosideration.
     * @param n   - It is the length of the array.
     * @param x   - It is the sum of the pair which is to be found.
     * @return - It returns, if the pair is present or not in the array 'arr' whose
     *         sum is {x}.
     */
    static boolean pairInSortedRotated(int arr[], int n, int x) {

        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;

        // Smallest element Index
        int l = (i + 1) % n;

        // Largest element Index
        int r = i;

        while (l != r) {
            if (arr[l] + arr[r] == x)
                return true;
            if (arr[l] + arr[r] < x)
                l = (l + 1) % n;
            else
                r = (n + r - 1) % n;
        }
        return false;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int arr[] = { 11, 15, 6, 8, 9, 10 };
        int X = 16;
        int N = arr.length;

        if (pairInSortedRotated(arr, N, X))
            System.out.print("True");
        else
            System.out.print("False");
    }
}
