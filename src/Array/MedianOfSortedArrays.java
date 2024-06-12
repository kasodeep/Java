package Array;

public class MedianOfSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            // We want to keep more elements on left.
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int leftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int leftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];

            int rightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            int rightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (leftX <= rightY && leftY <= rightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                } else {
                    return Math.max(leftX, leftY);
                }
            } else if (leftX > rightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
