package Array.Questions;

public class FindInMountainArray {

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex = findPeakIndex(1, length - 2, mountainArr);

        int increasingIndex = binarySearch(0, peakIndex, target, mountainArr, false);
        if (mountainArr.get(increasingIndex) == target) return increasingIndex;

        int decreasingIndex = binarySearch(peakIndex + 1, length - 1, target, mountainArr, true);
        if (mountainArr.get(decreasingIndex) == target) return decreasingIndex;
        return -1;
    }

    private static int findPeakIndex(int low, int high, MountainArray mountainArr) {
        while (low != high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int binarySearch(int low, int high, int target, MountainArray mountainArr, boolean reversed) {
        while (low != high) {
            int mid = low + (high - low) / 2;
            if (reversed) {
                if (mountainArr.get(mid) > target)
                    low = mid + 1;
                else
                    high = mid;
            } else {
                if (mountainArr.get(mid) < target)
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {

    }

    public static class MountainArray {
        int[] data;

        public MountainArray(int[] arr) {
            data = new int[arr.length];
            System.arraycopy(arr, 0, data, 0, arr.length);
        }

        public int get(int index) {
            return data[index];
        }

        public int length() {
            return data.length;
        }
    }
}
