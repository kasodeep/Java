package Array;

public class MissingNumber {

    /**
     * 
     * @param arr  - It is the array in which a number is missing from 1-n..
     * @param size - It is the size of the array.
     */
    static void findMissing(int arr[], int size) {

        int i;
        for (i = 0; i < size; i++) {
            if (Math.abs(arr[i]) - 1 == size)
                continue;

            int index = Math.abs(arr[i]) - 1;
            arr[index] *= -1;
        }

        int ans = size + 1;
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                ans = i + 1;
        }
        System.out.println(ans);
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int arr[] = { 1, 3, 7, 5, 6, 2 };
        int n = arr.length;
        findMissing(arr, n);
    }
}
