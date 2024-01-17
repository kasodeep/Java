package Searching;

public class SearchRotated {

    static int search(int[] a, int target) {
        int n = a.length - 1;
        int st = 0, end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] <= a[end]) {
                if (target > a[mid] && target <= a[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target >= a[st] && target < a[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(search(arr, 4));
    }
}
