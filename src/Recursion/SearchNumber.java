package Recursion;

public class SearchNumber {

    static int searchIndex(int arr[], int target, int n, int idx) {

        // Base Case
        if (idx >= n) {
            return -1;
        }

        // Self-Work
        if (arr[idx] == target)
            return idx;

        // Recursion
        return searchIndex(arr, target, n, idx + 1);
    }

    static boolean search(int arr[], int target, int n, int idx) {

        // Base Case
        if (idx >= n) {
            return false;
        }

        // Self-Work
        if (arr[idx] == target)
            return true;

        // Recursion
        return search(arr, target, n, idx + 1);
    }

    public static void main(String[] args) {

        int[] arr = { 3, 5, 8, 3, 5, 7, 9 };
        if (search(arr, 8, 7, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
