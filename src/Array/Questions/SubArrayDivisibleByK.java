package Array.Questions;

import java.util.HashMap;
import java.util.Map;

public class SubArrayDivisibleByK {

    static int longestSubArrayWthSumDivByK(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max_len = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // To handle negative values.
            int mod = ((sum % k) + k) % k;
            if (mod == 0) max_len = i + 1;

            if (!map.containsKey(mod))
                map.put(mod, i);
            else {
                int size = i - map.get(mod);
                max_len = Math.max(max_len, size);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int n = arr.length;
        int k = 3;
        System.out.println("Length = " + longestSubArrayWthSumDivByK(arr, n, k));
    }
}
