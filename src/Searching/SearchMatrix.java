package Searching;

public class SearchMatrix {

    // Integers in Each Row are Sorted
    // Integers in Each Column are Sorted
    // O(m + n)
    static boolean searchMatrix2(int[][] a, int target) {
        int n = a.length, m = a[0].length;
        int i = 0, j = m - 1;

        while (i < n && j >= 0) {
            if (a[i][j] == target)
                return true;
            if (target < a[i][j])
                j--;
            else
                i++;
        }
        return false;
    }
}
