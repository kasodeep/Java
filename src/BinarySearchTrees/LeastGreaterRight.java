package BinarySearchTrees;

import java.util.*;

public class LeastGreaterRight {

    public static void solve(int[] arr) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            s.add(arr[i]);

            Integer it = s.higher(arr[i]);
            arr[i] = Objects.requireNonNullElse(it, -1);
        }
    }
}

