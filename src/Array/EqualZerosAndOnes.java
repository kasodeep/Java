package Array;

import java.util.HashMap;

public class EqualZerosAndOnes {

    /**
     * 
     * @param arr - It is the array which contains zeros and ones.
     * @param n   - It is the length of the array.
     * @return - It returns the max_len of the array which has equal 0's and 1's.
     */
    static int maxLen(int arr[], int n) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int sum = 0;
        int max_len = 0;
        int ending_index = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {

            sum += arr[i];
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            if (map.containsKey(sum)) {
                if (max_len < i - map.get(sum)) {
                    max_len = i - map.get(sum);
                    ending_index = i;
                }
            } else
                map.put(sum, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int start_index = ending_index - max_len + 1;
        System.out.println(start_index + " to " + ending_index);
        return max_len;
    }

    // Time Complexity - O(n), Auxillary Space - O(n)
    public static void main(String[] args) {

        int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
        int n = arr.length;
        maxLen(arr, n);

    }
}
