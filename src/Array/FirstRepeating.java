package Array;

import java.util.HashSet;

public class FirstRepeating {

    static int firstRepeated(int arr[], int n) {

        int num = -1;
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                num = arr[i];
                break;
            } else {
                set.add(arr[i]);
            }
        }

        return num;
    }

    // Time Complexity - O(n), Auxillary Space - O(1)
    public static void main(String[] args) {

        int arr[] = { 1, 5, 3, 4, 3, 5, 6 };
        int n = arr.length;
        System.out.println(firstRepeated(arr, n));
    }
}
