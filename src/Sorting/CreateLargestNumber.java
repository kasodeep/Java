package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class CreateLargestNumber {

    static String printLargest(int n, String[] arr) {
        Arrays.sort(arr, new Comparator<>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        StringBuilder s = new StringBuilder();
        for (String str : arr) s.append(str);
        return s.toString();
    }
}
