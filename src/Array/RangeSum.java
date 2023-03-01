package Array;

import java.util.Scanner;

public class RangeSum {

    /**
     * 
     * @param arr - It is the array whose prefix sum is to be calculated.
     */
    static void prefixSum(int arr[]) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
    }

    // Time Complexity - (n+q), Auxillary Space - O(1)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        int arr[] = { 0, 5, 2, 1, 4, 3 };
        prefixSum(arr);

        while (q >= 0) {
            int l, r;
            l = sc.nextInt();
            r = sc.nextInt();
            int ans = (arr[r] - arr[l - 1]);
            System.out.println(ans);
            q--;
        }
        sc.close();
    }
}
