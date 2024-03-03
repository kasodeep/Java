package Searching;

public class MountainArray {

    // It also works for multiple peak elements.
    public static int peakIndex(int[] a) {
        int st = 0, end = a.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (a[mid] < a[mid + 1]) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }
        return st;
    }

    public static int findPeakElement(int[] a) {
        int n = a.length;
        int st = 0, end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if ((mid == 0 || a[mid] > a[mid - 1]) && (mid == n - 1 || a[mid] > a[mid + 1])) {
                return mid;
            }

            if (a[mid] < a[mid + 1]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
