package BinarySearchTrees;

import java.util.*;

public class LeastGreaterRight {

    public static void main(String[] args) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        printArray(arr);
        solve(arr);
        printArray(arr);
    }

    public static void solve(int[] arr) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            s.add(arr[i]);

            // Returns value greater than arr[i].
            Integer it = s.higher(arr[i]);
            arr[i] = Objects.requireNonNullElse(it, -1);
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}

