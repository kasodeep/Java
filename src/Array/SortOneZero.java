package Array;

public class SortOneZero {

    public static void sortZeroesAndOne(int[] a) {

        int n = a.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (a[i] == 1 && a[j] == 0) {
                a[i] = 0;
                a[j] = 1;
                i++;
                j--;

            }

            if (a[i] == 0)
                i++;
            if (a[j] == 1)
                j--;
        }
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int arr[] = { 0, 0, 1, 0, 1, 1, 0, 1, 0 };
        sortZeroesAndOne(arr);
    }
}
