package Greedy;

import java.util.Arrays;

public class MaximizeConsecutiveDifferences {
    
    public long maxSum(long[] arr, int n) {
        Arrays.sort(arr);
        
        long[] temp = new long[n];
        int j = 0;
        for (int i = 0; i < n; i += 2) {
            temp[i] = arr[j];
            j++;
        }

        int k = n - 1;
        for (int i = 1; i < n; i += 2) {
            temp[i] = arr[k];
            k--;
        }

        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += (Math.abs(temp[i] - temp[i + 1]));
        }

        sum += (Math.abs(temp[n - 1] - temp[0]));
        return sum;
    }
}
