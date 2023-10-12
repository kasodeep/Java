package Array.Questions;

public class PeakIndexMountain {

    public static int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 2;

        while (low != high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

    }
}
