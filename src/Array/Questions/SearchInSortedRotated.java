package Array.Questions;

public class SearchInSortedRotated {

    public static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (pivot == -1) {
            return BinarySearch(arr, target, 0, arr.length - 1);
        }

        if (arr[pivot] == target) return pivot;
        if (target >= arr[0]) {
            return BinarySearch(arr, target, 0, pivot - 1);
        }
        return BinarySearch(arr, target, pivot + 1, arr.length - 1);
    }

    static int BinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int findPivot(int[] arr) {
        int i;
        for (i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                break;

        if (i == arr.length) return -1;
        else return i;
    }

    public static void main(String[] args) {

    }
}
