package Daily.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubArrays {

    public static List<Boolean> checkArithmeticSubArrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int s = l[i];
            int e = r[i];
            int[] temp = Arrays.copyOfRange(nums, s, e + 1);

            if (check(temp)) list.add(true);
            else list.add(false);
        }
        return list;
    }

    public static boolean check(int[] arr) {
        Arrays.sort(arr);

        if (arr.length == 0 || arr.length == 1) {
            return true;
        } else {
            int d = arr[1] - arr[0];
            for (int i = 1; i < arr.length; i++) {
                if ((arr[i] - arr[i - 1]) != d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
