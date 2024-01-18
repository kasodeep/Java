package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortByBitCount {

    static void sortBySetBitCount(Integer[] arr, int n) {
        Arrays.sort(arr, new MyComparator());
    }

    public static class MyComparator implements Comparator<Integer> {

        static int countSetBits(int n) {
            if (n == 0) return 0;
            int cnt = 0;

            while (n > 0) {
                n = n & n - 1;
                cnt++;
            }
            return cnt;
        }

        @Override
        public int compare(Integer a, Integer b) {
            int countA = countSetBits(a);
            int countB = countSetBits(b);
            return Integer.compare(countB, countA);
        }
    }
}
