package Array;

public class SecondLargest {

    /**
     * 
     * @param arr - It is the array under consideration.
     * @return - It returns the second largest element of the array.
     */
    public static int secondLargestValue(int[] arr) {

        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        // Find Largest
        for (int i = 0; i < n; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        // Find Second Largest
        for (int i = 0; i < n; i++) {
            if (arr[i] != max && arr[i] > smax) {
                smax = arr[i];
            }
        }
        return smax;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3, 2, 4, 5, 2, 1 };
        System.out.println(secondLargestValue(arr));
    }
}
