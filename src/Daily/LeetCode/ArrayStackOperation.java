package Daily.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ArrayStackOperation {

    public static List<String> buildArray(int[] target, int n) {
        int i = 1, j = 0;
        List<String> list = new ArrayList<>();
        boolean flag = false;

        while (j < target.length && i <= n) {
            if (target[j] == i) {
                if (flag) {
                    list.add("Pop");
                    list.add("Push");
                    flag = false;
                } else {
                    list.add("Push");
                }
                i++;
                j++;
            } else {
                if (flag) {
                    list.add("Pop");
                    list.add("Push");
                } else {
                    list.add("Push");
                    flag = true;
                }
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
