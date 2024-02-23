package Array;

public class ReversePairs {

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) temp[index++] = arr[left++];
        while (right <= high) temp[index++] = arr[right++];

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    private static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);

            count += countPairs(arr, low, mid, high);
            merge(arr, low, mid, high);
        }
        return count;
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
