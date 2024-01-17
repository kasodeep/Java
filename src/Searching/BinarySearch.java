package Searching;

public class BinarySearch {

    static boolean binarySearch(int[] a, int target) {
        int st = 0, end = a.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (target == a[mid]) {
                return true;
            } else if (target < a[mid]) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return false;
    }

    static boolean recursiveBinarySearch(int[] a, int st, int end, int target) {
        // Base Case
        if (st > end)
            return false;

        // Mid and Self-Work
        int mid = st + (end - st) / 2;
        if (target == a[mid])
            return true;
        else if (target > a[mid])
            return recursiveBinarySearch(a, mid + 1, end, target);
        else
            return recursiveBinarySearch(a, st, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 3));
    }
}
